package sae201202;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controler {
	@FXML Label lb;
	
	@FXML void bplus() {
		int curentValue = Integer.parseInt(lb.getText());
		lb.setText("" + (curentValue + 1));
	}
	
	@FXML void bmoins() {
		int curentValue = Integer.parseInt(lb.getText());
		lb.setText("" + (curentValue - 1));
	}
	
	@FXML 
	public void initialize() {}
}
