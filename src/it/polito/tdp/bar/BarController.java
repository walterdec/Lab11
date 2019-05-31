package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Simulatore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {
	
	Simulatore simulatore;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnSimula;

    @FXML
    void doSimula(ActionEvent event) {
    	txtArea.clear();
    	simulatore.init();
    	simulatore.run();
    	txtArea.appendText(simulatore.toString());
    }

    @FXML
    void initialize() {
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Bar.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";

    }
    
    public void setSimulatore(Simulatore simulatore) {
    	this.simulatore=simulatore;
    }
}
