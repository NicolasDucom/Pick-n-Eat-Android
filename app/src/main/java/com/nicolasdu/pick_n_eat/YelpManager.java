package com.nicolasdu.pick_n_eat;

/**
 * Created by Nicolas on 1/31/2015.
 */
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;


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

    public String search(double latitude, double longitude) {
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");

        request.addQuerystringParameter("ll", latitude + "," + longitude);
        this.service.signRequest(this.accessToken, request);
        try {
            Response response = request.send();
            return response.getBody();
        }
        catch (Exception e){
            return null;
        }

    }



}
