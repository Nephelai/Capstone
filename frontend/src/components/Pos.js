import React, { Component } from 'react';
import Button from '@material-ui/core/Button';
//모듈부분


class Pos extends Component {

    constructor(props)
    {
        super(props);
    }

    handlepluschange=(e)=>{
        let url=`/api/increment/1/3`
        window.alert('주문이 접수되었습니다')
        this.callApi(url)
    }

    handleminuschange=(e)=>{
        let url=`/api/decrement/1/3`
        this.callApi(url)
        window.alert('결제가 완료되었습니다')
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