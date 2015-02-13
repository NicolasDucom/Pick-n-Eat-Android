package com.nicolasdu.pick_n_eat;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class RestaurantActivity extends ActionBarActivity {
Restaurant restaurant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        restaurant = (Restaurant) getIntent().getSerializableExtra("Restaurant");
        setViewContents();
    }

    public void setViewContents(){
        TextView title = (TextView)findViewById(R.id.textView2);
        TextView address = (TextView)findViewById(R.id.textView);
        TextView phone = (TextView)findViewById(R.id.textView4);
        TextView website = (TextView)findViewById(R.id.textView5);
        title.setText(restaurant.getTitle());
        phone.setText(restaurant.getDisplayPhone());
        address.setText(restaurant.getAddress());
        website.setText(restaurant.getWebsite().toString());
    }

    public void openMapDirections(View view){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr="+restaurant.getLatitude()+","+restaurant.getLongitude()));
        startActivity(intent);
    }

    public void callRestaurant(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+restaurant.getPhone()));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(RestaurantActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
