import React, { Component } from 'react';


class TodoApp extends React.Component {
    constructor() {
      super();
      this.state = {
        todos: ['a','b','c','d','e','f','g','h','i','j','k'],//리스트 목록
        currentPage: 1,//현재 페이지
        todosPerPage: 8//한 페이지에 보여줄 페이지 목록
      };
      this.handleClick = this.handleClick.bind(this);
    }
  
    handleClick(event) {
      this.setState({
        currentPage: Number(event.target.id)
      });
    }
  
    render() {
      const { todos, currentPage, todosPerPage } = this.state;
  
      // Logic for displaying todos
      const indexOfLastTodo = currentPage * todosPerPage;//ex) 1*10
      const indexOfFirstTodo = indexOfLastTodo - todosPerPage;//ex)10-10
      const currentTodos = todos.slice(indexOfFirstTodo, indexOfLastTodo);//[0,10)까지 배열 잘름
  
      const renderTodos = currentTodos.map((todo, index) => {
        return <li key={index}>{todo}</li>;//렌더링 해주기
      });
  
      // Logic for displaying page numbers
      const pageNumbers = [];
      for (let i = 1; i <= Math.ceil(todos.length / todosPerPage); i++) {
        pageNumbers.push(i);
      }
  
      const renderPageNumbers = pageNumbers.map(number => {
        return (
          <div style={ {marginLeft:240}}>
          <button
            key={number}
            id={number}
            onClick={this.handleClick}
            style={{float:"left"}}
          >
            {number}
          </button>
          </div>
        );
      });
  
      return (
        <div>
          <ul>
            {renderTodos}
          </ul>
          <ul id="page-numbers" >
            {renderPageNumbers}
          </ul>
        </div>
      );
    }
  }
  
  
export default TodoApp;