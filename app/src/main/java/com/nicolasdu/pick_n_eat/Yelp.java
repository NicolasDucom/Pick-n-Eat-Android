package com.nicolasdu.pick_n_eat;

/**
 * Created by Nicolas on 1/31/2015.
 */
import org.scribe.model.Token;
import org.scribe.builder.api.DefaultApi10a;

public class Yelp extends DefaultApi10a{


    @Override
    public String getRequestTokenEndpoint() {
        return null;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return null;
    }

    @Override
    public String getAuthorizationUrl(Token requestToken) {
        return null;
    }
}
