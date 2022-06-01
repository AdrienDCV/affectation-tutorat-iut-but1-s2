package ihm;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerProfil {
	
	@FXML Button bAccueilProfil, bListEtudProfil, bAffectationProfil, bCandidaturesProfil, bQuitter;
	
	
	public void goToAccueil() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceAccueil.fxml"));	
		
		Stage window = (Stage) bAccueilProfil.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}
	
	public void goToListEtud() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceListeEtud.fxml"));	
		
		Stage window = (Stage) bListEtudProfil.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}
	
	public void goToAffectation() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceAffectation.fxml"));	
		
		Stage window = (Stage) bAffectationProfil.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}
	
	/*public void goToCandidatures() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceCandidatures.fxml"));	
		
		Stage window = (Stage) bCandidaturesProfil.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}*/
	
	public void shutDown() throws Exception {
		Platform.exit();
		System.exit(0);
	}
	
	public void initialize() {}
}
