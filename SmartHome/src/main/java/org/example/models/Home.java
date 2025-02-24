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

}
