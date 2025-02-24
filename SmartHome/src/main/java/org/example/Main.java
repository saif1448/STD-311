package org.example;

import org.example.controller.HomeController;
import org.example.models.Home;
import org.example.models.SmartDevice;
import org.example.service.HomeService;

public class Main {

    private static HomeController homeController;
    private static HomeService homeService;
    public static void main(String[] args) {

        Home home = new Home();
        homeController = new HomeController(home);
        homeService = new HomeService(home);

        homeController.showSmartDeviceStatus();
        homeController.controlDevice(2);

        homeController.addSmartDevice();

        homeController.showSmartDeviceStatus();



    }
}