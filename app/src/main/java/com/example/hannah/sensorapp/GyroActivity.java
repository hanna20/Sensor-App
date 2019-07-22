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
public class GyroActivity extends AppCompatActivity implements SensorEventListener{

    private static final String TAG = "GyroActivity";
    //    definde sensor manager
    private SensorManager sensorManager;
    private Sensor mGyro;

    TextView xGyroValue, yGyroValue, zGyroValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyro);

        Log.d(TAG, "onCreate: Initalizing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        xGyroValue = (TextView) findViewById(R.id.xGyroValue);
        yGyroValue = (TextView) findViewById(R.id.yGyroValue);
        zGyroValue = (TextView) findViewById(R.id.zGyroValue);

        mGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (mGyro != null){
            sensorManager.registerListener(GyroActivity.this, mGyro, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered gyroscope listener");
        } else{
            xGyroValue.setText("Gyroscope Not Supported");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0] + ", Y: " + sensorEvent.values[1] + ", Z: " + sensorEvent.values[2]);

        xGyroValue.setText("X-axis: " + sensorEvent.values[0]);
        yGyroValue.setText("y-axis: " + sensorEvent.values[1]);
        zGyroValue.setText("z-axis: " + sensorEvent.values[2]);
    }
}
