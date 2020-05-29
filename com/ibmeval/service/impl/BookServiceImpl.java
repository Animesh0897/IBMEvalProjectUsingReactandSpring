package com.ibmeval.service.impl;

import java.util.Collection;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ibmeval.domain.Book;
import com.ibmeval.repository.BookRepository;
import com.ibmeval.service.IService;

@Service
public class BookServiceImpl implements IService<Book> {

	@Autowired
	private BookRepository bookRepository;

//	@Override
//	public Collection<Book> findAll() {
//		return bookRepository.findAll();
//	}

	public Page<Book> findAll(Pageable pageable,String searchText) {
		return bookRepository.findAllBooks(pageable,searchText);
	}

	public Page<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}


	@Override
	public Book findById(Long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public Book saveOrUpdate(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			bookRepository.deleteById(id);
			jsonObject.put("message", "Book deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}