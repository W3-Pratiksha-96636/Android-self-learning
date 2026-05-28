package com.sunbeaminfo.app03;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    RadioButton radioMale, radioFemale;

    Spinner spinnerState, spinnerCity;
    List<String> States;
    List<String> Cities;

    private static final String tag = "MainActivity";

    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave = findViewById(R.id.btnSave);
        radioFemale = findViewById(R.id.radioFemale);
        radioMale = findViewById(R.id.radioMale);
        spinnerState = findViewById(R.id.spinnerState);
        spinnerCity = findViewById(R.id.spinnerCity);

        States = new ArrayList<>();
        Collections.addAll(States,"Maharashtra","Gujrat", "Bihar", "Jharkhand");

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,States);
        spinnerState.setAdapter(arrayAdapter);
        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("Sppiner", "Item selected from position-"+position);
                Log.e("Spinner","Element Selected-"+States.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Cities = new ArrayList<>();
        Collections.addAll(Cities, "Pune", "Kolhapur", "Bhudargad", "Hinjewadi");

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Cities);
        spinnerCity.setAdapter(arrayAdapter);
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("Spinner", "Item selected"+position);
                Log.e("Spinner","Element selected:"+Cities.get(position));

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSave.setOnClickListener(v->{
            Log.e(tag, "Gender: ");
            if(radioMale.isChecked())
                Log.e(tag,"Male");
            else if(radioFemale.isChecked())
                Log.e(tag, "Female");
            else
                Log.e(tag, "Gender is not selected");

        });

    }
}