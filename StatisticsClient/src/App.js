import React, {Component} from 'react'
import axios from 'axios'
import { Button, Card, Row, Col } from 'react-materialize'

const url = 'http://stapiudea.herokuapp.com'


class App extends Component {
  constructor(props){
    super(props); //propiedades
    this.getProducts()
    this.state={
      products: []
    };
    this.getProducts = this.getProducts.bind(this); 
    this.saveProducts = this.saveProducts.bind(this); 
  }

  getProducts(){
    var self = this;

    axios.get(url).then(function (response) {

      self.saveProducts(response);
    })
    .catch(function (error) {
      console.log(error);
    })
  }

  saveProducts(response) {
    this.setState({array: response.data});
    console.log(this.state.array);
    document.getElementById("show").innerHTML = "";
    for(var i in this.state.array) {

      var htmlProducts = " <br/> <div class=\"blue-grey darken-4 card\"><div class=\"card-content white-text\"><b>El valor de Beta 0 es: </b>" 
                 + this.state.array[i].beta0 + "<br/><b>El valor de Beta 1 es: </b>" +this.state.array[i].beta1
                 + "<br/> <b>El promedio de X es: </b>" +this.state.array[i].meanX  
                 + "</b><br/> <b>El promedio de Y es: </b>" +this.state.array[i].meanY 
                 + "</b><br/> <b>El valor de la correlación es: </b>" +this.state.array[i].correlation + "</div></div>";
                  
        document.getElementById("show").innerHTML += htmlProducts;

    }
  }

 	render(){ //aqui va todo lo referente a la vista
     return (
       <div class="container center">
         <br/>
         <br/>         
         <Row>
          <Col s={12} m={10} l={8} className='grid-example offset-m1 offset-l2'> 
            <h3>Datos</h3>
            <div id="show"></div>
          </Col>
        </Row>
       </div>
     )
   }

 }

 export default App;
