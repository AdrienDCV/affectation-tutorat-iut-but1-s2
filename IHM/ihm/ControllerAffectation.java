package ihm;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerAffectation {

	@FXML Button bAccueilAffectation, bProfilAffectation, bListEtudAffectation, bCandidaturesAffectation, bQuitter;
	
	
	public void goToAccueil() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceAccueil.fxml"));	
		
		Stage window = (Stage) bAccueilAffectation.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}
	
	public void goToListEtud() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceListeEtud.fxml"));	
		
		Stage window = (Stage) bListEtudAffectation.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}
	
	public void goToProfil() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceProfil.fxml"));	
		
		Stage window = (Stage) bProfilAffectation.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}
	
	/*public void goToCandidatures() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceCandidatures.fxml"));	
		
		Stage window = (Stage) bCandidaturesAffectation.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}*/
	
	public void shutDown() throws Exception {
		Platform.exit();
		System.exit(0);
	}
	
	public void initialize() {}
}
