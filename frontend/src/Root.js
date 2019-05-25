import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import  Main  from './Main';
import Category1 from './components/Category1';
import Modal from './components/Modal'
import { BrowserRouter } from 'react-router-dom';

class Root extends Component {
    render() {
        return (
         <BrowserRouter>
                <Route exact path="/categories/:categoriesId" component={Category1}/>
                <Route exact path="/" component={Main}/>
        </BrowserRouter>
        );
    }
}

export default Root;