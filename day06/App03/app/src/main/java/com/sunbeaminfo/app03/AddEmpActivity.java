package com.sunbeaminfo.app03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddEmpActivity extends AppCompatActivity {

    EditText editEmpid, editName, editSalary;

    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emp);

        editEmpid = findViewById(R.id.editEmpid);
        editName = findViewById(R.id.editName);
        editSalary = findViewById(R.id.editSalary);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            Employee employee = new Employee();
            employee.setEmpid(Integer.parseInt(editEmpid.getText().toString()));
            employee.setName(editName.getText().toString());
            employee.setSalary(Double.parseDouble(editSalary.getText().toString()));
            Intent intent = new Intent();
            intent.putExtra("employee",employee);
            setResult(1,intent);
            finish();

        });
    }
}