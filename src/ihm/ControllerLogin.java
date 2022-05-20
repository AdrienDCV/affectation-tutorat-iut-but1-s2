package ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerLogin {
	@FXML Label lb;
	
	@FXML void ConnectButton() {
		String currentValue = lb.getText();
		lb.setText("Connecté");
	}
	
	@FXML 
	public void initialize() {}
}
