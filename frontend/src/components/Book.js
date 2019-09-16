import React from 'react';
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import MuiDialogTitle from '@material-ui/core/DialogTitle';
import MuiDialogContent from '@material-ui/core/DialogContent';
import MuiDialogActions from '@material-ui/core/DialogActions';
import IconButton from '@material-ui/core/IconButton';
import CloseIcon from '@material-ui/icons/Close';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';
import {post} from 'axios'
import Table from '@material-ui/core/Table';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';
//모듈부분

const DialogTitle = withStyles(theme => ({
  root: {
    borderBottom: `1px solid ${theme.palette.divider}`,
    margin: 0,
    padding: theme.spacing.unit * 2,
    width:'300',
    height:'300'
  },
  closeButton: {
    position: 'absolute',
    right: theme.spacing.unit,
    top: theme.spacing.unit,
    color: theme.palette.grey[500],
  },
}))(props => {
  const { children, classes, onClose } = props;
  return (
    <MuiDialogTitle disableTypography className={classes.root}>
      <Typography variant="h6">{children}</Typography>
      {onClose ? (
        <IconButton aria-label="Close" className={classes.closeButton} onClick={onClose}>
          <CloseIcon />
        </IconButton>
      ) : null}
    </MuiDialogTitle>
  );
});

const DialogContent = withStyles(theme => ({
  root: {
    margin: 0,
    padding: theme.spacing.unit * 2,
    width:'300',
    height:'300'

  },
}))(MuiDialogContent);

const DialogActions = withStyles(theme => ({
  root: {
    borderTop: `1px solid ${theme.palette.divider}`,
    margin: 0,
    padding: theme.spacing.unit,
  
  },
}))(MuiDialogActions);

class CustomizedDialogDemo extends React.Component {
  constructor(props) {

    super(props);
    this.state = {
    open: false,
    bounds: undefined,
    userName:'',
    userCount:'1',
    userPhone:''
  };

}
  handleClickOpen = () => {
    this.setState({
      open: true,
      userName:'',
      userCount:'1',
      userPhone:''
    });
  };

  handleClose = (e) => {
    e.stopPropagation();
   
    this.setState({ open: false });
  };
  handleFormSubmit=(e)=> {

    e.preventDefault()
    window.alert("등록되었습니다.")
    this.handlechange()
    .then((response) => {
    console.log(response.data);
    })
    
    this.setState({
    userName: '',
    userCount: '1',
    userPhone: '', 
    open: false
    
    })
    
    }
    
    handlechange=()=>{
    const url='/api/email'
    const formData = new FormData();
    formData.append('id', this.props.id)
    formData.append('name', this.state.userName)
    formData.append('number', this.state.userCount)
    formData.append('phone', this.state.userPhone)
    const config = {
      headers: {
      'content-type': 'application/json'
      }
      }
      
      for (var value of formData.values()) {
  
        console.log(value);
      
      }
      var object = {};
      formData.forEach(function(value, key){
          object[key] = value;
      });
      var json = JSON.stringify(object);
      return post(url, json, config)
    }
    handleValueChange=(e)=> {

    let nextState = {};
    
    nextState[e.target.name] = e.target.value;
    
    this.setState(nextState);
    
    }
    
    
    
  render() {
    const {markers} = this.state

    return (
      <div backdrop="static">
        <Button variant="outlined" color="secondary" onClick={this.handleClickOpen}>
          예약
        </Button>
        <Dialog
          onClose={this.handleClose}
          aria-labelledby="customized-dialog-title"
          open={this.state.open}
        >
          <DialogTitle id="customized-dialog-title" onClose={this.handleClose} style={{ width:'300',height:'300'}}>
            예약 정보
          </DialogTitle>
          <DialogContent>
         <h1>{this.props.name}</h1>
         
          <div>
         

          <TextField label="이름" type="text" name="userName" value={this.state.userName} onChange={this.handleValueChange} /><br/>
          <TextField label="휴대폰 번호" type="tel" name="userPhone" value={this.state.userPhone} onChange={this.handleValueChange} /><br/>
          <Table>
          <TableRow>
              <TableCell>
          예약자 수: <input type="number" name="userCount" min={1} max={5} defaultValue={1} value={this.state.userCount} onChange={this.handleValueChange} /><br/>
          </TableCell>
          </TableRow>
          </Table>
          <Button variant="contained" color="primary" style={{marginTop:20}}onClick={this.handleFormSubmit}>등록</Button>
         
          </div>
              
          </DialogContent>
          <DialogActions>
            <Button onClick={this.handleClose} color="primary">
              닫기
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    );
  }
}

export default CustomizedDialogDemo;