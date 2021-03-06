import React from 'react';
import './App.css';

import {Provider} from 'react-redux';
import store from './services/store';

import {Container, Row, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

import NavigationBar from './components/NavigationBar';
import Welcome from './components/Welcome';
import Book from './components/Book';
import BookList from './components/BookList';
import UserList from './components/UserList';
import Footer from './components/Footer';

export default function App() {

  const heading = "Welcome to Book Guide";
  const quote = "Made For Evaluation";
  const footer = "Animesh Rai";

  return (
    <Router>
        <NavigationBar/>
        <Container>
            <Row>
                <Col lg={12} className={"margin-top"}>
                    <Switch>
                        <Route path="/" exact component={() => <Welcome heading={heading} quote={quote} footer={footer}/>}/>
                        <Route path="/add" exact component={Book}/>
                        <Route path="/edit/:id" exact component={Book}/>
                        <Route path="/list" exact component={BookList}/>
                        <Route path="/users" exact component={() =>
                            <Provider store={store}><UserList/></Provider>}/>
                    </Switch>
                </Col>
            </Row>
        </Container>
        <Footer/>
    </Router>
  );
}
