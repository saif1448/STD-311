package org.example.controller;

import org.example.models.SmartTheremostate;

public class ThermostateController{

    public SmartTheremostate increaseTemp(SmartTheremostate smartThermostat) {
        smartThermostat.increaseTemperature();
        return smartThermostat;
    }
    public SmartTheremostate decreaseTemp(SmartTheremostate smartThermostat) {
        smartThermostat.decreaseTemperature();
        return smartThermostat;
    }
}
