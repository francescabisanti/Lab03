/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

public class FXMLController {
	Dictionary model;
	String lingua;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem itemEng;

    @FXML
    private MenuItem itemIta;

    @FXML
    private TextArea txtInput;

    @FXML
    private Button btmSpell;

    @FXML
    private TextArea txtResult;

    @FXML
    private Label txtNumeroErrori;

    @FXML
    private Button btmClear;

    @FXML
    private Label txtTempo;

    @FXML
    void doClear(ActionEvent event) {
    	txtResult.clear();
    	txtInput.clear();
    }

    @FXML
    void doSpell(ActionEvent event) {
    	List <RichWord> paroleR;
    	String inserito= txtInput.getText().toLowerCase();
    	inserito= inserito.replaceAll("\\p{Punct}", "");
    	this.txtResult.setText(inserito);
    	
    	List <String> listaInserito= new LinkedList <String>();
    	String campi[]= inserito.split(" ");
    	for(int i=0; i<campi.length; i++) {
    		String s= campi[i];
    		listaInserito.add(s);
    		
    	}
    	paroleR=this.model.spellCheckTextLinear(listaInserito);
    	List <String> finale= new LinkedList <String>();
    	finale=this.model.paroleSbagliate(paroleR);
    	this.txtNumeroErrori.setText("Ci sono "+finale.size()+" parole sbagliate");
    	
    	String risultato="";
    	for(String s:finale) {
    		 risultato= risultato+s+"\n";
    	}
    	this.txtResult.setText(risultato);
    	this.txtTempo.setText("Spell check completed in "+ System.currentTimeMillis());
    }

    @FXML
    void handleEng(ActionEvent event) {
    	lingua="English";
    	this.model.loadDictionary(lingua);
    }

    @FXML
    void handleIta(ActionEvent event) {
    	lingua="Italiano";
    	this.model.loadDictionary(lingua);
    	


    }
    public void setModel(Dictionary model) {
    	this.model=model;
    }
    @FXML
    void initialize() {
        assert itemEng != null : "fx:id=\"itemEng\" was not injected: check your FXML file 'Scene.fxml'.";
        assert itemIta != null : "fx:id=\"itemIta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmSpell != null : "fx:id=\"btmSpell\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumeroErrori != null : "fx:id=\"txtNumeroErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmClear != null : "fx:id=\"btmClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
