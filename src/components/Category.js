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
import MailIcon from '@material-ui/icons/Mail';import Paper from '@material-ui/core/Paper'
import Customer from './Customer'
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableBody from '@material-ui/core/TableBody';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';
import {Link} from 'react-router-dom';


const drawerWidth = 240;

const styles = theme => ({
  root: {
    width:'100%',
    minwidth:1080

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
    customers:"",
    open: false,
  };

  componentDidMount(){
    this.callApi()
      .then(res=>this.setState({customers:res}))
      .catch(err=>console.log(err));
  }
  callApi=async()=>{
    const response =await fetch('/categories');
    const body =await response.json();
    return body;
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
            <ListItem button key={text}>
              <ListItemIcon>{index % 2 === 0 ? <InboxIcon /> : <MailIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
        <List>
          {['치킨', '피자', '분식'].map((text, index) => (
            <ListItem button key={text}>
              <ListItemIcon>{index % 2 === 0 ? <InboxIcon /> : <MailIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
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
        {
           this.state.customers? this.state.customers.map(c=>{
            return(
              <Customer
              rank={c.rank}
              name={c.name}
              currentTable={c.currentTable}
              table={c.table}
              time={c.time}
              />

            )
          }):""
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