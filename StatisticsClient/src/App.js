import React, {Component} from 'react'
import axios from 'axios'
import { Button, Card, Row, Col } from 'react-materialize'

const url = 'https://stapiudea.herokuapp.com'
const urlPost = 'https://stapiudea.herokuapp.com/linearreg'


class App extends Component {
  constructor(props){
    super(props); //propiedades
    this.getElements()
    this.state={
      products: [],
      numberx: '',
      numbery: '',
      setx: [],
      sety: []
    };
    this.getElements = this.getElements.bind(this); 
    this.addElement = this.addElement.bind(this); 
    this.saveElement = this.saveElement.bind(this); 
    this.addElementToSet = this.addElementToSet.bind(this); 
    this.validateNumberX = this.validateNumberX.bind(this); 
    this.validateNumberY = this.validateNumberY.bind(this); 
  }

  saveElement(e){
    e.preventDefault();
    var self = this;
    var json = JSON.stringify({
              setX: this.state.setx,
              setY: this.state.sety
            })
    console.log(json)
    if(this.state.setx.length > 0 && this.state.setx.length > 0 ) {
      fetch(urlPost, {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify({
              setX: this.state.setx,
              setY: this.state.sety
            })
        });
      document.getElementById("setsx").innerHTML = "";  
      document.getElementById("setsy").innerHTML = "";  
    } else {
      document.getElementById("setsx").innerHTML = "Agregue elementos a ambos conjuntos";  
    }
  }


  addElementToSet(){
    var self = this;
    var numbersetx = document.getElementById("setx").value;
    var numbersety = document.getElementById("sety").value;
    console.log(numbersetx < 0)
    if(numbersetx == "" || numbersetx < 0) {
      document.getElementById("setsx").innerHTML = "Ingrese un numero valido para el conjunto x";  
      return;
    }
    if(numbersety == "" || numbersety < 0) {
      document.getElementById("setsy").innerHTML = "Ingrese un numero valido para el conjunto y";  
      return;
    }
    this.state.setx.push(parseInt(numbersetx));
    this.state.sety.push(parseInt(numbersety));
    this.state.numberx = '';
    this.state.numbery = '';
    document.getElementById("setsx").innerHTML = this.state.setx;  
    document.getElementById("setsy").innerHTML = this.state.sety;      
    document.getElementById("setx").value = '';
    document.getElementById("sety").value = '';
  }

  getElements(){
    var self = this;

    axios.get(url).then(function (response) {

      self.addElement(response);
    })
    .catch(function (error) {
      console.log(error);
    })
  }

  addElement(response) {
    this.setState({array: response.data});
    console.log(this.state.array);
    document.getElementById("show").innerHTML = "";
    for(var i in this.state.array) {

      var htmlProducts = " <br/> <div class=\"blue-grey darken-4 card\"><div class=\"card-content white-text\"><b>El conjunto X es: </b>"
                 + this.state.array[i].setX + "<br/><b>El tamaño del conjunto X es: </b>" + this.state.array[i].setX.length + "<br/><br/<b>El conjunto Y es: </b>"
                 + this.state.array[i].setY + "<br/><b>El tamaño del conjunto Y es: </b>" + this.state.array[i].setY.length + "<br/><br/"
                 + "<b>El valor de Beta 0 es: </b>" + this.state.array[i].beta0 + "<br/><b>El valor de Beta 1 es: </b>" +this.state.array[i].beta1
                 + "<br/> <b>El promedio de X es: </b>" +this.state.array[i].meanX  
                 + "</b><br/> <b>El promedio de Y es: </b>" +this.state.array[i].meanY 
                 + "</b><br/> <b>El valor de la correlación es: </b>" +this.state.array[i].correlation + "</div></div>";
                  
        document.getElementById("show").innerHTML += htmlProducts;

    }
  }

validateNumberX(evt) {
  const numberx = (evt.target.validity.valid) ? evt.target.value : this.state.numberx;    
    this.setState({ numberx });
}
validateNumberY(evt) {
  const numbery = (evt.target.validity.valid) ? evt.target.value : this.state.numbery;    
    this.setState({ numbery });
}

 	render(){ //aqui va todo lo referente a la vista
     return (
       <div className="container center">
         <br/>
         <Row>
          <Col s={12} m={12} l={10} className='grid-example offset-m1 offset-l1'> 
          <h3>
            Agregar Elementos
          </h3>
          <label>
            <span className="text">Conjunto 1:</span>
            <input type="text" maxLength="9" id="setx" pattern="[0-9]*" onInput={this.validateNumberX.bind(this)} value={this.state.numberx}/><br/>
          </label>
          <label>
            <span className="text">Conjunto 2:</span>
            <input type="text" maxLength="9" id="sety" pattern="[0-9]*" onInput={this.validateNumberY.bind(this)} value={this.state.numbery}/><br/>
          </label>
          <Button className="btn" type="submit" onClick={this.addElementToSet} >AGREGAR</Button>
          <br/><br/>
          <form
              method="post"
              onSubmit={this.saveElement}>
              <div id="setsx"></div>
              <div id="setsy"></div>
              <br/>
              <Button className="btn" type="submit">ENVIAR</Button>       
            </form>
            </Col>
            </Row>
         <Row>
          <Col s={12} m={12} l={10} className='grid-example offset-m1 offset-l1'> 
            <h3>Datos</h3>
            <div id="show"></div>
          </Col>
        </Row>
       </div>
     )
   }

 }

 export default App;

