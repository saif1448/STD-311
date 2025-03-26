package org.example.smarthomedesktopapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {

    private String roomName;
    private List<SmartDevice> allSmartDevices = new ArrayList<>();

    public void showRoomDevices() {
        System.out.println("=============" + roomName + "================");
        for (var smartDevice : allSmartDevices) {
            System.out.println(smartDevice);
        }
    }


    public void changeDeviceStatus(int deviceId, boolean deviceStatus) {
        for (var smartDevice : allSmartDevices) {
            if (smartDevice.getId() == deviceId) {
                smartDevice.setIsTurnOn(deviceStatus);
            }
        }
    }

    public SmartDevice getSmartDevice(int deviceId) {
        for (var smartDevice : allSmartDevices) {
            if (smartDevice.getId() == deviceId) {
                return smartDevice;
            }
        }

        return null;
    }


    public void printDeviceTypes(){
        for (var smartDevice : allSmartDevices) {
            if(smartDevice instanceof SmartLight){
                System.out.println("Name: "+ smartDevice.getDeviceName() + ", Type: Smart Light" );
            }else if(smartDevice instanceof SmartTheremostate){
                System.out.println("Name: "+ smartDevice.getDeviceName() + ", Type: Smart Thermostat" );
            }
        }
    }

}
