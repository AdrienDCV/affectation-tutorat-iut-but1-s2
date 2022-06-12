package ihm;

import java.time.LocalDate;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sae201202.Subject;
import sae201202.Teacher;

public class ControllerProfil {
	
	ControllerAccueil ca = new ControllerAccueil();
	Teacher teacher = ca.getTeacher();
	
	@FXML Button bAccueilProfil, bListEtudProfil, bAffectationProfil, bCandidaturesProfil, bQuitter;
	@FXML Label nameLabel = new Label(); 
	@FXML Label forenameLabel= new Label();
	@FXML Label idLabel= new Label();
	@FXML Label mailLabel= new Label();
	@FXML Label subjectLabel= new Label();;
	
	public void initData(Teacher teacher) {
		nameLabel.setText(teacher.getName());
		forenameLabel.setText(teacher.getForename());
		idLabel.setText(teacher.getID());
		mailLabel.setText(teacher.getMail());
		subjectLabel.setText(teacher.getTeaching().getLabel());
	}
	
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
	
	public void initialize() {
		initData(teacher);
	}
}
