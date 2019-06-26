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
import NaverMap,{Marker} from 'react-naver-map'
import markerPng from './marker_v2.png'

const CustomMarker = ({lat, lng, onClick}) => (
  <Marker
    lat={lat}
    lng={lng}
    onClick={onClick}
    icon={{
      url: markerPng,
      size: {width: 24, height: 32},
      scaledSize: {width: 24, height: 32},
      anchor: {x: 12, y: 32},
    }}
    shape={{coords: [0, 12, 12, 0, 24, 12, 12, 32, 0, 12], type: 'poly'}}
  />
)

const DialogTitle = withStyles(theme => ({
  root: {
    borderBottom: `1px solid ${theme.palette.divider}`,
    margin: 0,
    padding: theme.spacing.unit * 2,
    
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
  
  };

}
  
  handleClickOpen = () => {
    this.setState({
      open: true,
    });
  };

  handleClose = (e) => {
    e.stopPropagation();
    this.setState({ open: false,
      markers:''
    });
    

  };
  handleMapClick = e => {
    const lat = e.latlng.lat()
    const lng = e.latlng.lng()
    this.setState(state => ({markers: [{id: +new Date(), lat, lng}]}))
  }


  handleMapInit = (map, naver) => {}
  
  render() {
    var markers = {id: 1, lat: this.props.lat, lng: this.props.lng}

    return (
      <div backdrop="static">
        <Button variant="outlined" color="secondary" onClick={this.handleClickOpen}>
          위치 정보
        </Button>
        <Dialog
          onClose={this.handleClose}
          aria-labelledby="customized-dialog-title"
          open={this.state.open}
        >
          <DialogTitle id="customized-dialog-title" onClose={this.handleClose}>
          {this.props.name}
          </DialogTitle>
          <DialogContent>
         
          
          <h2>가게위치</h2>
         
          <div>
  
        <NaverMap
          ncp
          clientId="od2tgm7ydu"
          style={{width: '500px', height: '500px'}}
          initialPosition={markers}
          initialZoom={15}
          zoomControl={1}
          onMapClick={this.handleMapClick}>
          <Marker lat={this.props.lat} lng={this.props.lng} />
        </NaverMap>
        
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