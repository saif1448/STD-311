package org.example.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SmartDevice {

    protected int id;
    protected boolean isTurnOn;
    protected String deviceName;


}
