package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.*;

public class FXMLController {

	private AlienDictionary alienDictionary;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInputTranslate;

    @FXML
    private Button btnTranslate;

    @FXML
    private ImageView imgAlien;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClearTxt;

    @FXML
    void doClearTxt(ActionEvent event) {

    	this.txtResult.clear();
    }

    @FXML
    void doInputTranslate(ActionEvent event) {

    	String result = alienDictionary.newAlienWord(this.txtInputTranslate.getText());
    	if(result !=null) {
    		this.txtResult.appendText(result);
    		this.txtInputTranslate.clear();
    	}
    	else {
    		this.txtResult.appendText("Parola già presente nel Dizionario!\n");
    		this.txtInputTranslate.clear();
    	}
    	
    }

    @FXML
    void initialize() {
        assert txtInputTranslate != null : "fx:id=\"txtInputTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert imgAlien != null : "fx:id=\"imgAlien\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearTxt != null : "fx:id=\"btnClearTxt\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(AlienDictionary model) {
    	this.alienDictionary = model;
    }
}
