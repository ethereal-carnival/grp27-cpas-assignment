package com.bitswilp.cpad.nearbyhospitalfinder.persistence;

import com.bitswilp.cpad.businessconstants.GPSCoordinates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospitals")
public class HospitalsDBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String hospitalId;
    private String name;
    private String address;
    private int generalBeds;
    private String gpsCoordinates;

    public HospitalsDBEntity() {
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
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

    @Override
    public String toString() {
        return "HospitalsDBEntity{" +
                "hospitalId='" + hospitalId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", generalBeds=" + generalBeds +
                ", gpsCoordinates='" + gpsCoordinates + '\'' +
                '}';
    }
}
