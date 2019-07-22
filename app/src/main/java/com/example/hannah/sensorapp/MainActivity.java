package com.example.hannah.sensorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.phone_sensor));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0){
                    Intent myIntent = new Intent(view.getContext(), AccActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 1){
                    Intent myIntent = new Intent(view.getContext(), GyroActivity.class);
                    startActivityForResult(myIntent, 1);
                }
                if (position == 2){
                    Intent myIntent = new Intent(view.getContext(), MagnoActivity.class);
                    startActivityForResult(myIntent, 2);
                }
                if (position == 3){
                    Intent myIntent = new Intent(view.getContext(), ProActivity.class);
                    startActivityForResult(myIntent, 3);
                }
                if (position == 4){
                    Intent myIntent = new Intent(view.getContext(), CompActivity.class);
                    startActivityForResult(myIntent, 4);
                }
                if (position == 5){
                    Intent myIntent = new Intent(view.getContext(), StepCoActivity.class);
                    startActivityForResult(myIntent, 5);
                }
                if (position == 6){
                    Intent myIntent = new Intent(view.getContext(), GPSActivity.class);
                    startActivityForResult(myIntent, 6);
                }

                if (position == 7){
                    Intent myIntent = new Intent(view.getContext(), EnvActivity.class);
                    startActivityForResult(myIntent, 7);
                }
            }
        });


    listView.setAdapter(mAdapter);

    }
}
