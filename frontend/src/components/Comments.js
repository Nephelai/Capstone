import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import CssBaseline from '@material-ui/core/CssBaseline';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import Paper from '@material-ui/core/Paper';
import Customer from './Customer'
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableBody from '@material-ui/core/TableBody';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';
import {Link,NavLink} from 'react-router-dom';
import InputBase from '@material-ui/core/InputBase';
import SearchIcon from '@material-ui/icons/Search';
import { fade } from '@material-ui/core/styles/colorManipulator';
import CircularProgress from '@material-ui/core/CircularProgress';
import {post} from 'axios'
import Disqus from './Disqus'
import StarRatingComponent from './StarRatingComponent'

const drawerWidth = 240;

const customStyles = {
  ul: {
      backgroundColor: 'white',
      marginLeft: '50%'
  },
 
  a: {
      color: 'blue',
      border: '1px solid black',
  
  }
};
const styles = theme => ({
  root: {
    width:'100%',
    minwidth:1080

  },
  progress: {
    margin: theme.spacing.unit * 2,
  },
  search: {
    position: 'relative',
    borderRadius: theme.shape.borderRadius,
    backgroundColor: fade(theme.palette.common.white, 0.15),
    '&:hover': {
      backgroundColor: fade(theme.palette.common.white, 0.25),
    },
    marginLeft: 0,
    width: '100%',
    [theme.breakpoints.up('sm')]: {
      marginLeft: theme.spacing.unit,
      width: 'auto',
    },
  },
  searchIcon: {
    width: theme.spacing.unit * 9,
    height: '100%',
    position: 'absolute',
    pointerEvents: 'none',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  },
  inputRoot: {
    color: 'inherit',
    width: '100%',
  },
  inputInput: {
    paddingTop: theme.spacing.unit,
    paddingRight: theme.spacing.unit,
    paddingBottom: theme.spacing.unit,
    paddingLeft: theme.spacing.unit * 10,
    transition: theme.transitions.create('width'),
    width: '100%',
    [theme.breakpoints.up('sm')]: {
      width: 120,
      '&:focus': {
        width: 200,
      },
    },
  },
table:{
    paddingTop:0,
    marginLeft:240,
    width:"77%"
},

appBar: {
  zIndex: theme.zIndex.drawer + 1,
  backgroundColor: "#d11507",
  marginBottom:0
},
drawer: {
  width: drawerWidth,
  flexShrink: 0,
  
},
drawerPaper: {
  width: drawerWidth,
},
content: {
  flexGrow: 1,
  paddingTop:0
},
toolbar: theme.mixins.toolbar,

});

const activeStyle = {
  backgroundColor: '#D8D8D8',
};


