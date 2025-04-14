package org.example.smarthomedesktopapp.apiInterface;

import feign.Param;
import feign.RequestLine;

public interface SmartHomeApiClient {

    // Endpoint to get the status of rooms
//    @RequestLine("GET /api/status")
    @RequestLine(APIEndpoints.ROOMS)
    String getRoomStatus();

    // Endpoint to update light status
//    @RequestLine("POST /api/light/{room}/{status}")
//    void updateLight(@Param("room") String room, @Param("status") String status);

    //individual room wise status
    @RequestLine(APIEndpoints.ROOM_STATUS)
    void individualRoomStatus(@Param("room") String room);

    //adding the light
    @RequestLine(APIEndpoints.ADD_LIGHT)
    void addLight(@Param("room_id") String roomId);

    //adding the thermostat
    @RequestLine(APIEndpoints.ADD_TEMPERATURE)
    void addTemperature(@Param("room_id") String roomId);

    //update light status turn on or off
    @RequestLine(APIEndpoints.UPDATE_LIGHT)
    void updateLight(@Param("room_id") String roomId, @Param("operation") String operation);

    //increase or decrease temperature
    @RequestLine(APIEndpoints.UPDATE_TEMPERATURE)
    void updateTemperature(@Param("room_id") String roomId, @Param("operation") String operation);

//    // Endpoint to update the temperature
//    @RequestLine("POST /api/temperature/{room}/{action}")
//    String updateTemperature(@Param("room") String room, @Param("action") String action);
}
