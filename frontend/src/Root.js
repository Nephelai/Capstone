import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import  Main  from './Main';
import Category1 from './components/Category1';
import Page from './components/Page'
import { BrowserRouter } from 'react-router-dom';
import Pos from './components/Pos'
class Root extends Component {
    render() {
        return (
         <BrowserRouter>
                <Route exact path="/categories/:categoriesId" component={Category1}/>
                <Route exact path="/" component={Main}/>
                <Route exact path="/page" component={Page}/>
                <Route exact path="/pos" component={Pos}/>
        </BrowserRouter>
        );
    }
}

export default Root;