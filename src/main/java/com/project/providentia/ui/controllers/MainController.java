package com.project.providentia.ui.controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.providentia.App;
import com.project.providentia.system.observer.Observer;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class MainController implements Initializable, Observer {
	
	@FXML private HBox topbar;
	@FXML private ImageView background;
	@FXML private ImageView closeBtn;
	@FXML private StackPane closeArea;
	
    private double xOffSet = 0;
    private double yOffSet = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		initImages();
		makeStageDragable();

	}

	private void initImages() {
		String bgPath = new File("src/main/resources/com/project/providentia/background.jpg").getAbsolutePath();
		Image bgImage = new Image(new File(bgPath).toURI().toString());
		
		background.setImage(bgImage);
		
		String closeBtnPath = new File("src/main/resources/com/project/providentia/close-icon.png").getAbsolutePath();
		Image closeBtnImage = new Image(new File(closeBtnPath).toURI().toString());
		
		closeBtn.setImage(closeBtnImage);		
	}
	
	@FXML
	private void exit() {
        Platform.exit();
		System.exit(0);
	}
	
	private void makeStageDragable() {
        topbar.setOnMousePressed((event) -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        topbar.setOnMouseDragged((event) -> {
            App.stage.setX(event.getScreenX() - xOffSet);
            App.stage.setY(event.getScreenY() - yOffSet);
        });
    }

	@Override
	public void updateActivity(double temperature, double windSpeed, boolean frontDoor) {
		// TODO Auto-generated method stub
		
	}

}
