package com.project.providentia;

import com.project.providentia.system.Sensor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

	public static Stage stage = null;
	
    public static void main(String[] args) {
    	launch();
    }

	@Override
    public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		
		Parent root = FXMLLoader.load(getClass().getResource("ui/views/Main.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("ui/css/main.css").toExternalForm());
                
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setOnCloseRequest((t) -> {
	        Platform.exit();
	        System.exit(0);
		});
		
		primaryStage.show();
		
    	Thread sensor = new Thread(new Sensor());
    	sensor.start();
    }


}