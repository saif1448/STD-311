package org.example.smarthomedesktopapp.exceptions;

public class DeviceStatusException extends RuntimeException {

    String message;

    public DeviceStatusException(String message) {
        super(message);
    }

}
