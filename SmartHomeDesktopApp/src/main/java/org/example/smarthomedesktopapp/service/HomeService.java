package org.example.smarthomedesktopapp.service;

//import org.example.models.Home;
//import org.example.models.SmartDevice;
//import org.example.models.SmartLight;
//import org.example.models.SmartTheremostate;

import org.example.smarthomedesktopapp.models.Home;
import org.example.smarthomedesktopapp.models.SmartDevice;
import org.example.smarthomedesktopapp.models.SmartLight;
import org.example.smarthomedesktopapp.models.SmartTheremostate;

public class HomeService {

    private Home home;

    public HomeService(Home home) {
        this.home = home;
        initializeHome();
    }


    private void initializeHome(){
//        SmartDevice smartDevice1 = new SmartDevice(1,  "device 1");
//        SmartDevice smartDevice2 = new SmartDevice(2, "device 2");
//        SmartDevice smartDevice3 = new SmartDevice(3, false, "device 3");
//
//        home.getAllSmartDevices().add(smartDevice1);
//        home.getAllSmartDevices().add(smartDevice2);
//        home.getAllSmartDevices().add(smartDevice3);
    }


    public void addSmartDevice(SmartDevice smartDevice){
        home.getAllSmartDevices().add(smartDevice);
    }

    public void showDeviceType(){
        for (SmartDevice smartDevice : home.getAllSmartDevices()) {
//            if(smartDevice instanceof SmartLight){
//                System.out.println("Name: " + smartDevice.getDeviceName() + " Type: "+ smartDevice.getClass().getName());
//            } else if (smartDevice instanceof SmartLight) {
//
//            }
            System.out.println("Name: " + smartDevice.getDeviceName() + " Type: "+ smartDevice.getClass().getName());

        }
    }

    public void showAllSmartDevices(){
        for (SmartDevice smartDevice : home.getAllSmartDevices()) {
            if (smartDevice instanceof SmartLight) {
//                SmartLight smartLight = (SmartLight) smartDevice;
//                System.out.println(smartLight);
                System.out.println("Smart Light Device");
                smartDevice.showDeviceDetails();
            }else if (smartDevice instanceof SmartTheremostate) {
//                SmartTheremostate smartTheremostate = (SmartTheremostate) smartDevice;
//                System.out.println(smartTheremostate);
                System.out.println("Smart Theremostate Device");
                smartDevice.showDeviceDetails();
            }else {
                System.out.println("General Smart Device");
                System.out.println(smartDevice);
            }

            System.out.println("===========================================");
        }
    }

}
