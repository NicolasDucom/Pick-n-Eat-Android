package com.nicolasdu.pick_n_eat;

import android.media.Image;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Nicolas on 1/30/2015.
 */
public class Restaurant {

    private String Title;
    private String Address;
    private URL Website;
    private float Longitude;
    private float Latitude;
    private URL Rating;
    private ArrayList<Review> Reviews = new ArrayList();

    private Restaurant() {
    }



    public Restaurant(String title, String address, URL website, float longitude, float latitude, URL rating) {
        Title = title;
        Address = address;
        Website = website;
        Longitude = longitude;
        Latitude = latitude;
        Rating = rating;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public URL getWebsite() {
        return Website;
    }

    public void setWebsite(URL website) {
        Website = website;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public URL getRating() {
        return Rating;
    }

    public void setRating(URL rating) {
        Rating = rating;
    }
}
