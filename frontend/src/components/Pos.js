import React, { Component } from 'react';
import Button from '@material-ui/core/Button';



class Pos extends Component {
    
    constructor(props)
    {
      super(props);
    }
   
    handlepluschange=(e)=>{
    let url=`http://15.164.189.88:8080/increment/1/3`
    this.callApi(url)
    }
   
    handleminuschange=(e)=>{
    let url=`http://15.164.189.88:8080/decrement/1/3`
    this.callApi(url)
   }
   
   callApi=async(url)=>{
    const response =await fetch(url);
    const body =await response.json();
    console.log(body);
    return body;
  }

   
   
   
    render() {
   
        return (
            <div>
        <Button onClick={this.handlepluschange}>
        주문
      </Button>
         
      <Button onClick={this.handleminuschange}>
        결제
      </Button>
       </div>
        )
    }
}

export default Pos;