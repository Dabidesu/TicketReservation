package com.example.prototype;

public class Trip {
    private String destination;
    private String bus_company;
    private String timeofdeparture;
    private int remainingseats;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBus_company() {
        return bus_company;
    }

    public void setBus_company(String bus_company) {
        this.bus_company = bus_company;
    }

    public String getTimeofdeparture() {

        return timeofdeparture;
    }

    public void setTimeofdeparture(String timeofdeparture) {
        this.timeofdeparture = timeofdeparture;
    }

    public int getRemainingseats() {
        return remainingseats;
    }

    public void setRemainingseats(int remainingseats) {
        this.remainingseats = remainingseats;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "destination='" + destination + '\'' +
                ", bus_company='" + bus_company + '\'' +
                ", timeofdeparture='" + timeofdeparture + '\'' +
                ", remainingseats=" + remainingseats +
                '}';
    }
}
