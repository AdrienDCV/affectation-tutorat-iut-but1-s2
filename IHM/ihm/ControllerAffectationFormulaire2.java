package ihm;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerAffectationFormulaire2 {
	
	ControllerAffectationFormulaire1 cf = new ControllerAffectationFormulaire1();
	
	@FXML Button bPrecedent, bAnnuler, bSuivant, bReinitialiser;
	@FXML Label labelEvitee = new Label();
	
	
	public void previousPage() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceAffectationFormulaire1.fxml"));	
		
		Stage window = (Stage) bPrecedent.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}
	
	public void nextPage() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceAffectationFormulaire3.fxml"));	
		
		Stage window = (Stage) bSuivant.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		cf.fillComboBoxTutore(cf.teacher.getListStudent());
		cf.comboBoxSetItems();
		cf.updateLabelForcee();
	}
	
	
}
