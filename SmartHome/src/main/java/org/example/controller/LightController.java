package org.example.controller;

import org.example.models.Home;
import org.example.models.SmartLight;

public class LightController {

    public void increaseDimmingLevel(SmartLight smartLight) {
       smartLight.increaseDimmingLevel();
//       return smartLight;
    }

    public void decreaseDimmingLevel(SmartLight smartLight) {
        smartLight.decreaseDimmingLevel();
//        return smartLight;
    }

    public void setDimmingLevel(SmartLight smartLight, int dimmingLevel) {
        smartLight.setDimmingLevel(dimmingLevel);
//        return smartLight;
    }

}
