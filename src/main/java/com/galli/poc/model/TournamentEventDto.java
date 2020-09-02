package com.galli.poc.model;

import java.util.UUID;

public class TournamentEventDto {

    UUID id;

    String game;

    int enrolled;

    //Ejemplo: 18 nov 2020 14:00
    String date;

    //Ejemplo: "San Martin 598, CABA, Buenos Aires"
    String address;

    double latitude;

    double longitude;

    public TournamentEventDto() {
    }

    public TournamentEventDto(UUID id, String game, int enrolled, String date, String address, double latitude, double longitude) {
        this.id = id;
        this.game = game;
        this.enrolled = enrolled;
        this.date = date;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
