package com.bitswilp.cpad.commonlibrary.communicationmodels;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GPSCoordinates {
    private double x;
    private double y;

    public GPSCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public GPSCoordinates(String coordinatesString) {
        List<Double> coordinates = Arrays.stream(coordinatesString.split(","))
                .map(String::trim)
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        assert coordinates.size() == 2;
        this.x = coordinates.get(0);
        this.y = coordinates.get(1);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "GPSCoordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
