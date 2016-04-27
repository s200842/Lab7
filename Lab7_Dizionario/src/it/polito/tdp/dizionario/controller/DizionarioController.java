package it.polito.tdp.dizionario.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.dizionario.model.DizionarioModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtLetters;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnGenerate;

    @FXML
    private Button btnFindNeighbors;

    @FXML
    private Button btnFindConnected;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    private DizionarioModel model;
    
    public void setModel(DizionarioModel model){
    	this.model = model;
    }

    @FXML
    void doFindConnected(ActionEvent event) {

    }

    @FXML
    void doFindNeighbors(ActionEvent event) {

    }

    @FXML
    void doGenerate(ActionEvent event) {
    	//Cancella input precedente
    	txtSearch.clear();
    	txtResult.clear();
    	//Controlli sull'input nella casella
    	if(!txtLetters.getText().matches("[1-9]*")){
    		txtResult.setText("Inserire un valore valido come lunghezza della parola.");
    		return;
    	}
    	model.createGraph(Integer.parseInt(txtLetters.getText()));
    	txtResult.setText(String.format("Creato un grafo con %d vertici e %d archi", model.getGraph().vertexSet().size(), model.getGraph().edgeSet().size()));
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtLetters.clear();
    	txtSearch.clear();
    	txtResult.clear();
    }

    @FXML
    void initialize() {
        assert txtLetters != null : "fx:id=\"txtLetters\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert txtSearch != null : "fx:id=\"txtSearch\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnGenerate != null : "fx:id=\"btnGenerate\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnFindNeighbors != null : "fx:id=\"btnFindNeighbors\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnFindConnected != null : "fx:id=\"btnFindConnected\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Dizionario.fxml'.";

    }
}
