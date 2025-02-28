package org.example;

import org.example.controller.HomeController;
import org.example.exceptions.DeviceStatusException;
import org.example.models.Home;


public class Main {

    private static HomeController homeController;
    public static void main(String[] args) {

        Home home = new Home();
        homeController = new HomeController(home);

        homeController.showSmartDeviceStatus();

//        homeController.toggleDeviceStatus(2);
        homeController.addSmartDevice();

//        homeController.showSmartDeviceStatus();

        homeController.showSmartDeviceStatus();

        homeController.showDeviceType();



    }
}