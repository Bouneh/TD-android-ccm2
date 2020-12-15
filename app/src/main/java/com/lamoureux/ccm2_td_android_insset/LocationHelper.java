package com.lamoureux.ccm2_td_android_insset;

public class LocationHelper {
    private double Longitude;
    private double Latitude;

    public LocationHelper(double longitude, double latitude){
        Longitude = longitude;
        Latitude  = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }
}
