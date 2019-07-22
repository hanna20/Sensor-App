package com.example.hannah.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class StepCoActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager sensorManager;
    TextView tv_steps;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_co);

        tv_steps = (TextView) findViewById(R.id.tv_steps);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    public void onResume(){
        super.onResume();
        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor != null){
            sensorManager.registerListener(StepCoActivity.this, countSensor, SensorManager.SENSOR_DELAY_NORMAL);

        } else{
            Toast.makeText(this, "Sensor not found!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        running = false;
//        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (running){
            tv_steps.setText(String.valueOf(sensorEvent.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuarcy){

    }

}
