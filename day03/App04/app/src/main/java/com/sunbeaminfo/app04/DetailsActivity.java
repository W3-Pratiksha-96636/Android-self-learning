package com.sunbeaminfo.app04;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;


public class DetailsActivity extends AppCompatActivity {

    TextView textName, textEmail, textMobile;
    private static final String TAG = "DetailsActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textName = findViewById(R.id.textName);
        textEmail = findViewById(R.id.textEmail);
        textMobile = findViewById(R.id.textMobile);
        Log.e(TAG, "onCreate()");

        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//        String email = intent.getStringExtra("email");
//        String mobile = intent.getStringExtra("mobile");


       // Log.e(TAG,"Name:"+name);
//        textName.setText("Name:"+name);
//        textEmail.setText("Email:"+email);
//        textMobile.setText("Mobile"+mobile);

        Person p1 = (Person) intent.getSerializableExtra("person");
        textName.setText("Name"+p1.getName());
        textEmail.setText("Email:"+p1.getEmail());
        textMobile.setText("Mobile:"+p1.getMobile());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void back(View view){
        finish();
    }

}