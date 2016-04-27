package it.polito.tdp.dizionario.controller;

import java.net.URL;
import java.util.ResourceBundle;
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

    @FXML
    void doFindConnected(ActionEvent event) {

    }

    @FXML
    void doFindNeighbors(ActionEvent event) {

    }

    @FXML
    void doGenerate(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

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
