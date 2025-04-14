package org.example.smarthomedesktopapp.apiInterface;

import javafx.event.ActionEvent;

public interface HomeViewControllerInterface {

    public void handelLightToggle(ActionEvent event);
    public void handleIncreaseTemperature(ActionEvent event);
    public void handleDecreaseTemperature(ActionEvent event);

}
