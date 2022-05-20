package sae201202;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Controller1 {
	@FXML Label lb;
	@FXML Parent root;
	String message = "Hello World";
	
	@FXML void bTest() {
		String currentValue = lb.getText();
		currentValue = "Test concluant";
		lb.setText(currentValue);
	}
	
	
	@FXML void direBonjour() {
		System.out.println(message);
	}
	
	@FXML 
	public void initialize() {}
	
}
