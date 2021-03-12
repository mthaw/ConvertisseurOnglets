package application;

/*
 * @Auteur : Martin Thaw
 * @Date : Le 5 Mars, 2021
 * @Description : Application (Java) qui permet d'effectuer des conversions entre des differents unites (de differents systemes; imperial, metrique, etc.). 
 * Les 5 unites de mesure dans cet application sont le temps, la masse, la monnaie, la longueur, et la quantite de matiere.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Convertisseur.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Convertisseur d'unites !"); //Mettre le titre du fenetre de l'application.
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
