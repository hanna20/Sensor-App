package com.example.hannah.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ProActivity extends AppCompatActivity implements SensorEventListener{

    private static final String TAG = "MainActivity";
    //    definition sensor manager
    private SensorManager sensorManager;
    private Sensor mPro;

    TextView txtProValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        txtProValue = (TextView) findViewById(R.id.ProValue);

        mPro = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (mPro != null){
            sensorManager.registerListener(ProActivity.this, mPro, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered proximity listener");
        } else{
            txtProValue.setText("Proximity Not Supported");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
       if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY){
            txtProValue.setText(""+sensorEvent.values[0]);
       }

    }
}