package ihm;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.ulille.but.sae2_02.graphes.Arete;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sae201202.Affectation;
import sae201202.FirstYearStudent;
import sae201202.SaveData;
import sae201202.Student;
import sae201202.Teacher;
import sae201202.UseAffectation;

public class ControllerAffectationFormulaire3 implements Initializable{

		ControllerAccueil ca = new ControllerAccueil();
		ControllerAffectation caffect = new ControllerAffectation();
		ControllerAffectationFormulaire1 cf1 = new ControllerAffectationFormulaire1();
		ControllerAffectationFormulaire2 cf2 = new ControllerAffectationFormulaire2();
		Teacher teacher = ca.getTeacher();
		List<Arete<Student>> listeAretes = new ArrayList<Arete<Student>>();
	
		private final static String PATH = System.getProperty("user.dir") + File.separator + "res" + File.separator + "ihm" + File.separator;
		
		@FXML Button bPrecedent, bAnnuler, bValider, bConfirmer;
		@FXML ListView liste = new ListView();
		
		
		public void previousPage() throws Exception {
			Parent root = FXMLLoader.load(getClass().getResource("InterfaceAffectationFormulaire1.fxml"));	
			
			Stage window = (Stage) bPrecedent.getScene().getWindow();
			window.setScene(new Scene(root, 435, 480));	
		}
		
		public void shutDown(ActionEvent e) throws Exception {		
			((Stage)(((Button)e.getSource()).getScene().getWindow())).close();
		}

		public void onlyForcedAffectation(List<Student> studentList) {

			List<Student> tuteur = new ArrayList<Student>();
			List<Student> tutore = new ArrayList<Student>();
			SaveData.loadData(tuteur, PATH + "forcedThirdSecondYear.json");
			SaveData.loadData(tutore, PATH + "forcedFirstYear.json");
			
			cf1.affect.prepaList(studentList);
		
			int idx1 = 0;
			int idx2 = 0;
			if(!tuteur.isEmpty()&& !tutore.isEmpty()) {
				for(int i=0 ; i < studentList.size(); i ++) {
					if (studentList.get(i).equals(tutore.get(0))) {
						idx1 = i;
					} else if(studentList.get(i).equals(tuteur.get(0))) {
						idx2 = i;
					}
				}
			}
			cf1.affect.forcedAffectation(studentList.get(idx1), studentList.get(idx2), studentList);
			cf1.affect.affectation(studentList);

			List<Arete<Student>> listeArete = cf1.affect.severalAffectation(); 
			listeArete.addAll(cf1.affect.getListArete(cf1.affect.getListArete(cf1.affect.getCalcul())));
			listeArete.addAll(cf1.affect.getListForcedArete(cf1.affect.getForcedCalcul()));
			List<FirstYearStudent> list = Affectation.isTutoredBy(listeArete);
			SaveData.saveDataArete(listeArete, PATH+"listeAretes.json");
		}
		
		public void displayResult() {
			SaveData.loadDataArete(listeAretes, PATH+"listeAretes.json");
			ObservableList<String> obsListAretes = FXCollections.observableArrayList();
			obsListAretes.addAll(caffect.affect.toStringAretes(listeAretes, teacher));
			liste.getItems().removeAll(liste.getItems());
			liste.setItems(obsListAretes);
		}
		
		public void normalAffectation(List<Student> studentList) {
			cf1.affect.prepaList(studentList);
			
			cf1.affect.prepaList(studentList);
			cf1.affect.affectation(studentList);
			
			List<Arete<Student>> listeArete = cf1.affect.severalAffectation(); 
			listeArete.addAll(cf1.affect.getListArete(cf1.affect.getListArete(cf1.affect.getCalcul())));
			List<FirstYearStudent> list = Affectation.isTutoredBy(listeArete);
			
		}
		
		public void loadFiles() {
			if (SaveData.exitst(PATH+"forcedThirdSecondYear.json") && SaveData.exitst(PATH+"forcedFirstYear.json")) {
				SaveData.loadData(caffect.affect.getForcedThirdSecondYear(), PATH + "forcedThirdSecondYear.json");
				SaveData.loadData(caffect.affect.getForcedFirstYear(), PATH + "forcedFirstYear.json");
			} 

		}
		
		
		public void validAffectationCalcul(ActionEvent e) throws Exception {
			loadFiles();
			if (!caffect.affect.getForcedFirstYear().isEmpty() && !caffect.affect.getForcedThirdSecondYear().isEmpty()) {
				onlyForcedAffectation(teacher.getListStudent());
				displayResult();
				bValider.setDisable(true);
			} else {
				normalAffectation(teacher.getListStudent());
				displayResult();
				bValider.setDisable(true);
			}
			
		
		}
		
		public void confirmAffectaitonCalcul(ActionEvent e) {
			((Stage)(((Button)e.getSource()).getScene().getWindow())).close();
		}
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			liste.getItems().add("Aucun resultat...");
			ca.fillListStudent();
		}


}
