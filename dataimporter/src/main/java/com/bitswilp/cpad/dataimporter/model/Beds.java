package com.bitswilp.cpad.dataimporter.model;

import com.opencsv.bean.CsvBindByName;

import java.sql.Timestamp;
import java.util.Date;

public class Beds {
    @CsvBindByName
    private String hospitalId;
    @CsvBindByName
    private final String timestamp;
    @CsvBindByName
    private int generalBeds;
    @CsvBindByName
    private int icuRegularBeds;
    @CsvBindByName
    private int icuVentilatorBeds;

    public Beds(String hospitalId, int generalBeds, int icuRegularBeds, int icuVentilatorBeds) {
        this.hospitalId = hospitalId;
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

    public String getTimestamp() {
        return timestamp;
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