class Comments extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
        user_id:'',
        text:'',
        password:'',
        person:'',
        rating_half_star: 3.5,
        currentPage: 1,//현재 페이지
        todosPerPage: 10,//한 페이지에 보여줄 페이지 목록
        activePage: 1,
        completed:0,
    };
    }
    onStarClickHalfStar=(nextValue, prevValue, name, e)=> {
      const xPos = (e.pageX - e.currentTarget.getBoundingClientRect().left) / e.currentTarget.offsetWidth;
  
      if (xPos <= 0.5) {
        nextValue -= 0.5;
      }
  
      console.log('name: %s, nextValue: %s, prevValue: %s', name, nextValue, prevValue);
      // console.log(e);
      this.setState({rating_half_star: nextValue});
    }
    componentDidMount(){
        this.stateRefresh();
        this.timer=setInterval(this.progress,20);

    }
    progress=()=>{
      const {completed} =this.state;
      this.setState({completed:completed>=100?0:completed+1})
  
    }
    callApi=async()=>{
      console.log(this.props.match.params.storeId)
      const url=`http://15.164.189.88:8080/comments/${this.props.match.params.storeId}`
      const response =await fetch(url);
      const body =await response.json();
      console.log(body);
      return body;
    }

    stateRefresh=()=> {
      this.setState({
        person:''  
      });
    this.callApi()
    .then(res => this.setState({person: res}))
    .catch(err => console.log(err));
      }
        
      
    handleFormSubmit=(e)=> {
    e.preventDefault()
    this.addComments()
    .then((response) => {
    console.log(response.data);
    this.stateRefresh()
    })
    
    }
  
    handleValueChange=(e)=> {
    let nextState = {};
    nextState[e.target.name] = e.target.value;
    this.setState(nextState);
    }
    addComments=()=>{
    const url = `http://15.164.189.88:8080/comments/${this.props.match.params.storeId}`;
    const formData = new FormData();
    formData.append('user_id', this.state.id)
    formData.append('user_pw', this.state.password)
    formData.append('comments', this.state.text)
    formData.append('grade', this.state. rating_half_star)
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
    handleClick=(event)=> {
      this.setState({
        currentPage: Number(event.target.id)
      });
    }

  render() {
    const { classes } = this.props;
    const { rating } = this.state;
    const { todos, currentPage, todosPerPage } = this.state;
  
      
    const indexOfLastTodo = currentPage * todosPerPage;//ex) 1*10
    const indexOfFirstTodo = indexOfLastTodo - todosPerPage;//ex)10-10
    
    const pageNumbers = [];
    for (let i = 1; i <= Math.ceil(this.state.person.length / todosPerPage); i++) {
      pageNumbers.push(i);
    }
    const renderPageNumbers = pageNumbers.map(number => {
      return (
        <div style={ {marginLeft:'50%'}}>
        <button
          key={number}
          id={number}
          onClick={this.handleClick}
          style={{float:"left",textAlign:"center"}}
        >
          {number}
        </button> 
        </div>
      );
    });
  
      
      
    const filteredComponents = (data) => {
      const date_ascending=(a, b)=> {
        var dateA = new Date(a['time']).getTime();
        var dateB = new Date(b['time']).getTime();
        return dateB > dateA ? 1 : -1;
        };
      data=data.sort(date_ascending);

    const currentTodos = data.slice(indexOfFirstTodo, indexOfLastTodo);//[0,10)까지 배열 잘름
      
      return currentTodos.map((c,i)=>{
        return <Disqus
        id={c.user_id}
        grade={c.grade}
        comment={c.comment}
        timestamp={c.time}
        />})
    }
      
    return (
      <div className={classes.root}>
      <CssBaseline />
      <AppBar position="fixed" className={classes.appBar}>
        <Toolbar>
          <Typography variant="h6" color="inherit" noWrap>
          <Link to="/" style={{ textDecoration: 'none', color:"white" }}>ALL-EAT</Link>
          </Typography>
          <div className={classes.search} >
              <div className={classes.searchIcon}>
               <Link to="/categories/4" style={{ textDecoration: 'none', color:"white" }}><SearchIcon/></Link>
              </div>
              <InputBase 
                ref={this.InputBase}
                placeholder="검색"
                classes={{
                  root: classes.inputRoot,
                  input: classes.inputInput,
                }}
                name="searchKeyword"
                value={this.state.searchKeyword}
                onChange={this.handlevaluechange}
              />
            </div>
        </Toolbar>
      </AppBar>
      
      <Drawer
        className={classes.drawer}
        variant="permanent"
        classes={{
          paper: classes.drawerPaper,
        }}
      >
        <div className={classes.toolbar} />
        <List>
          {['한식', '중식', '일식', '양식','분식','전체'].map((text, index) => (
    
            <ListItem component={NavLink} to={"/categories/"+index} activeStyle={activeStyle} button key={text}>
              <ListItemText primary={text} style={{textAlign: 'center'}}/>
            </ListItem>
          ))}
        </List>
        <Divider />
        
      </Drawer>
<div style={{position:'relative',marginLeft:300,marginTop:100}}>

<Table>
  <TableRow>
    <TableCell style={{fontSize:20}}>{this.props.location.state.name}</TableCell>

  </TableRow>
  <TableRow>
  <TableCell><input type="text" placeholder="ID를 입력하세용~~" name="id" value={this.state.id} onChange={this.handleValueChange}/></TableCell> 
  </TableRow>
  <TableRow>
  <TableCell><input type="password" placeholder="password를 입력하세용~~" name="password" value={this.state.password} onChange={this.handleValueChange}/></TableCell> 
  </TableRow>
  <h2>Rating from state: {this.state.rating_half_star}</h2>
  <div style={{fontSize: 20}}>
          <StarRatingComponent
            name="app6"
            starColor="#ffb400"
            emptyStarColor="#ffb400"
            value={this.state.rating_half_star}
            onStarClick={this.onStarClickHalfStar}
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
        </div>
  <TableRow>
  <TableCell><textarea name="text" placeholder="내용" style={{width: '450px', height: '100px'}} value={this.state.text} onChange={this.handleValueChange}/>
  </TableCell> 
   </TableRow>
   <TableRow>
   <TableCell>
   <button type="submit" onClick={this.handleFormSubmit}>등록</button>
   </TableCell>
   </TableRow>


     {this.state.person.length>0?
       filteredComponents(this.state.person) : 
       <TableRow>       
         <TableCell colSpan="6" align="center">
           등록된 댓글이 없습니다.
           </TableCell>
       </TableRow>
       }
</Table>
<ul id="page-numbers" >
            {renderPageNumbers}
      </ul>
</div>
</div>
    )
  
}}
Comments.propTypes = {
    classes: PropTypes.object.isRequired,
  };
  

  export default withStyles(styles, { withTheme: true })(Comments);