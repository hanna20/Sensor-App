package com.example.hannah.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity{

    Toolbar mToolbar;
    private static final String TAG = "SecondActivity";
    //    definde sensor manager
    private SensorManager sensorManager;
    private Sensor accelerometer, mGyro, mMagno, mLight, mPressure, mTemp, mHumi;

    TextView xValue, yValue, zValue, xGyroValue, yGyroValue, zGyroValue, xMagValue, yMagValue, zMagValue, light, pressure, temp, humi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        Bundle bundle = getIntent().getExtras();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        mToolbar.setTitle(bundle.getString("Sensor_Name"));


    

    }
}
