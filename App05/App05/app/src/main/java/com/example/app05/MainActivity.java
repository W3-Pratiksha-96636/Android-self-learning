package com.example.app05;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerCourse;
    List<String> courses;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCourse=findViewById(R.id.spinnerCourse);
        courses=new ArrayList<>();

        Collections.addAll(courses,"Precat","PG","Modular","Internship");
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,courses);

        spinnerCourse.setAdapter(arrayAdapter);

        spinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("Spinner","Item selected from position- "+position);
                Log.e("Spinner","Element selected- "+courses.get(position));

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}