package com.ibmeval.service;

import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<T> {
//	Collection<T> findAll();

	Page<T> findAll(Pageable pageable);

	Page<T> findAll(Pageable pageable, String searchText);

	T findById(Long id);

	T saveOrUpdate(T t);

	String deleteById(Long id);
}