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
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import InboxIcon from '@material-ui/icons/MoveToInbox';
import MailIcon from '@material-ui/icons/Mail';
import Paper from '@material-ui/core/Paper';
import Customer from './Customer'
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableBody from '@material-ui/core/TableBody';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';
import {Link} from 'react-router-dom';
import InputBase from '@material-ui/core/InputBase';
import SearchIcon from '@material-ui/icons/Search';
import { fade } from '@material-ui/core/styles/colorManipulator';
import CircularProgress from '@material-ui/core/CircularProgress';
const drawerWidth = 240;

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
    position:"relative",
    marginLeft:240,
    width:"77%"
},

appBar: {
  zIndex: theme.zIndex.drawer + 1,
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
  padding: theme.spacing.unit * 3,
},
toolbar: theme.mixins.toolbar,
});

class Category extends React.Component {
  state = {
    customers : "",
    completed:0
  }
  componentDidMount(){
    this.timer=setInterval(this.progress,20);
    this.callApi()
        .then(res=>this.setState({customers:res}))
        .catch(err=>console.log(err));

  }
  callApi=async()=>{
    const url = 'http://52.78.139.153:8080/categories/0'; 
    const response =await fetch(url);
    const body =await response.json();
    console.log(body);
    return body;
  }

  handlevaluechange=(e)=>{
      let nextState={};
      nextState[e.target.name]=e.taget.value;
      this.setState(nextState)
  }
  progress=()=>{
    const {completed} =this.state;
    this.setState({completed:completed>=100?0:completed+1})

  }

  render() {
    const { classes } = this.props;
  

    return (
      <div className={classes.root}>
      <CssBaseline />
      <AppBar position="fixed" className={classes.appBar}>
        <Toolbar>
          <Typography variant="h6" color="inherit" noWrap>
          <Link to="/" style={{ textDecoration: 'none', color:"white" }}>ALL-EAT</Link>
          </Typography>
          <div className={classes.search}>
              <div className={classes.searchIcon}>
                <SearchIcon />
              </div>
              <InputBase 
                placeholder="Search…"
                classes={{
                  root: classes.inputRoot,
                  input: classes.inputInput,
                }}
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
          {['한식', '일식', '중식', '양식'].map((text, index) => (
            <ListItem component={Link} to={"/categories/"+index} button key={text}>
              <ListItemText primary={text} style={{textAlign: 'center'}}/>
            </ListItem>
          ))}
        </List>
        <Divider />
        
      </Drawer>


      <main className={classes.content}>
        <div className={classes.toolbar} />
        <Paper position="relative">
        <Table className={classes.table}>
          <TableHead>
          <TableRow>
            <TableCell>순위</TableCell>
            <TableCell>가게 이름</TableCell>
            <TableCell>현재 테이블 수</TableCell>
            <TableCell>전체 테이블 수</TableCell>
            <TableCell>대기 시간</TableCell>
           </TableRow>
          </TableHead>
          <TableBody>
          {this.state.customers.length>0 ? 
          this.state.customers.map((c,i)=>{
              return <Customer key={i}
              rank={c.rank}
              name={c.name}
              currentTable={c.currentTable}
              totalTable={c.totalTable}
              remainTime={c.remainTime}
              />}): 
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
        </main>
    
      </div>
    );
  }
}

Category.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles, { withTheme: true })(Category);