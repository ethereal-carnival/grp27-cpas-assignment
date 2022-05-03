package com.bitswilp.cpad.commonlibrary.communicationmodels;

public class Statistics {
    private int activeCases;
    private int totalDeaths;
    private int numRecovered;

    public Statistics(int activeCases, int totalDeaths, int numRecovered) {
        this.activeCases = activeCases;
        this.totalDeaths = totalDeaths;
        this.numRecovered = numRecovered;
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

    @Override
    public String toString() {
        return "StatisticsResponse{" +
                "activeCases=" + activeCases +
                ", totalDeaths=" + totalDeaths +
                ", numRecovered=" + numRecovered +
                '}';
    }
}
