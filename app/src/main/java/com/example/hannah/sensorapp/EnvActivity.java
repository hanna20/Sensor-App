package com.example.hannah.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class EnvActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "EnvActivity";
    //    definde sensor manager
    private SensorManager sensorManager;
    private Sensor mLight, mPressure, mTemp, mHumi;

    TextView light, pressure, temp, humi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_env);

        Log.d(TAG, "onCreate: Initalizing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        light = (TextView) findViewById(R.id.light);
        pressure = (TextView) findViewById(R.id.pressure);
        temp = (TextView) findViewById(R.id.temp);
        humi = (TextView) findViewById(R.id.humi);

        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (mLight != null){
            sensorManager.registerListener(EnvActivity.this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered light listener");
        } else{
            light.setText("Light Sensor Not Supported");
        }

        mTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (mTemp != null){
            sensorManager.registerListener(EnvActivity.this, mTemp, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered temperature listener");
        } else{
            temp.setText("Temperature Not Supported");
        }

        mPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (mPressure != null){
            sensorManager.registerListener(EnvActivity.this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered pressure listener");
        } else{
            pressure.setText("Pressure Not Supported");
        }

        mHumi = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (mHumi != null){
            sensorManager.registerListener(EnvActivity.this, mHumi, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Humidity listener");
        } else{
            humi.setText("Humidity Not Supported");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
         if (sensor.getType() == Sensor.TYPE_LIGHT){
            light.setText("Light: " + sensorEvent.values[0]);
        }
        else if (sensor.getType() == Sensor.TYPE_PRESSURE){
            pressure.setText("Pressure: " + sensorEvent.values[0]);
        }
        else if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
            temp.setText("Temperature: " + sensorEvent.values[0]);
        }
        else if (sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY){
            humi.setText("Humidity: " + sensorEvent.values[0]);
        }
    }
}
