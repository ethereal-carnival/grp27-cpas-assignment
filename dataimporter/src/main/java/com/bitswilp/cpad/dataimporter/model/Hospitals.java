package com.bitswilp.cpad.dataimporter.model;

import com.opencsv.bean.CsvBindByName;

import java.sql.Timestamp;
import java.util.Date;

public class Hospitals {
    @CsvBindByName
    private final String timestamp;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String address;
    @CsvBindByName
    private int generalBeds;
    @CsvBindByName
    private String gpsCoordinates;

    public Hospitals(String name, String address, int generalBeds, String gpsCoordinates) {
        this.name = name;
        this.address = address;
        this.generalBeds = generalBeds;
        this.gpsCoordinates = gpsCoordinates;
        this.timestamp = new Timestamp(new Date().getTime()).toString();
    }

    public String getTimestamp() {
        return timestamp;
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

    public int getGeneralBeds() {
        return generalBeds;
    }

    public void setGeneralBeds(int generalBeds) {
        this.generalBeds = generalBeds;
    }

    public String getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(String gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }
}
