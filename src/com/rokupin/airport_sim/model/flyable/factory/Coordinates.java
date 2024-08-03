package com.rokupin.airport_sim.model.flyable.factory;

import java.util.Objects;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    // package-private
    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    @Override
    public String toString() {
        return "[Lgt: " + longitude + ", Ltt: " + latitude + ", H: " + height + "]";
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Coordinates increaseLongitude(int amount) {
        longitude += amount;
        return this;
    }

    public Coordinates decreaseLongitude(int amount) {
        longitude -= amount;
        return this;
    }

    public Coordinates increaseLatitude(int amount) {
        latitude += amount;
        return this;
    }

    public Coordinates decreaseLatitude(int amount) {
        latitude -= amount;
        return this;
    }

    public Coordinates increaseHeight(int amount) {
        height += amount;
        return this;
    }

    public Coordinates decreaseHeight(int amount) {
        height -= amount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return longitude == that.longitude && latitude == that.latitude && height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude, height);
    }
}
