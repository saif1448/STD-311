package org.example.smarthomedesktopapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.smarthomedesktopapp.apiInterface.HomeViewControllerInterface;
import org.example.smarthomedesktopapp.apiInterface.SmartCameraControllerInterface;
import org.example.smarthomedesktopapp.models.Home;

public class HomeViewController implements HomeViewControllerInterface{

    @FXML
    private Button toggle_light_btn_1;
    @FXML
    private Button toggle_light_btn_2;
    @FXML
    private Button toggle_light_btn_3;

    @FXML
    private Button inc_temp_btn_1;
    @FXML
    private Button inc_temp_btn_2;
    @FXML
    private Button inc_temp_btn_3;

    @FXML
    private Button dec_temp_btn_1;
    @FXML
    private Button dec_temp_btn_2;
    @FXML
    private Button dec_temp_btn_3;

    Home home = new Home();
    HomeController homeController = new HomeController(home);

    public HomeViewController() {
//        homeController.addSmartDevice();
    }


    @FXML
    public void handelLightToggle(ActionEvent event) {
        System.out.println("toggle light");

        Button clickedButton = (Button) event.getSource(); // This gives you the button that triggered the event
        String buttonId = clickedButton.getId();
        System.out.println("Clicked Button ID: " + buttonId);

        String roomKey = extractNumberFromId(buttonId);
        String deviceId = roomKey;
        homeController.changeDeviceStatus(roomKey, Integer.parseInt(deviceId));

    }

    @FXML
    @Override
    public void handleIncreaseTemperature(ActionEvent event) {

        Button clickedButton = (Button) event.getSource(); // This gives you the button that triggered the event
        String buttonId = clickedButton.getId();
        System.out.println("Clicked Button ID: " + buttonId);

        String roomKey = extractNumberFromId(buttonId);
        Integer deviceId = Integer.parseInt(roomKey);

        homeController.increaseTemp(roomKey, deviceId+deviceId);

        System.out.println("inc temp");
//        homeController.increaseTemp(70);
    }

    @FXML
    @Override
    public void handleDecreaseTemperature(ActionEvent event) {

        Button clickedButton = (Button) event.getSource(); // This gives you the button that triggered the event
        String buttonId = clickedButton.getId();
        System.out.println("Clicked Button ID: " + buttonId);

        String roomKey = extractNumberFromId(buttonId);
        Integer deviceId = Integer.parseInt(roomKey);

        homeController.decreaseTemp(roomKey, deviceId+deviceId);

        System.out.println("dec temp");
//        homeController.decreaseTemp(70);
    }

    private String extractNumberFromId(String id) {
        String numberPart = id.substring(id.lastIndexOf("_") + 1);
        return numberPart;
    }

}
