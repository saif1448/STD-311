package org.example.smarthomedesktopapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.smarthomedesktopapp.models.Home;

public class HomeViewController {

    @FXML
    private Button toggle_light_btn;
    @FXML
    private Button inc_temp_btn;
    @FXML
    private Button dec_temp_btn;

    Home home = new Home();
    HomeController homeController = new HomeController(home);

    public HomeViewController() {
//        homeController.addSmartDevice();
    }

    @FXML
    private void handleToggleLightBtn(){
        System.out.println("toggle light");
//        homeController.toggleDeviceStatus(30);
    }

    @FXML
    private void handleIncTempBtn(){
        System.out.println("inc temp");
//        homeController.increaseTemp(70);
    }

    @FXML
    private void handleDecTempBtn(){
        System.out.println("dec temp");
//        homeController.decreaseTemp(70);
    }



}
