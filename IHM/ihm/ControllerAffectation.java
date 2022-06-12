package ihm;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.ulille.but.sae2_02.graphes.Arete;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sae201202.Affectation;
import sae201202.FirstYearStudent;
import sae201202.Motivation;
import sae201202.SaveData;
import sae201202.Student;
import sae201202.Teacher;

public class ControllerAffectation {

	ControllerAccueil ca = new ControllerAccueil();
	Teacher teacher = ca.getTeacher();
	Affectation affect = teacher.getAffectation();
	
	@FXML Button bAccueilAffectation, bProfilAffectation, bListEtudAffectation, bCandidaturesAffectation, bQuitter,
	bChargerAffectationAffectation, bCalculAffectation, bNouvAffectAffectation, bSauvegarderAffectation;
	@FXML ListView liste = new ListView();
	
	@FXML Stage s=new Stage();
	
	private final static String PATH = System.getProperty("user.dir") + File.separator + "res" + File.separator+ "ihm" + File.separator;
	
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
		liste.getItems().add("Aucun resultat...");
		SaveData.deleteFile(PATH+"listeAretes.json");	
	}
}
