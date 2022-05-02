package com.bitswilp.cpad.bedavailabiltyquery.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beds-availability")
public class BedsAvailabilityDBEntity {
    private String hospitalId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String availabilityId;
    private String timestamp;
    private int generalBeds;
    private int icuRegularBeds;
    private int icuVentilatorBeds;

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(String availabilityId) {
        this.availabilityId = availabilityId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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

    @Override
    public String toString() {
        return "BedsAvailabilityDBEntity{" +
                "hospitalId='" + hospitalId + '\'' +
                ", availabilityId='" + availabilityId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", generalBeds=" + generalBeds +
                ", icuRegularBeds=" + icuRegularBeds +
                ", icuVentilatorBeds=" + icuVentilatorBeds +
                '}';
    }
}
