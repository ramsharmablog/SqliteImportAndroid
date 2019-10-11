package com.aarogya.pro.sqliteimportandroid;

/**
 * Created by Vikas on 3/11/2019.
 */

public class RDPSDATA {
    double latitude;
    double longitude;
    String event;
    String distance;
    String Kilometer;
    String Extrapoint;

    public RDPSDATA(double latitude, double longitude, String event, String distance, String Kilometer, String Extrapoint) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.event = event;
        this.distance = distance;
        this.Kilometer = Kilometer;
        this.Extrapoint=Extrapoint;
    }

    public String getKilometer() {
        return Kilometer;
    }

    public void setKilometer(String kilometer) {
        Kilometer = kilometer;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getExtrapoint() {
        return Extrapoint;
    }

    public void setExtrapoint(String extrapoint) {
        Extrapoint = extrapoint;
    }
}
