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



public class MagnoActivity extends AppCompatActivity implements SensorEventListener{

    private static final String TAG = "MainActivity";
    //    definde sensor manager
    private SensorManager sensorManager;
    private Sensor mMagno;

    TextView xMagValue, yMagValue, zMagValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magno);

        Log.d(TAG, "onCreate: Initalizing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        xMagValue = (TextView) findViewById(R.id.xMagValue);
        yMagValue = (TextView) findViewById(R.id.yMagValue);
        zMagValue = (TextView) findViewById(R.id.zMagValue);

        mMagno = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mMagno != null){
            sensorManager.registerListener(MagnoActivity.this, mMagno, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered magnetometer listener");
        } else{
            xMagValue.setText("Magnetometer Not Supported");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0] + ", Y: " + sensorEvent.values[1] + ", Z: " + sensorEvent.values[2]);

        xMagValue.setText("X-axis: " + sensorEvent.values[0]);
        yMagValue.setText("y-axis: " + sensorEvent.values[1]);
        zMagValue.setText("z-axis: " + sensorEvent.values[2]);
    }


}