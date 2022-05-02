package com.bitswilp.cpad.statistics.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statistics")
public class StatisticsDBEntity {
    private String hospitalId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String statisticsId;
    private String timestamp;
    private int activeCases;
    private int totalCases;
    private int numRecovered;

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(String statisticsId) {
        this.statisticsId = statisticsId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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

    @Override
    public String toString() {
        return "StatisticsDBEntity{" +
                "hospitalId='" + hospitalId + '\'' +
                ", statisticsId='" + statisticsId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", activeCases=" + activeCases +
                ", totalCases=" + totalCases +
                ", numRecovered=" + numRecovered +
                '}';
    }
}
