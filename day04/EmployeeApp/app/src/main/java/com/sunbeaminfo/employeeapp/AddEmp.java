package com.sunbeaminfo.employeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddEmp extends AppCompatActivity {

    EditText editEmpId,editEmpName, editEmpSalary;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emp);

        editEmpId = findViewById(R.id.editEmpId);
        editEmpName = findViewById(R.id.editEmpName);
        editEmpSalary = findViewById(R.id.editEmpSalary);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v->{
            String Id = editEmpId.getText().toString();
            String employee = editEmpName.getText().toString();
            String Salary = editEmpSalary.getText().toString();


            Intent intent = new Intent();

            intent.putExtra("id",Id);
            intent.putExtra("name",employee);
            intent.putExtra("salary",Salary);

            setResult(1,intent);
            finish();
        });

    }
}