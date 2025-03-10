package org.example.controller;

import org.example.models.SmartTheremostate;

public class ThermostateController{

    public void increaseTemp(SmartTheremostate smartThermostat) {
        smartThermostat.increaseTemperature();
//        return smartThermostat;
    }
    public void decreaseTemp(SmartTheremostate smartThermostat) {
        smartThermostat.decreaseTemperature();
//        return smartThermostat;
    }
}
