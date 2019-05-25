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
  state = {
    open: false,
    bounds: undefined,
    markers: [{id: 1, lat: this.props.lat, lng: this.props.lng}],
    
  };
  handleClickOpen = () => {
    this.setState({
      open: true,
    });
  };

  handleClose = () => {
    this.setState({ open: false });
  };
  handleMapClick = e => {
    const lat = e.latlng.lat()
    const lng = e.latlng.lng()
    this.setState(state => ({markers: [{id: +new Date(), lat, lng}]}))
  }

  handleMarkerClick = (id, e) => {
    this.setState(state => ({markers: state.markers.filter(m => m.id !== id)}))
  }


  handleMapInit = (map, naver) => {}

  
  render() {
    const {markers} = this.state
    const firstMarker = markers[0]

    return (
      <div>
        <Button variant="outlined" color="secondary" onClick={this.handleClickOpen}>
          상세 정보
        </Button>
        <Dialog
          onClose={this.handleClose}
          aria-labelledby="customized-dialog-title"
          open={this.state.open}
        >
          <DialogTitle id="customized-dialog-title" onClose={this.handleClose}>
            상세 정보
          </DialogTitle>
          <DialogContent>
         <h1>{this.props.name}</h1>
          
          <h2>가게위치</h2>
         
          <div>
  
        <NaverMap
          ncp
          clientId="od2tgm7ydu"
          style={{width: '500px', height: '500px'}}
          initialPosition={firstMarker}
          initialZoom={15}
          onMapClick={this.handleMapClick}>
          {markers.map(marker => (
            <CustomMarker
              key={marker.id}
              lat={marker.lat}
              lng={marker.lng}
              onClick={e => this.handleMarkerClick(marker.id, e)}
            />
          ))}
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