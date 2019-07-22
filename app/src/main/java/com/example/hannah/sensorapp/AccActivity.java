package com.example.hannah.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AccActivity extends AppCompatActivity implements SensorEventListener{

    private static final String TAG = "MainActivity";
    //    definde sensor manager
    private SensorManager sensorManager;
    private Sensor accelerometer;
    TextView xValue, yValue, zValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);

        Log.d(TAG, "onCreate: Initalizing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        xValue = (TextView) findViewById(R.id.xValue);
        yValue = (TextView) findViewById(R.id.yValue);
        zValue = (TextView) findViewById(R.id.zValue);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null){
            sensorManager.registerListener(AccActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered accelerometer listener");
        } else{
            xValue.setText("Accelerometer Not Supported");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0] + ", Y: " + sensorEvent.values[1] + ", Z: " + sensorEvent.values[2]);

        xValue.setText("X-axis: " + sensorEvent.values[0]);
        yValue.setText("y-axis: " + sensorEvent.values[1]);
        zValue.setText("z-axis: " + sensorEvent.values[2]);
    }
}
