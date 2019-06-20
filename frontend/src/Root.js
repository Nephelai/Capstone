import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import  Main  from './Main';
import Category1 from './components/Category1';
import Page from './components/Page'
import { BrowserRouter } from 'react-router-dom';
import Pos from './components/Pos'
import Comments from './components/Comments'
import Book from './components/Book'

class Root extends Component {
    render() {
        return (
         <BrowserRouter>
                <Route exact path="/categories/:categoriesId" component={Category1}/>
                <Route exact path="/" component={Main}/>
                <Route exact path="/page" component={Page}/>
                <Route exact path="/pos" component={Pos}/>
                <Route exact path="/comments/:storeId" component={Comments}/>
                <Route exact path="/book" component={Book}/>
               
        </BrowserRouter>
        );
    }
}

export default Root;