package ihm;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sae201202.FirstYearStudent;
import sae201202.Motivation;
import sae201202.SaveData;
import sae201202.SecondYearStudent;
import sae201202.Student;
import sae201202.Subject;
import sae201202.Teacher;
import sae201202.ThirdYearStudent;

public class ControllerAccueil {

	private Teacher teacher = new Teacher("PERNOT", "Kevin", LocalDate.of(1963, 5, 26), "sae201202IHM", Subject.ALGO);
	private final static String PATH = System.getProperty("user.dir") + File.separator + "res" + File.separator + File.separator + "ihm" + File.separator;
	
	@FXML Button bProfilAccueil=new Button(); 
	@FXML Button bListEtudAccueil, bAffectationAccueil, bCandidaturesAccueil, bQuitter;
	@FXML Label testLabel;
	
	public Teacher getTeacher() {
		return this.teacher;
	}
	
	public void fillListStudent() {
		SaveData.loadData(teacher.getListStudent(), PATH + "scenario1.json");
	}
	
	public void goToProfil(ActionEvent e) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("InterfaceProfil.fxml"));	
		Parent p = loader.load();
		
		Scene scene = new Scene(p,1280, 720);
		
		ControllerProfil controller = loader.getController();
		controller.initData(teacher);
		
		Stage window = (Stage) ((Node)e.getTarget()).getScene().getWindow();
		window.setScene(scene); 
	}
	
	public void goToListEtud() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceListeEtud.fxml"));	
		
		Stage window = (Stage) bListEtudAccueil.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));	
	}
	
	public void goToAffectation(ActionEvent e) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceAffectation.fxml"));	
		
		Stage window = (Stage) bListEtudAccueil.getScene().getWindow();
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
	
	public void initialize() {
		fillListStudent();	
	}
}

