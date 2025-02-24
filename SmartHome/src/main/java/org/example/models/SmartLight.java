package org.example.models;

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



}
