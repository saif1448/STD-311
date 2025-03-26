package org.example.smarthomedesktopapp.service;

//import org.example.models.Home;
//import org.example.models.SmartDevice;
//import org.example.models.SmartLight;
//import org.example.models.SmartTheremostate;

import org.example.smarthomedesktopapp.models.*;

public class HomeService {

    private Home home;

    public HomeService(Home home) {
        this.home = home;

    }


    public void addSmartDevice(String roomName, SmartDevice smartDevice){
//        home.getAllSmartDevices().add(smartDevice);
        home.getAllRooms().get(roomName).getAllSmartDevices().add(smartDevice);
    }


    public void showDeviceType(String roomName) {
        Room room = home.getAllRooms().get(roomName);
        room.printDeviceTypes();
    }
}
