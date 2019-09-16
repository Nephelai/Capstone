import React from "react";
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';
import StarRatingComponent from './StarRatingComponent'
//모듈부분

class Customer extends React.Component{
    render(){
        return(
            <TableRow>
            <TableCell>{this.props.comment}</TableCell>
            <TableCell> <div style={{fontSize: 20}}>
          <StarRatingComponent
            name="app6"
            starColor="#ffb400"
            emptyStarColor="#ffb400"
            value={this.props.grade}
    
            renderStarIcon={(index, value) => {
              return (
                <span>
                  <i className={index <= value ? 'fa fa-star' : 'fa fa-star-o'} />
                </span>
              );
            }}
            renderStarIconHalf={() => {
              return (
                <span>
                {/* <span style={{position: 'absolute'}}><i className="far fa-star" /></span> */}
                  <span><i className="fa fa-star-half-full" /></span>
                </span>
              );
            }}
           />
        </div></TableCell>
            <TableCell>{this.props.id}</TableCell>
            <TableCell>{this.props.timestamp}</TableCell>
            </TableRow>
        )
    }
}

export default Customer