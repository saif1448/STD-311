package org.example.smarthomedesktopapp.controller;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.example.smarthomedesktopapp.apiInterface.SmartHomeApiClient;
import org.example.smarthomedesktopapp.models.Home;
import org.example.smarthomedesktopapp.models.SmartDevice;
import org.example.smarthomedesktopapp.models.SmartLight;
import org.example.smarthomedesktopapp.models.SmartTheremostate;
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
    }

//    public boolean toggleDeviceStatus(int deviceId) {
//
//        for (var smartDevice : home.getAllSmartDevices()) {
//            if (smartDevice.getId() == deviceId) {
//                if (smartDevice.getId() == deviceId) {
//                    boolean currentStatus = false;
//                    try {
//                        currentStatus = smartDevice.getIsTurnOn();
//
//                    } catch (Exception e) {
//                        logger.info(e.getMessage());
//                        currentStatus = false;
//
//                    } finally {
//                        smartDevice.setIsTurnOn(!currentStatus);
//                        client.updateLight("2", "toggle");
//                    }
//                    break;
//                }
//            }
//
//            return true;
//        }
//
//        return false;
//
//    }

    public void changeDeviceStatus(String roomName, int deviceId, boolean deviceStatus) {
        home.changeRoomDeviceStatus(roomName, deviceId, deviceStatus);
    }



    public void showSmartDeviceStatus(String roomName){

//        home.getAllSmartDevices().forEach(e -> {
//            System.out.println("---------- Device Status : -----------");
//            System.out.println(e.getDeviceName() + " : " + e.getIsTurnOn());
//        });
//        System.out.println("=====================================");
        home.showRoomSmartDeviceStatus(roomName);
    }

//    public void showAllDevices(){
//        System.out.println("---------- All Devices ----------");
//        homeService.showAllSmartDevices();
//        System.out.println("===================================");
//    }

//    public void addSmartDevice(){
//        SmartDevice smartDevice1 = getNewLightDevice();
//        homeService.addSmartDevice(smartDevice1);
//        SmartDevice smartDevice2 = getNewThermostaDevice();
//        homeService.addSmartDevice(smartDevice2);
//    }


    //newly added specific device
    public void addSmartDevice(String roomName, SmartDevice smartDevice){
        homeService.addSmartDevice(roomName, smartDevice);
    }

//    private SmartDevice getNewLightDevice(){
//        SmartDevice smartLight = new SmartLight(30,false, "Light 1", "LED", "WHiTE", true);
//        return  smartLight;
//    }

//    private SmartDevice getNewThermostaDevice(){
//        return new SmartTheremostate(70, false, "Thermostate 1", 32.1);
//    }

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
//        SmartTheremostate smartThermostat = home.getSmartThermostat(deviceId);
//        //modified here
////        smartThermostat = thermostateController.increaseTemp(smartThermostat);
////        home.updateSmartThermostat(smartThermostat, deviceId);
//        if(smartThermostat != null){
//            thermostateController.increaseTemp(smartThermostat);
//            client.updateTemperature("2", "increase");
//        }

        SmartTheremostate smartThermostat = null;
        try {
            smartThermostat = (SmartTheremostate) home.getAllRooms().get(roomName).getAllSmartDevices().get(deviceId);
            if(smartThermostat != null){
                thermostateController.increaseTemp(smartThermostat);
            }
        } catch (Exception e) {
            System.out.println("The given id is not for Smart Thermostat");
        }
    }

    public void decreaseTemp(String roomName, int deviceId) {
//        SmartTheremostate smartThermostat = home.getSmartThermostat(deviceId);
//        //modify
////        smartThermostat = thermostateController.decreaseTemp(smartThermostat);
////        home.updateSmartThermostat(smartThermostat, deviceId);
//        if(smartThermostat != null){
//            thermostateController.decreaseTemp(smartThermostat);
//            client.updateTemperature("2", "decrease");
//        }

        SmartTheremostate smartThermostat = null;
        try {
            smartThermostat = (SmartTheremostate) home.getAllRooms().get(roomName).getAllSmartDevices().get(deviceId);
            if(smartThermostat != null){
                thermostateController.decreaseTemp(smartThermostat);
            }
        } catch (Exception e) {
            System.out.println("The given id is not for Smart Thermostat");
        }
    }





}
