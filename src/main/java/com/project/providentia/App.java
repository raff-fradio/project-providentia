package com.project.providentia;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import com.project.providentia.system.Activity;
import com.project.providentia.system.Randomizer;
import com.project.providentia.system.Status;

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
//		scene.getStylesheets().add(getClass().getResource("ui/css/main.css").toExternalForm());
                
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override
		    public void handle(WindowEvent t) {
		        Platform.exit();
		        System.exit(0);
		    }
		});
		
		primaryStage.show();
    }


}