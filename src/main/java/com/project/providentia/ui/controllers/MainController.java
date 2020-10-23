package com.project.providentia.ui.controllers;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.project.providentia.App;
import com.project.providentia.system.Control;
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
	@FXML private ImageView switchBed;
	@FXML private ImageView switchBath;
	@FXML private ImageView switchKitchen;
	@FXML private ImageView switchLiving;
	@FXML private ImageView temp;
	@FXML private ImageView domeLightBed;
	@FXML private ImageView domeLightBath;
	@FXML private ImageView domeLightKitchen;
	@FXML private ImageView domeLightLiving;
	
	@FXML private Text temperatureControl;
	
    private double xOffSet = 0;
    private double yOffSet = 0;
    
    private SensorData sensorData;
    private Status status;
    private Control control;
    
    private DateTimeFormatter dateFormat;
    private DateTimeFormatter clockFormat;
    
	private final String SWITCH_ON_PATH = new File("src/main/resources/com/project/providentia/toggle_on.png").getAbsolutePath();
	private final String SWITCH_OFF_PATH = new File("src/main/resources/com/project/providentia/toggle_off.png").getAbsolutePath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		clockFormat = DateTimeFormatter.ofPattern("hh:mm a");
		dateFormat = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
		
		
		sensorData = SensorData.getInstance();
		sensorData.registerObserver(this);
		status = new Status();
		control = new Control();
		
		initImages();
		initBindings();
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
		ac.setOpacity(0.5);

		String lightPath = new File("src/main/resources/com/project/providentia/light.png").getAbsolutePath();
		Image lightImage = new Image(new File(lightPath).toURI().toString());
		
		light.setImage(lightImage);
		light.setOpacity(0.5);
		
		String heaterPath = new File("src/main/resources/com/project/providentia/heater.png").getAbsolutePath();
		Image heaterImage = new Image(new File(heaterPath).toURI().toString());
		
		heater.setImage(heaterImage);
		heater.setOpacity(0.5);
		
		String cctvPath = new File("src/main/resources/com/project/providentia/cctv.png").getAbsolutePath();
		Image cctvImage = new Image(new File(cctvPath).toURI().toString());
		
		cctv.setImage(cctvImage);
		cctv.setOpacity(0.5);

		String windowPath = new File("src/main/resources/com/project/providentia/window.png").getAbsolutePath();
		Image windowImage = new Image(new File(windowPath).toURI().toString());
		
		window.setImage(windowImage);
		window.setOpacity(0.5);

		String buttonUpPath = new File("src/main/resources/com/project/providentia/button_up.png").getAbsolutePath();
		Image buttonUpImage = new Image(new File(buttonUpPath).toURI().toString());
		
		buttonUp.setImage(buttonUpImage);
		
		String buttonDownPath = new File("src/main/resources/com/project/providentia/button_down.png").getAbsolutePath();
		Image buttonDownImage = new Image(new File(buttonDownPath).toURI().toString());
		
		buttonDown.setImage(buttonDownImage);
		
		Image switchOffImage = new Image(new File(SWITCH_OFF_PATH).toURI().toString());

		switchBed.setImage(switchOffImage);
		switchBath.setImage(switchOffImage);
		switchKitchen.setImage(switchOffImage);
		switchLiving.setImage(switchOffImage);
		
		String tempPath = new File("src/main/resources/com/project/providentia/temp.png").getAbsolutePath();
		Image tempImage = new Image(new File(tempPath).toURI().toString());
		
		temp.setImage(tempImage);
		
		String domeLightPath = new File("src/main/resources/com/project/providentia/dome_light.png").getAbsolutePath();
		
		Image domeLight = new Image(new File(domeLightPath).toURI().toString());
		
		domeLightBed.setImage(domeLight);
		domeLightBath.setImage(domeLight);
		domeLightKitchen.setImage(domeLight);
		domeLightLiving.setImage(domeLight);
		
		domeLightBed.setOpacity(0.5);
		domeLightBath.setOpacity(0.5);
		domeLightKitchen.setOpacity(0.5);
		domeLightLiving.setOpacity(0.5);

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
		temperatureLabel.setText(temperature + " \u00B0C");
		windSpeedLabel.setText(windSpeed + " km/h");
		
		status.setAc(control.getTemperature() < temperature);
		status.setHeater(control.getTemperature() > temperature);
		status.setWindShield(windSpeed > Status.SAFE_WIND_SPEED);
		status.setGuest(frontDoor);
	}
	
	private void initBindings() {
		status.acProperty().addListener((v, oldValue, newValue) -> {
			if (oldValue != newValue) {
				if (newValue) {
					System.out.println("AC turned on");
					ac.setOpacity(1);
				} else {
					System.out.println("AC turned off.");
					ac.setOpacity(0.5);
				}
			}
		});
		status.heaterProperty().addListener((v, oldValue, newValue) -> {
			if (oldValue != newValue) {
				if (newValue) {
					System.out.println("Heater turned on");
					heater.setOpacity(1);
				} else {
					System.out.println("Heater turned off.");
					heater.setOpacity(0.5);
				}
			}
		});
		status.windShieldProperty().addListener((v, oldValue, newValue) -> {
			if (oldValue != newValue) {
				if (newValue) {
					System.out.println("Window shield engaged.");
					window.setOpacity(1);
				} else {
					System.out.println("Window shield disengaged.");
					window.setOpacity(0.5);
				}
			}
		});
		status.outdoorLightProperty().addListener((v, oldValue, newValue) -> {
			if (oldValue != newValue) {
				if (newValue) {
					System.out.println("Outdoor lights enabled.");
					light.setOpacity(1);
				} else {
					System.out.println("Outdoor lights disabled.");
					light.setOpacity(0.5);
				}
			}
		});
		status.guestProperty().addListener((v, oldValue, newValue) -> {
			if (oldValue != newValue) {
				if (newValue) {
					System.out.println("Alert! Guest on front door!");
					cctv.setOpacity(1);
				} else {
					System.out.println("Front Door alert disengaged.");
					cctv.setOpacity(0.5);
				}
			}
		});
	}

	@FXML
	private void toggleBed() {
		if (control.getLight("Bedroom")) {
			domeLightBed.setOpacity(0.5);
			control.setLight("Bedroom", false);
			switchBed.setImage(new Image(new File(SWITCH_OFF_PATH).toURI().toString()));
			System.out.println("Bedroom lights turned off.");
			
		} else {
			domeLightBed.setOpacity(1);
			control.setLight("Bedroom", true);
			switchBed.setImage(new Image(new File(SWITCH_ON_PATH).toURI().toString()));
			System.out.println("Bedroom lights turned on.");
		}
	}
	
	@FXML
	private void toggleBath() {
		
	}
	
	@FXML
	private void toggleKitchen() {
		
	}
	
	@FXML
	private void toggleLiving() {
		
	}
}
