package org.example.smarthomedesktopapp.controller;

import org.example.smarthomedesktopapp.models.SmartTheremostate;

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
