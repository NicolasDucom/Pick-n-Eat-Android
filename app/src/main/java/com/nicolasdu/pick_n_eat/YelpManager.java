package com.nicolasdu.pick_n_eat;

/**
 * Created by Nicolas on 1/31/2015.
 */
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class YelpManager {
    String consumerKey = "uky7EX89JrjhWMdf_kOAAw";
    String consumerSecret = "dKheSzFpdantR4eDVr0QUsmlTT8";
    String token = "liNJWPnFJdu74A5UzMzeWICRbejfQpWB";
    String tokenSecret = "uQefdhMJHbstMP9pl_Vbj5pLX0I";
    OAuthService service;
    Token accessToken;

    public YelpManager() {
        this.service = new ServiceBuilder().provider(Yelp.class).apiKey(this.consumerKey).apiSecret(this.consumerSecret).build();
        this.accessToken = new Token(this.token, this.tokenSecret);
    }

    public JSONObject search(double latitude, double longitude) {
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
        double lat = 50.633100;
        double lng = 3.051389;
        request.addQuerystringParameter("ll", lat + "," + lng);


        this.service.signRequest(this.accessToken, request);
        try {
            Response response = request.send();
            return new JSONObject(response.getBody());
        }
        catch (Exception e){
            return null;
        }
    }

    public Restaurant getRandomRestaurant(JSONObject yelpResponse)
    {
        String name, phone, displayPhone;
        ArrayList<String> address = new ArrayList<>();
        float longitude, latitude;
        java.net.URL rating = null, website = null;
        try {
           JSONArray jsonRestaurants = yelpResponse.getJSONArray("businesses");
           int numResponse = jsonRestaurants.length();
           System.out.println(numResponse);
           JSONObject jsonRestaurant = jsonRestaurants.getJSONObject((int) (Math.random()*numResponse));
           System.out.println(jsonRestaurant);
           name = jsonRestaurant.get("name").toString();
            for (int i = 0; i < jsonRestaurant.getJSONObject("location").getJSONArray("display_address").length(); i++) {
                address.add(jsonRestaurant.getJSONObject("location").getJSONArray("display_address").get(i).toString());
            }
           phone = jsonRestaurant.get("phone").toString();
           displayPhone = jsonRestaurant.get("display_phone").toString();
            try {
                website = new URL(jsonRestaurant.get("mobile_url").toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
           longitude = Float.parseFloat(jsonRestaurant.getJSONObject("location").getJSONObject("coordinate").get("longitude").toString());
           latitude = Float.parseFloat(jsonRestaurant.getJSONObject("location").getJSONObject("coordinate").get("latitude").toString());
            try {
                rating = new URL(jsonRestaurant.get("rating_img_url").toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Restaurant restaurant = new Restaurant(name, address, website, longitude, latitude, rating, phone, displayPhone);
            System.out.println(restaurant.toString());
            return restaurant;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }



}
