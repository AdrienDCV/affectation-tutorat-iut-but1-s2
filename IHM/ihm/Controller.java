package ihm;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sae201202.Teacher;

public class Controller {

	@FXML Button bProfil1, bListEtud1, bNouvAffect1, bCandidatures1;
	@FXML Button bAccueilProfil, bListEtudProfil, bNouvAffectProfil, bCandidaturesProfil;
	@FXML Label teacherName=new Label(), teacherForename=new Label(), teacherSubject=new Label(), teacherID=new Label(), teacherMail=new Label();
	
	Teacher Adrien = new Teacher("DA COSTA VEIGA", "Adrien", LocalDate.of(2003, 5, 25), "test", null);
	
	public void handleBt1() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceProfil.fxml"));	
		
		Stage window = (Stage) bProfil1.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));
		
	}
	
	public void handleBt2() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceAccueil.fxml"));
		
		Stage window = (Stage) bAccueil2.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));
	}
	
	public void initialize() {}
}
