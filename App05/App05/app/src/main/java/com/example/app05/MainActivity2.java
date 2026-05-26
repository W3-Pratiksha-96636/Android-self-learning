package com.example.app05;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class MainActivity2  extends AppCompatActivity {
    Spinner spinnerParent,spinnerChild;
    List<String> courses;
    List<String>subCourses;
    ArrayAdapter courseAdapter;
    ArrayAdapter subCourseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinnerParent=findViewById(R.id.spinnerParent);
        spinnerChild=findViewById(R.id.spinnerChild);
        courses=new ArrayList<>();
        subCourses=new ArrayList<>();

        Collections.addAll(courses,"Precat","PG","Modular","Internship");
        courseAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,courses);

        spinnerParent.setAdapter(courseAdapter);
        spinnerParent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        subCourses.clear();
                        Collections.addAll(subCourses,"Online","Marketyard","Hinjewadi");
                        break;
                    case 1:
                        subCourses.clear();
                        Collections.addAll(subCourses,"CPAC","CPMC","CPBDA");
                        break;
                    case 2:
                        subCourses.clear();
                        Collections.addAll(subCourses,"CPP","Java","Python");
                        break;
                    case 3:
                        subCourses.clear();
                        Collections.addAll(subCourses,"MERN","WEBPython");
                        break;
                }
            subCourseAdapter =new ArrayAdapter(MainActivity2.this, android.R.layout.simple_list_item_1,subCourses);
                spinnerChild.setAdapter(subCourseAdapter);
                spinnerChild.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Snackbar.make(view,subCourses.get(position),Snackbar.LENGTH_SHORT)
                                .setAction("undo", v->{
                                    Toast.makeText(MainActivity2.this,"undo is clicked",Toast.LENGTH_SHORT).show();
                                })
                                .show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}
