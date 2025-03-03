package org.example.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor
@Data
public class SmartDevice {

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

}
