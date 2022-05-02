package com.bitswilp.cpad.businessconstants;

public class StatisticsResponse {
    private int activeCases;
    private int totalCases;
    private int numRecovered;

    public StatisticsResponse(int activeCases, int totalCases, int numRecovered) {
        this.activeCases = activeCases;
        this.totalCases = totalCases;
        this.numRecovered = numRecovered;
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
        return "StatisticsResponse{" +
                "activeCases=" + activeCases +
                ", totalCases=" + totalCases +
                ", numRecovered=" + numRecovered +
                '}';
    }
}
