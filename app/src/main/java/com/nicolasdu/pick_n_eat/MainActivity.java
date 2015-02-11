package com.nicolasdu.pick_n_eat;
//coucou
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
import org.json.JSONObject;

import javax.xml.datatype.Duration;


public class MainActivity extends ActionBarActivity implements LocationListener{

    double latitude;
    double longitude;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    String provider;
    protected boolean gps_enabled,network_enabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
       // gps_enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
      //  network_enabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        //if (!gps_enabled || !network_enabled){
          //  Intent myIntent = new Intent( android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS );
            //context.startActivity(myIntent);
       // }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
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
    }

    @Override
    protected void onPause() {
        super.onPause();
    }



    public void yelpSearch(View view) {
        new AsyncTask<Void, Void, Restaurant>(){
            JSONObject temp;
            @Override
            protected Restaurant doInBackground(Void... params) {
                YelpManager yelpManager = new YelpManager();
                temp = yelpManager.search(latitude,longitude);
                return yelpManager.getRandomRestaurant(temp);
            }

            @Override
            protected void onPostExecute(Restaurant result) {

                if(result == null){
                    System.out.println("No internet connection");
                } else {
                    System.out.println(temp);
                }
                Intent intent  = new Intent(MainActivity.this, RestaurantActivity.class);
                intent.putExtra("Restaurant", result);
                startActivity(intent);
             }
        }.execute();

    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        System.out.println("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Toast toast = Toast.makeText(context, "Status Changed", Toast.LENGTH_SHORT);
    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast toast = Toast.makeText(context, "Location enabled", Toast.LENGTH_SHORT);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast toast = Toast.makeText(context, "Location disabled", Toast.LENGTH_SHORT);
    }
}
