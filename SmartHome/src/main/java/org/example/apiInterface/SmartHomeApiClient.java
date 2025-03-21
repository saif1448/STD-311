package org.example.apiInterface;

import feign.Param;
import feign.RequestLine;

public interface SmartHomeApiClient {

    // Endpoint to get the status of rooms
    @RequestLine("GET /api/status")
    String getStatus();

    // Endpoint to update light status
    @RequestLine("POST /api/light/{room}/{status}")
    void updateLight(@Param("room") String room, @Param("status") String status);

    // Endpoint to update the temperature
    @RequestLine("POST /api/temperature/{room}/{action}")
    String updateTemperature(@Param("room") String room, @Param("action") String action);
}
