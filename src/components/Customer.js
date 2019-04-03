import React from "react";
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell'

class Customer extends React.Component{
    render(){
        return(
            <TableRow>
            <TableCell>{this.props.rank}</TableCell>
            <TableCell> <img src={this.props.image} alt="profile"/></TableCell>
            <TableCell>{this.props.name}</TableCell>
            <TableCell>{this.props.table}</TableCell>
            <TableCell>{this.props.time}</TableCell>
            </TableRow>
        )
    }
}

export default Customer