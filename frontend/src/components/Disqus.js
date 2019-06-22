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
            <TableCell>{this.props.id}</TableCell>
            <TableCell>{this.props.grade}</TableCell>
            <TableCell>{this.props.timestamp}</TableCell>
            <TableCell>{this.props.comment}</TableCell> 
            </TableRow>
        )
    }
}

export default Customer