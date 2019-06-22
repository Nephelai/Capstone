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
    width:"83%"
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

class Category extends React.Component {
  constructor(props)
  {
    super(props);
    this.state = {
    customers : "",
    completed:0,
    lastId: null,
    activePage: 1,
    searchKeyword: '',
    currentPage: 1,//현재 페이지
    todosPerPage: 10,//한 페이지에 보여줄 페이지 목록
    value: 1  
  }

  this.stateRefresh = this.stateRefresh.bind(this);
   
}

  componentDidMount(){
    this.stateRefresh()
    this.timer2=setInterval(this.stateRefresh,100000)
    this.timer=setInterval(this.progress,20);
  }
  componentDidUpdate(prevProps, prevState) {
    if (this.state.lastId !== prevProps.match.params.categoriesId) {
      this.stateRefresh();  
    }
  }
  static getDerivedStateFromProps(nextProps, prevState) {
   
    if (prevState.lastId !== nextProps.match.params.categoriesId) {
      console.log(nextProps.match.params.categoriesId)
      return { lastId:  nextProps.match.params.categoriesId};
    }

    return null;
    }
  callApi=async()=>{
    console.log(this.props.match.params.categoriesId)
    const url=`http://15.164.118.54:8080/categories/${this.props.match.params.categoriesId}`
    const response =await fetch(url);
    const body =await response.json();
    console.log(body);
    return body;
  }

  handlevaluechange=(e)=>{
      let nextState={};
      nextState[e.target.name]=e.target.value;
      this.setState(nextState)
  }
  handleClick=(event)=> {
    this.setState({
      currentPage: Number(event.target.id)
    });
  }
  progress=()=>{
    const {completed} =this.state;
    this.setState({completed:completed>=100?0:completed+1})

  }
  stateRefresh() {
    this.setState({
      customers: '',
      completed: 0,
      frank:''
      });
  this.callApi()
  .then(res => this.setState({customers: res}))
  .catch(err => console.log(err));
    }
      
    
    handleChange=(event)=> {
        this.setState({value: event.target.value},()=>{console.log(this.state.value)})      
      } 

  render() {
    const { classes } = this.props;
    const { todos, currentPage, todosPerPage } = this.state;
  
      
      const indexOfLastTodo = currentPage * todosPerPage;//ex) 1*10
      const indexOfFirstTodo = indexOfLastTodo - todosPerPage;//ex)10-10
      
      const pageNumbers = [];
      for (let i = 1; i <= Math.ceil(this.state.customers.length / todosPerPage); i++) {
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
      let arr=[]
      if(this.state.value==1)
      data =data.sort((a,b)=>(b.totalTable-b.currentTable)-(a.totalTable-a.currentTable))
      
      if(this.state.value==2)
      data =data.sort((a,b)=>(b.grade-a.grade))
     
      for(var i=1;i<=data.length;i++)
      {
          arr[data[i-1].id]=i
      }
            
      data = data.filter((c) => {
        return c.name.indexOf(this.state.searchKeyword) > -1;
      });
      const currentTodos = data.slice(indexOfFirstTodo, indexOfLastTodo);//[0,10)까지 배열 잘름
  
      return currentTodos.map((c,i)=>{
        return <Customer 
        stateRefresh={this.stateRefresh}
        key={i}
        id={c.id}
        rank={arr[c.id]}
        name={c.name}
        currentTable={c.totalTable-c.currentTable}
        totalTable={c.totalTable}
        remainTime={c.remainTime}
        grade={c.grade}
        lat={c.lat}
        lng={c.lng}
        />
      })
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


      <main className={classes.content}>
        <div className={classes.toolbar} />
        <select style={{position:"relative",marginLeft:1200,marginTop:10,width:150,marginBottom:10}}
        onChange={this.handleChange}>
            <option selected value="1">좌석 순</option>
            <option value="2">평점 순</option>
        </select>
        <Paper position="relative">
        <Table className={classes.table}>
          <TableHead>
          <TableRow >
            <TableCell style={{fontSize:20}}>순위</TableCell>
            <TableCell style={{fontSize:20}}>가게 이름</TableCell>
            <TableCell style={{fontSize:20}}>이용가능 테이블 수</TableCell>
            <TableCell style={{fontSize:20}}>대기 시간</TableCell>
            <TableCell style={{fontSize:20}}>평점</TableCell>
            <TableCell style={{fontSize:20}}>위치 정보</TableCell>
            <TableCell style={{fontSize:20}}>예약하기</TableCell>
           </TableRow>
          </TableHead>
          <TableBody>
          {this.state.customers.length>0 ? 
         filteredComponents(this.state.customers) : 
          <TableRow>
            <TableCell colSpan="6" align="center">
              <CircularProgress
                   className={classes.progress}
                   variant="determinate"
                   value={this.state.completed}
                 />
            </TableCell>
          </TableRow>
          }
          
       </TableBody>
        </Table>
      </Paper>
      <ul id="page-numbers" >
            {renderPageNumbers}
      </ul>
        </main>
      </div>
    );
  }
}

Category.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles, { withTheme: true })(Category);