package com.nicolasdu.pick_n_eat;

import android.media.Image;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Nicolas on 1/30/2015.
 */
public class Restaurant implements Serializable{

    private String Title;
    private String Address;
    private URL Website;
    private float Longitude;
    private float Latitude;
    private URL Rating;
    private ArrayList<Review> Reviews = new ArrayList();
    private String Phone;
    private String DisplayPhone;

    private  Restaurant() {
    }


    public  Restaurant(String title, String address, URL website, float longitude, float latitude, URL rating, String phone, String displayPhone) {
        Title = title;
        Address = address;
        Website = website;
        Longitude = longitude;
        Latitude = latitude;
        Rating = rating;
        Phone = phone;
        DisplayPhone = displayPhone;
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDisplayPhone() {
        return DisplayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        DisplayPhone = displayPhone;
    }

    @Override
    public String toString(){
        return "Name :"+getTitle()+
                " Address :"+getAddress()+
                " Website :"+getWebsite()+
                " Longitude :"+getLongitude()+
                " Latitude :"+getLatitude()+
                " Rating :"+getRating() +
                " Phone :"+getPhone();
    }
}
