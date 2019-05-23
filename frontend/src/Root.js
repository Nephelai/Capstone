import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import  Main  from './Main';
import Category1 from './components/Category1';
import Category2 from './components/Category2';
import Category3 from './components/Category3';
import Category4 from './components/Category4';
import Category5 from './components/Category5';
import Category6 from './components/Category6';
import Modal from './components/Modal'
import { BrowserRouter } from 'react-router-dom';

class Root extends Component {
    render() {
        return (
         <BrowserRouter>
                <Route exact path="/categories/:categoriesId" component={Category1}/>
                <Route exact path="/" component={Main}/>
                <Route path="/modal" component={Modal}/>    
        </BrowserRouter>
        );
    }
}

export default Root;