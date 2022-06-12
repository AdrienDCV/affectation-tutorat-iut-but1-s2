package ihm;

import java.io.IOException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sae201202.Subject;
import sae201202.Teacher;

public class InterfaceGraphique extends Application{
	
	public void start(Stage primaryStage) throws Exception {
			
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceAccueil.fxml"));
		primaryStage.setTitle("SAE 2.01 + 2.02");
		primaryStage.setScene(new Scene(root, 1280, 720));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {launch(args);} 
}