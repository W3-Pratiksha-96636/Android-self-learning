package com.sunbeaminfo.app04;

import android.content.Intent;
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

    EditText editName,editEmail, editMobile;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editMobile = findViewById(R.id.editMobile);
        Log.e(TAG,"onCreate()");

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

    public void save(View view) {
//        String name = editName.getText().toString();
//        String email = editEmail.getText().toString();
//        String mobile = editMobile.getText().toString();


        Person p1 = new Person();
        p1.setName(editName.getText().toString());
        p1.setEmail(editEmail.getText().toString());
        p1.setMobile(editMobile.getText().toString());

        Intent intent = new Intent(this, DetailsActivity.class);
//        intent.putExtra("name", name);
//        intent.putExtra("email", email);
//        intent.putExtra("mobile",mobile);

        intent.putExtra("person",p1);
        startActivity(intent);
    }

}