package com.bitswilp.cpad.dataimporter.model;

import com.opencsv.bean.CsvBindByName;

import java.sql.Timestamp;
import java.util.Date;

public class CSVModel {
    @CsvBindByName
    private String hospitalId;
    @CsvBindByName
    private int activeCases;
    @CsvBindByName
    private int totalDeaths;
    @CsvBindByName
    private int numRecovered;
    @CsvBindByName
    private final String timestamp;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String address;
    @CsvBindByName
    private String gpsCoordinates;
    @CsvBindByName
    private int generalBeds;
    @CsvBindByName
    private int icuRegularBeds;
    @CsvBindByName
    private int icuVentilatorBeds;

    public CSVModel(String hospitalId, int activeCases, int totalDeaths, int numRecovered, String name, String address, String gpsCoordinates, int generalBeds, int icuRegularBeds, int icuVentilatorBeds) {
        this.hospitalId = hospitalId;
        this.activeCases = activeCases;
        this.totalDeaths = totalDeaths;
        this.numRecovered = numRecovered;
        this.name = name;
        this.address = address;
        this.gpsCoordinates = gpsCoordinates;
        this.generalBeds = generalBeds;
        this.icuRegularBeds = icuRegularBeds;
        this.icuVentilatorBeds = icuVentilatorBeds;
        this.timestamp = new Timestamp(new Date().getTime()).toString();
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(int activeCases) {
        this.activeCases = activeCases;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getNumRecovered() {
        return numRecovered;
    }

    public void setNumRecovered(int numRecovered) {
        this.numRecovered = numRecovered;
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

    public String getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(String gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    public int getGeneralBeds() {
        return generalBeds;
    }

    public void setGeneralBeds(int generalBeds) {
        this.generalBeds = generalBeds;
    }

    public int getIcuRegularBeds() {
        return icuRegularBeds;
    }

    public void setIcuRegularBeds(int icuRegularBeds) {
        this.icuRegularBeds = icuRegularBeds;
    }

    public int getIcuVentilatorBeds() {
        return icuVentilatorBeds;
    }

    public void setIcuVentilatorBeds(int icuVentilatorBeds) {
        this.icuVentilatorBeds = icuVentilatorBeds;
    }
}
