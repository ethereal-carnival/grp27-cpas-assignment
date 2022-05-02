package com.bitswilp.cpad.businessconstants;

public class AvailabilityResponse {
    private int generalBeds;
    private int icuRegularBeds;
    private int icuVentilatorBeds;

    public AvailabilityResponse(int generalBeds, int icuRegularBeds, int icuVentilatorBeds) {
        this.generalBeds = generalBeds;
        this.icuRegularBeds = icuRegularBeds;
        this.icuVentilatorBeds = icuVentilatorBeds;
    }

    @Override
    public String toString() {
        return "AvailabilityResponse{" +
                "generalBeds=" + generalBeds +
                ", icuRegularBeds=" + icuRegularBeds +
                ", icuVentilatorBeds=" + icuVentilatorBeds +
                '}';
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
