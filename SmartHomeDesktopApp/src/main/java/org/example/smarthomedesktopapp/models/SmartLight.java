package org.example.smarthomedesktopapp.models;

import lombok.Data;

@Data
public class SmartLight extends SmartDevice {

    private String lightCategory;
    private String lightColor;
    private boolean isDimmable;
    private int dimmingLevel;

    public SmartLight(int id, boolean isTurnOn, String deviceName, String lightCategory, String lightColor, boolean isDimmable) {

        super(id, isTurnOn, deviceName);
        this.lightCategory = lightCategory;
        this.lightColor = lightColor;
        this.isDimmable = isDimmable;
        this.dimmingLevel = 24;

    }

    public boolean increaseDimmingLevel() {
        if (isDimmable) {
            this.dimmingLevel++;
            return true;
        }
        return false;
    }

    public boolean decreaseDimmingLevel() {
        if (isDimmable) {
            this.dimmingLevel--;
            return true;
        }
        return false;
    }

    @Override
    public void showDeviceDetails() {
                System.out.println("Light Name: " + deviceName
                + "\nDevice ID: " + id
                + "\nDevice Category: " + lightCategory
                + "\nDevice Color: " + lightColor
                + "\nDimming Level: " + dimmingLevel
                + "\nDevice Status: " + isTurnOn);
    }

}
