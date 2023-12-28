package com.weatherstack.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {
    private String name;
    private String country;
    private String region;
    private String lat;
    private String lon;
    private String timezone_id;
    private String localtime;
    private int localtime_epoch;
    private String utc_offset;

    public String getName() {
        return name;
    }

    public Location setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Location setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Location setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getLat() {
        return lat;
    }

    public Location setLat(String lat) {
        this.lat = lat;
        return this;
    }

    public String getLon() {
        return lon;
    }

    public Location setLon(String lon) {
        this.lon = lon;
        return this;
    }

    public String getTimezone_id() {
        return timezone_id;
    }

    public Location setTimezone_id(String timezone_id) {
        this.timezone_id = timezone_id;
        return this;
    }

    public String getLocaltime() {
        return localtime;
    }

    public Location setLocaltime(String localtime) {
        this.localtime = localtime;
        return this;
    }

    public int getLocaltime_epoch() {
        return localtime_epoch;
    }

    public Location setLocaltime_epoch(int localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
        return this;
    }

    public String getUtc_offset() {
        return utc_offset;
    }

    public Location setUtc_offset(String utc_offset) {
        this.utc_offset = utc_offset;
        return this;
    }
}
