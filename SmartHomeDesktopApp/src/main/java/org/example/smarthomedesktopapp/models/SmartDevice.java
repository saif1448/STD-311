package org.example.smarthomedesktopapp.models;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor
@Data
public abstract class  SmartDevice {

    protected int id;
    protected Boolean isTurnOn;
    protected String deviceName;

    public SmartDevice(int id, boolean isTurnOn, String deviceName) {
        this.id = id;
        this.isTurnOn = isTurnOn;
        this.deviceName = deviceName;
    }

    public SmartDevice(int id, String deviceName) {
        this.id = id;
        this.deviceName = deviceName;
    }

    //show device details

//    public void showDeviceDetails() {
//        System.out.println("Device Name: " + deviceName
//        + "\nDevice ID: " + id
//        + "\nDevice Status: "+ isTurnOn);
//    }

    public abstract void showDeviceDetails();

}
