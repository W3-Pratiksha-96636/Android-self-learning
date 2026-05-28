package com.sunbeaminfo.app01;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBoxCPAC, checkBoxCPMC, checkBoxCPBDA;
    ImageView imgAC, imgMC, imgBDA;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxCPAC = findViewById(R.id.checkboxCPAC);
        checkBoxCPMC = findViewById(R.id.checkboxCPMC);
        checkBoxCPBDA = findViewById(R.id.checkboxCPBDA);
        imgAC = findViewById(R.id.imgAC);
        imgMC = findViewById(R.id.imgMC);
        imgBDA = findViewById(R.id.imgBDA);
        btnShow = findViewById(R.id.btnShow);

        btnShow.setOnClickListener(v ->{
            if(checkBoxCPAC.isChecked())
                imgAC.setImageResource(R.drawable.cpac);
            else
                imgAC.setImageResource(R.drawable.ic_launcher_background);
            if(checkBoxCPMC.isChecked())
                imgMC.setImageResource(R.drawable.cpmc);
            else
                imgMC.setImageResource(R.drawable.ic_launcher_background);
            if(checkBoxCPBDA.isChecked())
                imgBDA.setImageResource(R.drawable.cpbda);
            else
                imgBDA.setImageResource(R.drawable.ic_launcher_background);

        });




    }
}