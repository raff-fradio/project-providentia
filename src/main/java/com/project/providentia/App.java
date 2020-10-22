package com.project.providentia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.project.providentia.system.Randomizer;

public class App extends Application {

	@Override
    public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ui/views/main.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("ui/css/main.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    	Randomizer rd = new Randomizer();
    	Thread thread = new Thread(rd);
    	thread.start();
    }

}