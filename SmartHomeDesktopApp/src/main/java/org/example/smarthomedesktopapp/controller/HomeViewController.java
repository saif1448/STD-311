package org.example.smarthomedesktopapp.controller;

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
    @Override
    public void handelLightToggle() {
        System.out.println("toggle light");
//        homeController.toggleDeviceStatus(30);
    }

    @FXML
    @Override
    public void handleIncreaseTemperature() {
        System.out.println("inc temp");
//        homeController.increaseTemp(70);
    }

    @FXML
    @Override
    public void handleDecreaseTemperature() {
        System.out.println("dec temp");
//        homeController.decreaseTemp(70);
    }

}
