package com.project.providentia.ui.controllers;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.project.providentia.App;
import com.project.providentia.system.SensorData;
import com.project.providentia.system.Status;
import com.project.providentia.system.observer.Observer;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MainController implements Initializable, Observer {
	
	@FXML private HBox topbar;
	@FXML private ImageView background;
	@FXML private ImageView closeBtn;
	@FXML private StackPane closeArea;
	
	@FXML private Text dateLabel;
	@FXML private Text clockLabel;
	@FXML private Text temperatureLabel;
	@FXML private Text windSpeedLabel;
	
    private double xOffSet = 0;
    private double yOffSet = 0;
    
    private SensorData sensorData;
    private Status status;
    
    private DateTimeFormatter dateFormat;
    private DateTimeFormatter clockFormat;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		clockFormat = DateTimeFormatter.ofPattern("hh:mm a");
		dateFormat = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
		
		
		sensorData = SensorData.getInstance();
		sensorData.registerObserver(this);
		
		initImages();
		makeStageDragable();

		startClock();
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
	
	private void startClock() {
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {        
			LocalDate currentDate = LocalDate.now();
	        LocalTime currentTime = LocalTime.now();
	        
	        dateLabel.setText(currentDate.format(dateFormat));
	        clockLabel.setText(currentTime.format(clockFormat));
	        
	    }),
	         new KeyFrame(Duration.seconds(1))
	    );
	    clock.setCycleCount(Animation.INDEFINITE);
	    clock.play();
	}

	@Override
	public void updateActivity(double temperature, double windSpeed, boolean frontDoor) {
		temperatureLabel.textProperty().set(temperature + " Celsius");
		windSpeedLabel.textProperty().set(windSpeed + " km/h");
	}
	
	private void checkStatus(double temperature, double windSpeed) {
		
	}
}
