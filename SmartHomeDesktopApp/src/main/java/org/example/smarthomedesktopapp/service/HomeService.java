package org.example.smarthomedesktopapp.service;

//import org.example.models.Home;
//import org.example.models.SmartDevice;
//import org.example.models.SmartLight;
//import org.example.models.SmartTheremostate;

import org.example.smarthomedesktopapp.controller.HomeController;
import org.example.smarthomedesktopapp.models.*;

import java.util.logging.Logger;

public class HomeService {

    Logger logger = Logger.getLogger(HomeService.class.getName());

    private Home home;

    public HomeService(Home home) {
        this.home = home;
        initializeHome();
    }

    public void initializeHome(){
        Room livingRoom = new Room();
        livingRoom.setRoomName("Living Room");
        Room bedRoom = new Room();
        bedRoom.setRoomName("Bed Room");
        Room kitchen  = new Room();
        kitchen.setRoomName("Kitchen Room");

        // 2 ---> bedroom ---> 2 ---> 2+2 -->4
        // 1 ---> living ---> 1 ---> 1 + 1 --> 4
        // 3 ---> kitchen ---> 3 ---> 3 + 3 ---> 6

        SmartDevice bedRoomLight = new SmartLight(2, false, "Bed Room Light", "", "White", false);
        SmartDevice bedRoomThermostat = new SmartTheremostate(2+2, true, "Bed Room Thermostat", 22);

        SmartDevice livingRoomLight = new SmartLight(1, false, "Living Room Light", "", "White", false);
        SmartDevice livingRoomThermostat = new SmartTheremostate(1+1, true, "Living Room Thermostat", 22);

        SmartDevice kitchenRoomLight = new SmartLight(3, false, "Kitchen Room Light", "", "White", false);
        SmartDevice kitchenRoomThermostat = new SmartTheremostate(3+3, true, "Kitchen Room Thermostat", 22);

        bedRoom.getAllSmartDevices().add(bedRoomLight);
        bedRoom.getAllSmartDevices().add(bedRoomThermostat);

        livingRoom.getAllSmartDevices().add(livingRoomLight);
        livingRoom.getAllSmartDevices().add(livingRoomThermostat);

        kitchen.getAllSmartDevices().add(kitchenRoomLight);
        kitchen.getAllSmartDevices().add(kitchenRoomThermostat);

        home.getAllRooms().put("1", livingRoom);
        home.getAllRooms().put("2", bedRoom);
        home.getAllRooms().put("3", kitchen);

        logger.info("Home is being initialized");
    }


    public void addSmartDevice(String roomName, SmartDevice smartDevice){
//        home.getAllSmartDevices().add(smartDevice);
        home.getAllRooms().get(roomName).getAllSmartDevices().add(smartDevice);
    }


    public void showDeviceType(String roomName) {
        Room room = home.getAllRooms().get(roomName);
        room.printDeviceTypes();
    }

    public boolean getLightDeviceStatus(String roomId, int deviceId){
        Room room = home.getAllRooms().get(roomId);
        SmartDevice smartDevice = room.getSmartDevice(deviceId);
        return smartDevice.getIsTurnOn();
    }
}
