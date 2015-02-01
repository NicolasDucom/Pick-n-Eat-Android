package com.nicolasdu.pick_n_eat;

import java.net.URL;

/**
 * Created by Nicolas on 1/30/2015.
 */
public class Review {
    private String Excerpt;
    private URL Rating;
    private String User;

    public Review(){

    }

    public Review(String excerpt, URL rating, String user) {
        this.Excerpt = excerpt;
        this.Rating = rating;
        this.User = user;
    }

    public String getExcerpt() {
        return this.Excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.Excerpt = excerpt;
    }

    public URL getRating() {
        return Rating;
    }

    public void setRating(URL rating) {
        Rating = rating;
    }

    public String getUser() {
        return this.User;
    }

    public void setUser(String user) {
        this.User = user;
    }
}
