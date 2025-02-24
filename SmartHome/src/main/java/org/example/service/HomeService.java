package org.example.service;

import org.example.models.Home;
import org.example.models.SmartDevice;

public class HomeService {

    private Home home;

//    static {
//
//    }

    public HomeService(Home home) {
        this.home = home;
        initializeHome();
    }


    private void initializeHome(){
        SmartDevice smartDevice1 = new SmartDevice(1, false, "device 1");
        SmartDevice smartDevice2 = new SmartDevice(2, false, "device 2");
        SmartDevice smartDevice3 = new SmartDevice(3, false, "device 3");

        home.getAllSmartDevices().add(smartDevice1);
        home.getAllSmartDevices().add(smartDevice2);
        home.getAllSmartDevices().add(smartDevice3);
    }


    public void addSmartDevice(SmartDevice smartDevice){
        home.getAllSmartDevices().add(smartDevice);
    }





}
