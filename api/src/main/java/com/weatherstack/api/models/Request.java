package com.weatherstack.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {
    private String type;
    private String query;
    private String language;
    private String unit;

    public String getType() {
        return type;
    }

    public Request setType(String type) {
        this.type = type;
        return this;
    }

    public String getQuery() {
        return query;
    }

    public Request setQuery(String query) {
        this.query = query;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Request setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public Request setUnit(String unit) {
        this.unit = unit;
        return this;
    }
}
