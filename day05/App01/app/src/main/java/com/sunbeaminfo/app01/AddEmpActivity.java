package com.sunbeaminfo.app01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddEmpActivity extends AppCompatActivity {

    EditText editEmpid, editName, editSalary;
    ImageView imgSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emp);

        editEmpid = findViewById(R.id.editEmpId);
        editName = findViewById(R.id.editName);
        editSalary = findViewById(R.id.editSalary);

        imgSave = findViewById(R.id.imgSave);

        imgSave.setOnClickListener(v -> {
            Employee emp = new Employee();
            emp.setEmpid(Integer.parseInt(editEmpid.getText().toString()));
            emp.setName(editName.getText().toString());
            emp.setSalary(Double.parseDouble(editSalary.getText().toString()));

            Intent intent = new Intent();
            intent.putExtra("employee",emp);
            setResult(1,intent);
            finish();
        });
    }
}