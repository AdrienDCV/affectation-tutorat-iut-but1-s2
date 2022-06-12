package ihm;


import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sae201202.Affectation;
import sae201202.FirstYearStudent;
import sae201202.SaveData;
import sae201202.Student;
import sae201202.Teacher;


public class ControllerAffectationFormulaire1 implements Initializable {
		    
	ControllerAccueil ca = new ControllerAccueil();
	Teacher teacher = ca.getTeacher();
	Affectation affect = teacher.getAffectation();
	
	private final static String PATH = System.getProperty("user.dir") + File.separator + "res" + File.separator+ "ihm" + File.separator; 
	
	ObservableList<String> tutore = FXCollections.observableArrayList();
	ObservableList<String> tuteur = FXCollections.observableArrayList();
	@FXML Button bAnnuler, bReinitialiser, bSuivant;
	@FXML ComboBox<String> cbTutore = new ComboBox<>();
	@FXML ComboBox<String> cbTuteur = new ComboBox<>();
	@FXML Label labelForcee = new Label();
	@FXML ListView liste = new ListView();
	
	class ForcedFirstYearAffectationEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			String id = cbTutore.getSelectionModel().getSelectedItem();
			affect.getForcedFirstYear().add(teacher.getStudentByID(id));
			SaveData.saveData(affect.getForcedFirstYear(), PATH + "forcedFirstYear.json");
		}
		
	}
	
	class ForcedThirdSecondYearAffectationEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			String id = cbTuteur.getSelectionModel().getSelectedItem();
			affect.getForcedThirdSecondYear().add(teacher.getStudentByID(id));
			SaveData.saveData(affect.getForcedThirdSecondYear(), PATH + "forcedThirdSecondYear.json");
		}
		
	}
	
	public void goToFormulaire2(ActionEvent e) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceAffectationFormulaire2.fxml"));	

		Stage window = (Stage) ((Node) e.getTarget()).getScene().getWindow();
		window.setScene(new Scene(root, 435, 480));	
	}
	
	public void shutDown(ActionEvent e) throws Exception {
		clearAffectationForcee();
		((Stage)(((Button)e.getSource()).getScene().getWindow())).close();
	}
	
	public List<Student> getForcedList() {
		System.out.println(affect.getForcedFirstYear());
		return affect.getForcedFirstYear();
	}
	
	public void fillComboBoxTutore(List<Student> studentList) {
		for (Student s : studentList) {
			if (s.isFirstYear()) {
				tutore.add(s.getID());
			}
		}
	}
	
	public void fillComboBoxTuteur(List<Student> studentList) {
		for (Student s : studentList) {
			if (s.isSecondYear() || s.isThirdYear()) {
				tuteur.add(s.getID());
			}
		}
	}
	
	public void comboBoxSetItems() {
		cbTutore.setItems(tutore);
		cbTuteur.setItems(tuteur);
	} 
	
	public void prepaCombosBoxes() {
		fillComboBoxTutore(teacher.getListStudent());
		fillComboBoxTuteur(teacher.getListStudent());
		comboBoxSetItems();
	}

	public void prepaForcedAffectation() {
		cbTutore.addEventHandler(ActionEvent.ACTION, new ForcedFirstYearAffectationEvent());
		
		cbTuteur.addEventHandler(ActionEvent.ACTION, new ForcedThirdSecondYearAffectationEvent());	
	}
	
	public CalculAffectation<Student> getForcedCalcul() {
		return affect.getForcedCalcul();
	}
	
	public void updateLabelForcee() {
			cbTutore.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)-> {
				labelForcee.setText(labelForcee.getText()+
						cbTutore.getSelectionModel().getSelectedItem()+", ");});
			cbTuteur.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)-> {
				labelForcee.setText(labelForcee.getText()+
						cbTuteur.getSelectionModel().getSelectedItem()+", ");});
	}
	
	public void clearAffectationForcee() {
		labelForcee.setText("Etudiants concernes : ");
		affect.getForcedFirstYear().clear();
		affect.getForcedThirdSecondYear().clear();
		SaveData.deleteFile(PATH + "forcedFirstYear.json");
		SaveData.deleteFile(PATH + "forcedThirdSecondYear.json");
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		SaveData.deleteFile(PATH + "forcedFirstYear.json");
		SaveData.deleteFile(PATH + "forcedThirdSecondYear.json");
		ca.fillListStudent();
		prepaCombosBoxes();
		updateLabelForcee();
		prepaForcedAffectation();
	}

	
	
}
