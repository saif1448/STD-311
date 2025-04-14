package org.example.smarthomedesktopapp.controller;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.example.smarthomedesktopapp.apiInterface.SmartHomeApiClient;
import org.example.smarthomedesktopapp.models.*;
import org.example.smarthomedesktopapp.service.HomeService;

import java.util.logging.Logger;

public class HomeController {

    Logger logger = Logger.getLogger(HomeController.class.getName());


    private Home home;
    private HomeService homeService;
    private LightController lightController;
    private ThermostateController thermostateController;

    private final SmartHomeApiClient client;

    public HomeController(Home home) {
        this.home = home;
        this.homeService = new HomeService(home);
        this.lightController = new LightController();
        this.thermostateController = new ThermostateController();

        this.client = Feign.builder()
                .decoder(new JacksonDecoder())  // To decode JSON responses
                .encoder(new JacksonEncoder())  // To encode requests
                .target(SmartHomeApiClient.class, "http://localhost:3000");


        for (var roomKey : home.getAllRooms().keySet()) {
            client.addLight(roomKey);
            client.addTemperature(roomKey);
        }
    }

    public void changeDeviceStatus(String roomName, int deviceId) {
        boolean deviceStatus = !homeService.getLightDeviceStatus(roomName, deviceId);
        home.changeRoomDeviceStatus(roomName, deviceId, deviceStatus);
        if (deviceStatus) {
            client.updateLight(roomName, "ON");
        }
        else {
            client.updateLight(roomName, "OFF");
        }
    }



    public void showSmartDeviceStatus(String roomName){

        home.showRoomSmartDeviceStatus(roomName);
    }


    //newly added specific device
    public void addSmartDevice(String roomName, SmartDevice smartDevice){
        homeService.addSmartDevice(roomName, smartDevice);
    }


    public void showDeviceType(String roomName){
        homeService.showDeviceType(roomName);
    }

    public void increaseLightDimmingLevel(String roomName, int deviceId){
//        SmartLight smartLight = home.getSmartLight(deviceId);  // t2 = t1
        SmartLight smartLight = null;
        try {
            smartLight = (SmartLight) home.getAllRooms().get(roomName).getAllSmartDevices().get(deviceId);
            if(smartLight != null){
                lightController.increaseDimmingLevel(smartLight);
            }
        } catch (Exception e) {
            System.out.println("The given id is not for Smart Light");
        }
    }

    public void decreaseLightDimmingLevel(String roomName, int deviceId){
//        SmartLight smartLight = home.getSmartLight(deviceId);
//        //modified here
////        smartLight = lightController.decreaseDimmingLevel(smartLight);
////        home.updateSmartLight(smartLight, deviceId);
//        if(smartLight != null){
//            lightController.decreaseDimmingLevel(smartLight);
//        }

        SmartLight smartLight = null;
        try {
            smartLight = (SmartLight) home.getAllRooms().get(roomName).getAllSmartDevices().get(deviceId);
            if(smartLight != null){
                lightController.decreaseDimmingLevel(smartLight);
            }
        } catch (Exception e) {
            System.out.println("The given id is not for Smart Light");
        }
    }

    public void setDimmingLevel(String roomName, int deviceId, int dimmingLevel){
//        SmartLight smartLight = home.getSmartLight(deviceId);
//        //modified here
////        smartLight = lightController.setDimmingLevel(smartLight, dimmingLevel);
////        home.updateSmartLight(smartLight, deviceId);
//        if(smartLight != null){
//            lightController.setDimmingLevel(smartLight, dimmingLevel);
//        }
        SmartLight smartLight = null;
        try {
            smartLight = (SmartLight) home.getAllRooms().get(roomName).getAllSmartDevices().get(deviceId);
            if(smartLight != null){
                lightController.setDimmingLevel(smartLight, dimmingLevel);
            }
        } catch (Exception e) {
            System.out.println("The given id is not for Smart Light");
        }
    }

    public void increaseTemp(String roomName, int deviceId) {

        SmartTheremostate smartThermostat = null;
        try {
            smartThermostat = (SmartTheremostate) home.getAllRooms().get(roomName).getSmartDevice(deviceId);
            if(smartThermostat != null){
                thermostateController.increaseTemp(smartThermostat);
                client.updateTemperature(roomName, "increase");
            }
        } catch (Exception e) {
            System.out.println("The given id is not for Smart Thermostat");
        }
    }

    public void decreaseTemp(String roomName, int deviceId) {

        SmartTheremostate smartThermostat = null;
        try {
            smartThermostat = (SmartTheremostate) home.getAllRooms().get(roomName).getSmartDevice(deviceId);
            if(smartThermostat != null){
                thermostateController.decreaseTemp(smartThermostat);
                client.updateTemperature(roomName, "decrease");
            }
        } catch (Exception e) {
            System.out.println("The given id is not for Smart Thermostat");
        }
    }





}
