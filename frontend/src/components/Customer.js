import React from "react";
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';
import Modal from './Modal'
import Book from './Book'
import {Link} from 'react-router-dom'
class Customer extends React.Component{
    render(){
        return(
          
            <TableRow>
            <TableCell>{this.props.rank}</TableCell>
            <TableCell component={Link} to={{
            pathname:`/comments/${this.props.id}`,
            state:{
                name:this.props.name,
            }
        }}>{this.props.name}</TableCell>
            <TableCell>{this.props.currentTable}</TableCell>
           
            <TableCell>{this.props.remainTime}</TableCell>
            <TableCell>{this.props.grade}</TableCell> 
            <TableCell><Modal name={this.props.name} lat={this.props.lat} lng={this.props.lng} stateRefresh={this.props.stateRefresh}/></TableCell>
            <TableCell><Book id={this.props.id} name={this.props.name} stateRefresh={this.props.stateRefresh}/></TableCell> 
            </TableRow>
        )
    }
}

export default Customer