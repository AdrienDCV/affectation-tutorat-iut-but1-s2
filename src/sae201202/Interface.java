package sae201202;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Interface extends Application {
	Controller1 controller;
	
	public Parent createParent(String url) throws IOException {
		 FXMLLoader loader = new FXMLLoader();
         URL fxmlFileUrl = getClass().getResource(url);
         if (fxmlFileUrl == null) {
                 System.out.println("Impossible de charger le fichier fxml");
                 System.exit(-1);
         }
         loader.setLocation(fxmlFileUrl);
         this.controller = loader.getController();
         Parent root = loader.load();
         return root;
	}
	
	
    public void start(Stage stage) throws IOException {
           

            // créer plusieurs scènes et les swapper dans le stage pour changer d'interface (.fxml différents)
    		BorderPane root = (BorderPane) createParent("interface.fxml");
    		//Parent test = createParent("interface2.fxml"); // refaire ça pour toutes les pages
    		Scene scene = new Scene(root);
    		//root.setCenter(test);
    		controller.message = "It works";
            stage.setScene(scene);
            stage.setTitle("FXML demo");
            stage.show();
    }

    public static void main(String[] args) {
            Application.launch(args);
    }
}