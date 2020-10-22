package com.project.providentia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.project.providentia.system.Activity;
import com.project.providentia.system.Randomizer;
import com.project.providentia.system.Status;

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
//        launch();
        Activity act = new Activity();
    	Randomizer rd = new Randomizer();
    	Thread thread = new Thread(rd);
    	thread.start();
		Status st = new Status(act.getWindSpeed(),act.getTemperature());
    	Thread thread2 = new Thread(st);
    	thread2.start();    	
    }

}