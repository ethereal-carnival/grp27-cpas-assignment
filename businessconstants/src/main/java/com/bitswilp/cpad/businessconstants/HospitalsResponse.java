package com.bitswilp.cpad.businessconstants;

public class HospitalsResponse {
    private String name;
    private String address;
    private GPSCoordinates gpsCoordinates;

    public HospitalsResponse(String name, String address, GPSCoordinates gpsCoordinates) {
        this.name = name;
        this.address = address;
        this.gpsCoordinates = gpsCoordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GPSCoordinates getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(GPSCoordinates gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    @Override
    public String toString() {
        return "HospitalsResponse{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gpsCoordinates=" + gpsCoordinates +
                '}';
    }
}
