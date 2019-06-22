import React, { Component } from 'react';

class Pos extends Component {
    
    constructor(props)
    {
      super(props);
    }
   
    handlepluschange=(e)=>{
    let url=`http://15.164.118.54:8080/increment/1/3`
    this.callApi(url)
    }
   
    handleminuschange=(e)=>{
    let url=`http://15.164.118.54:8080/decrement/1/3`
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
         <button onClick={this.handlepluschange}> 
         테이블 증가
         </button>
         
         <button onClick={this.handleminuschange}> 
         테이블 감소
         </button>
       </div>
        )
    }
}

export default Pos;