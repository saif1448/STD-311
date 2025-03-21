package org.example;

import org.example.controller.HomeController;
import org.example.exceptions.DeviceStatusException;
import org.example.models.Home;
import org.example.models.SmartDevice;
import org.example.models.SmartLight;
import org.example.models.SmartTheremostate;


public class Main {

    private static HomeController homeController;
    public static void main(String[] args) {

        Home home = new Home();
        homeController = new HomeController(home);

        homeController.addSmartDevice();


       homeController.toggleDeviceStatus(30);

       homeController.increaseTemp(70);




    }
}