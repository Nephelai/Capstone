import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import  Main  from './Main';
import Category from './components/Category';
import { BrowserRouter } from 'react-router-dom';

class Root extends Component {
    render() {
        return (
         <BrowserRouter>
                <Route exact path="/" component={Main}/>
                <Route path="/categories" component={Category}/>
        </BrowserRouter>
        );
    }
}

export default Root;