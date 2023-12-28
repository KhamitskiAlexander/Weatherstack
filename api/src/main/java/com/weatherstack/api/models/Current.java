package com.weatherstack.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Current {
    private String observation_time;
    private int temperature;
    private int weather_code;
    private String[] weather_icons;
    private String[] weather_descriptions;
    private int wind_speed;
    private int wind_degree;
    private String wind_dir;
    private int pressure;
    private double precip;
    private int humidity;
    private int cloudcover;
    private int feelslike;
    private int uv_index;
    private int visibility;
    private String is_day;

    public String getObservation_time() {
        return observation_time;
    }

    public Current setObservation_time(String observation_time) {
        this.observation_time = observation_time;
        return this;
    }

    public int getTemperature() {
        return temperature;
    }

    public Current setTemperature(int temperature) {
        this.temperature = temperature;
        return this;
    }

    public int getWeather_code() {
        return weather_code;
    }

    public Current setWeather_code(int weather_code) {
        this.weather_code = weather_code;
        return this;
    }

    public String[] getWeather_icons() {
        return weather_icons;
    }

    public Current setWeather_icons(String[] weather_icons) {
        this.weather_icons = weather_icons;
        return this;
    }

    public String[] getWeather_descriptions() {
        return weather_descriptions;
    }

    public Current setWeather_descriptions(String[] weather_descriptions) {
        this.weather_descriptions = weather_descriptions;
        return this;
    }

    public int getWind_speed() {
        return wind_speed;
    }

    public Current setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
        return this;
    }

    public int getWind_degree() {
        return wind_degree;
    }

    public Current setWind_degree(int wind_degree) {
        this.wind_degree = wind_degree;
        return this;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public Current setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
        return this;
    }

    public int getPressure() {
        return pressure;
    }

    public Current setPressure(int pressure) {
        this.pressure = pressure;
        return this;
    }

    public double getPrecip() {
        return precip;
    }

    public Current setPrecip(double precip) {
        this.precip = precip;
        return this;
    }

    public int getHumidity() {
        return humidity;
    }

    public Current setHumidity(int humidity) {
        this.humidity = humidity;
        return this;
    }

    public int getCloudcover() {
        return cloudcover;
    }

    public Current setCloudcover(int cloudcover) {
        this.cloudcover = cloudcover;
        return this;
    }

    public int getFeelslike() {
        return feelslike;
    }

    public Current setFeelslike(int feelslike) {
        this.feelslike = feelslike;
        return this;
    }

    public int getUv_index() {
        return uv_index;
    }

    public Current setUv_index(int uv_index) {
        this.uv_index = uv_index;
        return this;
    }

    public int getVisibility() {
        return visibility;
    }

    public Current setVisibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public String getIs_day() {
        return is_day;
    }

    public Current setIs_day(String is_day) {
        this.is_day = is_day;
        return this;
    }
}
