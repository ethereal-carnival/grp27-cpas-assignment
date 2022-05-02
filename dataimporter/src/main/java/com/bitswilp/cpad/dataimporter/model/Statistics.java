package com.bitswilp.cpad.dataimporter.model;

import com.opencsv.bean.CsvBindByName;

import java.sql.Timestamp;
import java.util.Date;

public class Statistics {
    @CsvBindByName
    private String hospitalId;
    @CsvBindByName
    private final String timestamp;
    @CsvBindByName
    private int activeCases;
    @CsvBindByName
    private int totalCases;
    @CsvBindByName
    private int numRecovered;

    public Statistics(String hospitalId, int activeCases, int totalCases, int numRecovered) {
        this.hospitalId = hospitalId;
        this.activeCases = activeCases;
        this.totalCases = totalCases;
        this.numRecovered = numRecovered;
        this.timestamp = new Timestamp(new Date().getTime()).toString();
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(int activeCases) {
        this.activeCases = activeCases;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public int getNumRecovered() {
        return numRecovered;
    }

    public void setNumRecovered(int numRecovered) {
        this.numRecovered = numRecovered;
    }
}
