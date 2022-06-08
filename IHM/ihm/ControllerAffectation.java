package ihm;

import java.time.LocalDate;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sae201202.FirstYearStudent;
import sae201202.Motivation;
import sae201202.Student;
import sae201202.Teacher;

public class ControllerAffectation {

	ControllerAccueil ca = new ControllerAccueil();
	Teacher teacher = ca.getTeacher();
	
	@FXML Button bAccueilAffectation, bProfilAffectation, bListEtudAffectation, bCandidaturesAffectation, bQuitter,
	bChargerAffectationAffectation, bCalculAffectation, bNouvAffectAffectation;
	@FXML TableView<Student> table = new TableView<>();
	@FXML TableColumn<Student, String> colTutores = new TableColumn<>("Tutorés");
	@FXML TableColumn<Student, String> colTuteurs = new TableColumn<>("Tuteurs");
	
	@FXML Stage s=new Stage();
	
	
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
	
	public void goToNouvAffect(ActionEvent e) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("InterfaceAffectationFormulaire1.fxml"));	
		Parent p = loader.load();
		
		Stage stage = new Stage();
		stage.setTitle("Nouvelle Affectation");
		stage.setScene(new Scene(p, 435, 480));
		stage.show();
	}

	
	public void shutDown() throws Exception {
		Platform.exit();
		System.exit(0);
	}
	
	
	public void initialize() {
		tabViewInit();
	}
}
