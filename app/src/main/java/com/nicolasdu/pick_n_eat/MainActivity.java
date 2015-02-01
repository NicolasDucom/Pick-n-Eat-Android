package com.nicolasdu.pick_n_eat;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.location.LocationManager;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;


public class MainActivity extends ActionBarActivity {

    private LocationManager locationManager;
    private LocationListener locationListener;
    private String provider;
    float latitude = (float) 50.5167;
    float longitude = (float) 3.1667;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager locationManager;
        String context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager)getSystemService(context);

        Criteria crta = new Criteria();
        crta.setAccuracy(Criteria.ACCURACY_FINE);
        crta.setAltitudeRequired(false);
        crta.setBearingRequired(false);
        crta.setCostAllowed(true);
        crta.setPowerRequirement(Criteria.POWER_LOW);
        String provider = locationManager.getBestProvider(crta, true);

        // String provider = LocationManager.GPS_PROVIDER;
        Location location = locationManager.getLastKnownLocation(provider);
        System.out.println(location.getLatitude()+"::"+location.getLongitude());

        locationManager.requestLocationUpdates(provider, 2000, 10, locationListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
  //      locationManager.removeUpdates(this);
    }

//    @Override
//    public void onLocationChanged(Location location) {
//        latitude = (int) (location.getLatitude());
//        longitude = (int) (location.getLongitude());
//        System.out.println("Location: "+latitude+":"+longitude);
//    }

//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//    }

//    @Override
//    public void onProviderEnabled(String provider) {
//        Toast.makeText(this, "Enabled new provider " + provider,
//                Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//        Toast.makeText(this, "Disabled provider " + provider,
//                Toast.LENGTH_SHORT).show();
//    }

    public void yelpSearch(View view) {
        new AsyncTask<Void, Void, String>(){
            String temp;
            @Override
            protected String doInBackground(Void... params) {
                YelpManager yelpManager = new YelpManager();
                temp = yelpManager.search(latitude,longitude);
                return temp;
            }

            @Override
            protected void onPostExecute(String result) {
                if(result == null){
                    System.out.println("No internet connection");
                } else {
                    System.out.println(temp);
                }
             }
        }.execute();
        System.out.println();
    }
}
