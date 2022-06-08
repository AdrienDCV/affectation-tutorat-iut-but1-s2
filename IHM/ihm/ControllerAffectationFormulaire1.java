package ihm;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import sae201202.Student;
import sae201202.Teacher;


public class ControllerAffectationFormulaire1 implements Initializable {
			    
	ControllerAccueil ca = new ControllerAccueil();
	Teacher teacher = ca.getTeacher();
	
	
	ObservableList<String> tutore = FXCollections.observableArrayList();
	ObservableList<String> tuteur = FXCollections.observableArrayList();
	@FXML Button bAnnuler, bReinitialiser, bSuivant;
	@FXML ComboBox<String> cbTutore = new ComboBox<>();
	@FXML ComboBox<String> cbTuteur = new ComboBox<>();
	@FXML Label labelForcee = new Label();
	
	
	public void fillComboBoxTutore(List<Student> studentList) {
		for (Student s : studentList) {
			System.out.println(s);
			if (s.isFirstYear()) {
				tutore.add(s.getName()+" " +s.getForename());
			}
		}
	}
	
	public void fillComboBoxTuteur(List<Student> studentList) {
		for (Student s : studentList) {
			if (s.isSecondYear() || s.isThirdYear()) {
				tuteur.add(s.getName()+" " +s.getForename());
			}
		}
	}
	
	public void comboBoxSetItems() {
		cbTutore.setItems(tutore);
		cbTuteur.setItems(tuteur);
	}
	
	public void goToFormulaire2(ActionEvent e) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceAffectationFormulaire2.fxml"));	

		Stage window = (Stage) ((Node) e.getTarget()).getScene().getWindow();
		window.setScene(new Scene(root, 435, 480));	
	}
	
	public void shutDown1(ActionEvent e) throws Exception {
		((Stage)(((Button)e.getSource()).getScene().getWindow())).close();
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
		labelForcee.setText("Etudiants concernés : ");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ca.fillListStudent();
		fillComboBoxTutore(teacher.getListStudent());
		fillComboBoxTuteur(teacher.getListStudent());
		comboBoxSetItems();
		updateLabelForcee();
	}
	
}
