package ihm;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;

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
import sae201202.SecondYearStudent;
import sae201202.Student;
import sae201202.Subject;
import sae201202.Teacher;
import sae201202.ThirdYearStudent;

public class ControllerAccueil {

	private Teacher teacher = new Teacher("PERNOT", "Kevin", LocalDate.of(1963, 5, 26), "sae201202IHM", Subject.ALGO);
	Student AdrienDCV = new FirstYearStudent("DA COSTA VEIGA", "Adrien", LocalDate.of(2003, 5, 25), 1, 'F', 1, null);
	Student AdrienDGD = new FirstYearStudent("DEGAND", "Adrien", LocalDate.of(2003, 5, 27), 1, 'F', 1, null);
	Student Etud2 = new SecondYearStudent("ETUD2", "Etud2", LocalDate.of(2002, 5, 25), 2, 'F', Motivation.HIGH_MOTIVATION, 0, new HashMap<Subject, Double>());
	Student Etud3 = new ThirdYearStudent("ETUD3", "Etud3", LocalDate.of(2001, 5, 27), 3, 'F', Motivation.HIGH_MOTIVATION, 0, new HashMap<Subject, Double>(),false);
	
	@FXML Button bProfilAccueil=new Button(); 
	@FXML Button bListEtudAccueil, bAffectationAccueil, bCandidaturesAccueil, bQuitter;
	@FXML Label testLabel;
	
	public Teacher getTeacher() {
		return this.teacher;
	}
	
	public void fillListStudent() {
		teacher.fillListStudent(AdrienDCV);
		teacher.fillListStudent(AdrienDGD);
		teacher.fillListStudent(Etud2);
		teacher.fillListStudent(Etud3);
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
