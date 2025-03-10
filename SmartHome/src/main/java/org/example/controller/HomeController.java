package org.example.controller;

import org.example.models.Home;
import org.example.models.SmartDevice;
import org.example.models.SmartLight;
import org.example.models.SmartTheremostate;
import org.example.service.HomeService;

import java.util.logging.Logger;


public class HomeController {

    Logger logger = Logger.getLogger(HomeController.class.getName());

    private Home home;
    private HomeService homeService;
    private LightController lightController;
    private ThermostateController thermostateController;

    public HomeController(Home home) {
        this.home = home;
        this.homeService = new HomeService(home);
        this.lightController = new LightController();
        this.thermostateController = new ThermostateController();
    }

    public boolean toggleDeviceStatus(int deviceId){

        for (var smartDevice : home.getAllSmartDevices()) {
            if(smartDevice.getId() == deviceId){
                boolean currentStatus = false;
                try {
                    currentStatus = smartDevice.getIsTurnOn();

                } catch (Exception e) {
                    logger.info(e.getMessage());
                     currentStatus = false;

                }finally {
                    smartDevice.setIsTurnOn(!currentStatus);
                }
                break;
            }
        }

        return true;
    }

    public void showSmartDeviceStatus(){

        home.getAllSmartDevices().forEach(e -> {
            System.out.println("---------- Device Status : -----------");
            System.out.println(e.getDeviceName() + " : " + e.getIsTurnOn());
        });
        System.out.println("=====================================");
    }

    public void showAllDevices(){
        System.out.println("---------- All Devices ----------");
        homeService.showAllSmartDevices();
        System.out.println("===================================");
    }

    public void addSmartDevice(){
        SmartDevice smartDevice1 = getNewLightDevice();
        homeService.addSmartDevice(smartDevice1);
        SmartDevice smartDevice2 = getNewThermostaDevice();
        homeService.addSmartDevice(smartDevice2);
    }

    //newly added specific device
    public void addSmartDevice(SmartDevice smartDevice){
        homeService.addSmartDevice(smartDevice);
    }

    private SmartDevice getNewLightDevice(){
        SmartDevice smartLight = new SmartLight(30,false, "Light 1", "LED", "WHiTE", true);
        return  smartLight;
    }

    private SmartDevice getNewThermostaDevice(){
        return new SmartTheremostate(70, false, "Thermostate 1", 32.1);
    }

    public void showDeviceType(){
        homeService.showDeviceType();
    }

    public void increaseLightDimmingLevel(int deviceId){
        SmartLight smartLight = home.getSmartLight(deviceId);
        //modifying 93 and 94
//        smartLight = lightController.increaseDimmingLevel(smartLight);
//        home.updateSmartLight(smartLight, deviceId);
        if(smartLight != null){
            lightController.increaseDimmingLevel(smartLight);
        }
    }

    public void decreaseLightDimmingLevel(int deviceId){
        SmartLight smartLight = home.getSmartLight(deviceId);
        //modified here
//        smartLight = lightController.decreaseDimmingLevel(smartLight);
//        home.updateSmartLight(smartLight, deviceId);
        if(smartLight != null){
            lightController.decreaseDimmingLevel(smartLight);
        }
    }

    public void setDimmingLevel(int deviceId, int dimmingLevel){
        SmartLight smartLight = home.getSmartLight(deviceId);
        //modified here
//        smartLight = lightController.setDimmingLevel(smartLight, dimmingLevel);
//        home.updateSmartLight(smartLight, deviceId);
        if(smartLight != null){
            lightController.setDimmingLevel(smartLight, dimmingLevel);
        }
    }

    public void increaseTemp(int deviceId) {
        SmartTheremostate smartThermostat = home.getSmartThermostat(deviceId);
        //modified here
//        smartThermostat = thermostateController.increaseTemp(smartThermostat);
//        home.updateSmartThermostat(smartThermostat, deviceId);
        if(smartThermostat != null){
            thermostateController.increaseTemp(smartThermostat);
        }
    }

    public void decreaseTemp(int deviceId) {
        SmartTheremostate smartThermostat = home.getSmartThermostat(deviceId);
        //modify
//        smartThermostat = thermostateController.decreaseTemp(smartThermostat);
//        home.updateSmartThermostat(smartThermostat, deviceId);
        if(smartThermostat != null){
            thermostateController.decreaseTemp(smartThermostat);
        }
    }





}
