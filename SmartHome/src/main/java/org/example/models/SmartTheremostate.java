package org.example.models;

import lombok.Data;

@Data
public class SmartTheremostate extends SmartDevice{
    private double temperature;
    private double humidity;

    public SmartTheremostate(int id, boolean isTurnOn, String deviceName, double temperature, double humidity) {
        super(id, isTurnOn, deviceName);
        this.temperature = temperature;
        this.humidity = humidity;
    }




}
