package com.example.hannah.sensorapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.SettingInjectorService;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.ActivityChooserModel;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GPSActivity extends AppCompatActivity {

    private Button button;
//    private TextView textView;
    private LocationManager locationManager;
    private LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        button = (Button) findViewById(R.id.btnGetLoc);
        ActivityCompat.requestPermissions(GPSActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GPStracker g = new GPStracker(getApplicationContext());
                Location l = g.getLocation();
                if (l != null){
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    Toast.makeText(getApplicationContext(), "LAT: "+lat+ "\n LON" + lon, Toast.LENGTH_LONG).show();
                }
            }
        });

    }



}
