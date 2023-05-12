package com.googleapi.GoogleAPI.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.maps.model.DirectionsResult;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Datavalue {
	
	private final DirectionsResult directionsResult;

    // Constructor to initialize the DirectionsResult object
    public Datavalue(DirectionsResult directionsResult) {
        this.directionsResult = directionsResult;
    }
    @JsonProperty("routes")
    private Route[] routes;

    public Route[] getRoutes() {
        return routes;
    }

    public void setRoutes(Route[] routes) {
        this.routes = routes;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Route {
   
    @JsonProperty("legs")
    private Leg[] legs;

    public Leg[] getLegs() {
        return legs;
    }

    public void setLegs(Leg[] legs) {
        this.legs = legs;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Leg {
    @JsonProperty("duration")
    private Duration duration;

    @JsonProperty("distance")
    private Distance distance;
    
    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
    

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Duration {
    @JsonProperty("text")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Distance {
    @JsonProperty("text")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
