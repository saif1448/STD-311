package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Home {

    private String homeName;
    private List<SmartDevice> allSmartDevices = new ArrayList<>();

    public SmartLight getSmartLight(int deviceId) {
        for (var smartDevice : allSmartDevices) {
            if(smartDevice.getId() == deviceId){
                return (SmartLight) smartDevice; // t1
            }
        }
        return null;
    }

    public void updateSmartLight(SmartLight smartLight, int deviceId) {
        for (int i = 0; i < allSmartDevices.size(); i++) {
            SmartDevice smartDevice = allSmartDevices.get(i);
            if (smartDevice.getId() == deviceId && smartDevice instanceof SmartLight) {
                allSmartDevices.set(i, smartLight);
                break;
            }
        }
    }

    public SmartTheremostate getSmartThermostat(int deviceId) {
        for (var smartDevice : allSmartDevices) {
            if (smartDevice.getId() == deviceId) {
                return (SmartTheremostate) smartDevice;
            }
        }
        return null;
    }

    public void updateSmartThermostat(SmartTheremostate smartThermostat, int deviceId) {
        for (int i = 0; i < allSmartDevices.size(); i++) {
            SmartDevice smartDevice = allSmartDevices.get(i);
            if (smartDevice.getId() == deviceId && smartDevice instanceof SmartTheremostate) {
                allSmartDevices.set(i, smartThermostat);
            }
        }
    }

}
