package com.sunbeaminfo.app02;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Button btnSave;

    EditText editName, editPrice, editDescription, editRam, editStorage, editCamera,
            editFrontCamera, editBattery, editSim, editBoxContents;
    Button btnSave;

    private static final String tag = "test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("MainActivity", "Inside onCreate()");
        setContentView(R.layout.activity_main);

        editName=findViewById(R.id.editName);
        editPrice=findViewById(R.id.editPrice);
        editDescription=findViewById(R.id.editDescription);
        editRam=findViewById(R.id.editRam);
        editStorage=findViewById(R.id.editStorage);
        editCamera=findViewById(R.id.editCamera);
        editFrontCamera=findViewById(R.id.editFrontCamera);
        editBattery=findViewById(R.id.editBattery);
        editSim=findViewById(R.id.editSim);
        editBoxContents=findViewById(R.id.editBoxContents);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v->{
            String Name = editName.getText().toString();
            String Price = editPrice.getText().toString();
            String Description = editDescription.getText().toString();
            String Ram = editRam.getText().toString();
            String Storage = editStorage.getText().toString();
            String Camera = editCamera.getText().toString();
            String FrontCamera = editFrontCamera.getText().toString();
            String Battery = editBattery.getText().toString();
            String Sim = editSim.getText().toString();
            String BoxContents = editBoxContents.getText().toString();

            Log.e(tag,"Name - "+Name);
            Log.e(tag,"Price - "+Price);
            Log.e(tag,"Description - "+Description);
            Log.e(tag,"Ram - "+Ram);
            Log.e(tag,"Storage - "+Storage);
            Log.e(tag,"Camera - "+Camera);
            Log.e(tag,"FrontCamera - "+FrontCamera);
            Log.e(tag,"Battery - "+Battery);
            Log.e(tag,"Sim - "+Sim);
            Log.e(tag,"BoxContents - "+BoxContents);


        });



//        btnSave = findViewById(R.id.btnSave);
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("MainActivity", "Button Clicked");
//            }
//        });

//        btnSave.setOnClickListener(v->{
//            Log.e("MainActivity","Button Clicked");
//        });

    }
//    public void save(View v) {
//        Log.e("MainActivity", "Button clicked");
//    }

   //get objs of viwes created



}