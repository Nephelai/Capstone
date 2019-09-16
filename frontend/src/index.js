import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Root from './Root';
import * as serviceWorker from './serviceWorker';
import {MuiThemeProvider, createMuiTheme} from '@material-ui/core/styles';
import '../node_modules/font-awesome/css/font-awesome.min.css'
import 'bootstrap/dist/css/bootstrap.css'
//모듈부분

const theme = createMuiTheme({
    typography:{
        fontFamily:'"Noto Sans KR",serif',
    }
})

ReactDOM.render(<MuiThemeProvider theme={theme}><Root /></MuiThemeProvider>, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.register();
