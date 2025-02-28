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

    public HomeController(Home home) {
        this.home = home;
        homeService = new HomeService(home);
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
            System.out.println("---------- Device Details : -----------");
            System.out.println(e.getDeviceName() + " : " + e.getIsTurnOn());
        });
    }

    public void addSmartDevice(){
        SmartDevice smartDevice1 = getNewLightDevice();
        homeService.addSmartDevice(smartDevice1);
        SmartDevice smartDevice2 = getNewThermostaDevice();
        homeService.addSmartDevice(smartDevice2);
    }

    private SmartDevice getNewLightDevice(){
        SmartLight smartLight = new SmartLight(3,false, "Light 1", "LED", "WHiTE", false);
        return  smartLight;
    }

    private SmartDevice getNewThermostaDevice(){
        return new SmartTheremostate(7, false, "Thermostate 1", 32.1, 40.0);
    }

    public void showDeviceType(){
        homeService.showDeviceType();
    }

}
