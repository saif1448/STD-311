package org.example.controller;

import org.example.models.Home;
import org.example.models.SmartLight;

public class LightController {

    public SmartLight increaseDimmingLevel(SmartLight smartLight) {
       smartLight.increaseDimmingLevel();
       return smartLight;
    }

    public SmartLight decreaseDimmingLevel(SmartLight smartLight) {
        smartLight.decreaseDimmingLevel();
        return smartLight;
    }

    public SmartLight setDimmingLevel(SmartLight smartLight, int dimmingLevel) {
        smartLight.setDimmingLevel(dimmingLevel);
        return smartLight;
    }

}
