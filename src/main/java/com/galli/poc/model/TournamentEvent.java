package com.galli.poc.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * {
 * 		"id": "123e4567-e89b-42d3-a456-556642440000",
 * 		"game": "Ajedrez",
 * 		"enrolled": 16,
 * 		"date": "11-11-2020 18:00",
 * 		"location": {
 * 			"address": "San Martin 598",
 * 			"locality": "CABA",
 * 			"province": "Buenos Aires",
 * 			"lat" : 37.4211274197085,
 *             "lng" : -122.0855988802915
 *                }* 	}
 */
public class TournamentEvent {

    UUID id;

    String game;

    int enrolled;

    Date date;

    Location location;

    public TournamentEvent() {

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

    public Date getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm", Locale.ENGLISH);
        this.date = formatter.parse(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public class Location {

        String address;

        String locality;

        String province;

        @JsonAlias("lat")
        double latitude;

        @JsonAlias("lng")
        double longitude;

        public Location() {
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLocality() {
            return locality;
        }

        public void setLocality(String locality) {
            this.locality = locality;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
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

}
