package org.example.controller;

import org.example.models.Home;
import org.example.models.SmartDevice;
import org.example.models.SmartLight;
import org.example.service.HomeService;


public class HomeController {

    private Home home;
    private HomeService homeService;

    public HomeController(Home home) {
        this.home = home;
        homeService = new HomeService(home);
    }

    public boolean controlDevice(int deviceId){

        for (var smartDevice : home.getAllSmartDevices()) {
            if(smartDevice.getId() == deviceId){
                boolean currentStatus = smartDevice.isTurnOn();
                smartDevice.setTurnOn(!currentStatus);
                break;
            }
        }

        return true;
    }

    public void showSmartDeviceStatus(){

        home.getAllSmartDevices().forEach(e -> {
            System.out.println("---------- Device Details : -----------");
            System.out.println(e.getDeviceName() + " : " + e.isTurnOn());
        });
    }

    public void addSmartDevice(){
        SmartDevice smartDevice1 = getDummySmartDevice();
        homeService.addSmartDevice(smartDevice1);
    }

    private SmartDevice getDummySmartDevice(){
        SmartLight smartLight = new SmartLight(3,false, "Light 1", "LED", "WHiTE", false);
        return  smartLight;
    }

}
