package org.example.models;

import lombok.Data;

import java.util.Random;

@Data
public class SmartTheremostate extends SmartDevice{
    private double temperature;
    private double humidity;

    public SmartTheremostate(int id, boolean isTurnOn, String deviceName, double temperature) {
        super(id, isTurnOn, deviceName);
        this.temperature = temperature;
//        this.humidity = humidity;
        this.humidity = senseHumidity();
    }

    //TODO: Thread to change humidity time to time
    private double senseHumidity() {
        Random random = new Random();
        double hum = 10.0 + (random.nextDouble()*(100.0 - 10.0));
        return hum;
    }

    public boolean increaseTemperature() {
        temperature += 1;
        return true;
    }

    public boolean decreaseTemperature() {
        temperature -= 1;
        return true;
    }






}
