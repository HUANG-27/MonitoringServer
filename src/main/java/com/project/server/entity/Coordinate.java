package com.project.server.entity;

import java.io.Serializable;

public class Coordinate implements Serializable {

    private double lat;
    private double lon;
    private double alt;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getAlt() {
        return alt;
    }

    public void setAlt(double alt) {
        this.alt = alt;
    }

    public Coordinate() {
        setLat(0d);
        setLon(0d);
        setAlt(0d);
    }

    public Coordinate(double lat, double lon, double alt) {
        setLat(lat);
        setLon(lon);
        setAlt(alt);
    }
}
