package org.example.smarthomedesktopapp.apiInterface;

public class APIEndpoints {


    public static final String API_STATUS = "GET /api/status";
    public static final String ROOMS = "/api/rooms";
    public static final String ROOM_STATUS = "/api/rooms/{room}";
    public static final String ADD_LIGHT = "/api/rooms/{room_id}/devices/light";
    public static final String ADD_TEMPERATURE = "/api/rooms/{room_id}/devices/thermostat";
    public static final String UPDATE_LIGHT = "/api/rooms/{room_id}/light/{operation}";
    public static final String UPDATE_TEMPERATURE = "/api/rooms/{room_id}/temperature/{operation}";
}
