package com.weatherstack.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherForecast {
    private Request request;
    private Location location;
    private Current current;

    public Request getRequest() {
        return request;
    }

    public WeatherForecast setRequest(Request request) {
        this.request = request;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public WeatherForecast setLocation(Location location) {
        this.location = location;
        return this;
    }

    public Current getCurrent() {
        return current;
    }

    public WeatherForecast setCurrent(Current current) {
        this.current = current;
        return this;
    }
}
