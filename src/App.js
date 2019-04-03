import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Paper from '@material-ui/core/Paper'
import Customer from './components/Customer'
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableBody from '@material-ui/core/TableBody';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';
import {withStyles} from '@material-ui/core/styles'

const styles=theme=>({
  root:{
      width:'100%',
      marginTop:theme.spacing.unit*3,
      overflowX:'auto'


  },
  table:{
      minWidth:1080
  }
})


// const customers=[
//   {
//   'rank':'1',
//   'image':'https://placeimg.com/64/64/1',
//    'name':'짜장 ',
//    'table':'3',
//    'time':'4'
//   },
//   {
//     'rank':'2',
//     'image':'https://placeimg.com/64/64/2',
//      'name':'짬뽕',
//      'table':'4',
//      'time':'5'
//   }
// ]


class App extends Component {

  state={
    customers: ""
  }
  componentDidMount(){
    this.callApi()
      .then(res=>this.setState({customers:res}))
      .catch(err=>console.log(err));
  }
  callApi=async()=>{
    const response =await fetch('/categories');
    const body =await response.json();
    return body;
  }

  render() {
    const {classes}=this.props;
    return (
      <Paper className={classes.root}>
        <Table className={classes.table}>
          <TableHead>
          <TableRow>
            <TableCell>순위</TableCell>
            <TableCell>가게 이미지</TableCell>
            <TableCell>가게 이름</TableCell>
            <TableCell>테이블 수</TableCell>
            <TableCell>대기 시간</TableCell>
           </TableRow>
          </TableHead>
          <TableBody>
        {
           this.state.customer? this.state.customers.map(c=>{
            return(
              <Customer
              rank={c.rank}
              image={c.image}
              name={c.name}
              table={c.table}
              time={c.time}

              />

            )
          }):""



        }
        </TableBody>
        </Table>
      </Paper> 
    );
  }
}

export default withStyles(styles)(App);
