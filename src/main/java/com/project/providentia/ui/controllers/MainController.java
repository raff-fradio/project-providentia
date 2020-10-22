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
	
	@FXML private ImageView ac;
	@FXML private ImageView light;
	@FXML private ImageView heater;
	@FXML private ImageView cctv;
	@FXML private ImageView window;
	
	@FXML private ImageView buttonUp;
	@FXML private ImageView buttonDown;
	@FXML private ImageView toggleOff1;
	@FXML private ImageView toggleOff2;
	@FXML private ImageView toggleOff3;
	@FXML private ImageView toggleOff4;
	@FXML private ImageView toggleOn1;
	@FXML private ImageView toggleOn2;
	@FXML private ImageView toggleOn3;
	@FXML private ImageView toggleOn4;
	@FXML private ImageView temp;
	@FXML private ImageView domeLight1;
	@FXML private ImageView domeLight2;
	@FXML private ImageView domeLight3;
	@FXML private ImageView domeLight4;
	
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
		status = new Status();
		
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
		
		String acPath = new File("src/main/resources/com/project/providentia/ac2.png").getAbsolutePath();
		Image acImage = new Image(new File(acPath).toURI().toString());
		
		ac.setImage(acImage);	
		
		String lightPath = new File("src/main/resources/com/project/providentia/light.png").getAbsolutePath();
		Image lightImage = new Image(new File(lightPath).toURI().toString());
		
		light.setImage(lightImage);	
		
		String heaterPath = new File("src/main/resources/com/project/providentia/heater.png").getAbsolutePath();
		Image heaterImage = new Image(new File(heaterPath).toURI().toString());
		
		heater.setImage(heaterImage);	
		
		String cctvPath = new File("src/main/resources/com/project/providentia/cctv.png").getAbsolutePath();
		Image cctvImage = new Image(new File(cctvPath).toURI().toString());
		
		cctv.setImage(cctvImage);
		
		String windowPath = new File("src/main/resources/com/project/providentia/window.png").getAbsolutePath();
		Image windowImage = new Image(new File(windowPath).toURI().toString());
		
		window.setImage(windowImage);
		
		String buttonUpPath = new File("src/main/resources/com/project/providentia/button_up.png").getAbsolutePath();
		Image buttonUpImage = new Image(new File(buttonUpPath).toURI().toString());
		
		buttonUp.setImage(buttonUpImage);
		
		String buttonDownPath = new File("src/main/resources/com/project/providentia/button_down.png").getAbsolutePath();
		Image buttonDownImage = new Image(new File(buttonDownPath).toURI().toString());
		
		buttonDown.setImage(buttonDownImage);
		
		String toggleOffPath = new File("src/main/resources/com/project/providentia/toggle_off.png").getAbsolutePath();
		Image toggleOffImage = new Image(new File(toggleOffPath).toURI().toString());
		
		toggleOff1.setImage(toggleOffImage);
		toggleOff2.setImage(toggleOffImage);
		toggleOff3.setImage(toggleOffImage);
		toggleOff4.setImage(toggleOffImage);
		
		String toggleOnPath = new File("src/main/resources/com/project/providentia/toggle_on.png").getAbsolutePath();
		Image toggleOnImage = new Image(new File(toggleOnPath).toURI().toString());
		
		
		String tempPath = new File("src/main/resources/com/project/providentia/temp.png").getAbsolutePath();
		Image tempImage = new Image(new File(tempPath).toURI().toString());
		
		temp.setImage(tempImage);
		
		String domeLightPath = new File("src/main/resources/com/project/providentia/dome_light.png").getAbsolutePath();
		Image domeLightImage = new Image(new File(domeLightPath).toURI().toString());
		
		domeLight1.setImage(domeLightImage);
		domeLight2.setImage(domeLightImage);
		domeLight3.setImage(domeLightImage);
		domeLight4.setImage(domeLightImage);
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
