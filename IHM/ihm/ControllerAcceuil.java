package ihm;

import java.time.LocalDate;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerAcceuil {

	@FXML Button bProfilAccueil, bListEtudAccueil, bAffectationAccueil, bCandidaturesAccueil, bQuitter;
	
	
	public void goToProfil() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceProfil.fxml"));	
		
		Stage window = (Stage) bListEtudAccueil.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}
	
	public void goToListEtud() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceListeEtud.fxml"));	
		
		Stage window = (Stage) bListEtudAccueil.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}
	
	public void goToAffectation() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceAffectation.fxml"));	
		
		Stage window = (Stage) bAffectationAccueil.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}
	
	/*public void goToCandidatures() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceCandidatures.fxml"));	
		
		Stage window = (Stage) bCandidaturesAccueil.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}*/
	
	public void shutDown() throws Exception {
		Platform.exit();
		System.exit(0);
	}
	
	public void initialize() {}
}
