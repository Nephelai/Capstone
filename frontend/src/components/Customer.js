import React from "react";
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';
import Modal from './Modal'

class Customer extends React.Component{
    render(){
        return(
            <TableRow>
            <TableCell>{this.props.rank}</TableCell>
            <TableCell>{this.props.name}</TableCell>
            <TableCell>{this.props.currentTable}</TableCell>
            <TableCell>{this.props.totalTable}</TableCell>
            <TableCell>{this.props.remainTime}</TableCell>
            <TableCell><Modal/></TableCell>
            </TableRow>
        )
    }
}

export default Customer