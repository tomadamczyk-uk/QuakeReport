package com.example.android.quakereport;

public class Earthquake {

    private String magnitude;
    private String location;
    private String locationOffset;
    private String date;
    private String time;

    public Earthquake(String magnitude, String location, String date, String time){
        this.magnitude = magnitude;
        this.location = setLocation(location);
        this.locationOffset = setLocationOffset(location);
        this.date = date;
        this.time = time;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getDate() {
        return date;
    }

    public String getTime(){
        return time;
    }

    public String setLocationOffset(String s) {
        String output = "";

        if(s.indexOf(" of ") == -1){
            output = "Near the";
        } else {
            output = s.substring(0,(s.indexOf(" of ") + 3));
        }
        return output;
    }

    public String setLocation(String s) {
        String output = "";

        if(s.indexOf(" of ") == -1){
            output = s;
        } else {
            output = s.substring(s.indexOf(" of ") + 4);
        }

        return output;
    }

    public String getLocation() {
        return location;
    }

    public String getLocationOffset() {
        return locationOffset;
    }



}
