package com.sunbeaminfo.app01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditEmpActivity extends AppCompatActivity {

    TextView textEmpid, textName;
    EditText editSalary;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_emp);

        textEmpid = findViewById(R.id.textEmpid);
        textName = findViewById(R.id.textName);

        editSalary = findViewById(R.id.editSalary);

        btnUpdate = findViewById(R.id.btnUpdate);

        Intent intent = getIntent();

        Employee e = (Employee) intent.getSerializableExtra("employee");

        textEmpid.setText("EmpId:"+e.getEmpid());
        textName.setText("Name:"+e.getName());
        editSalary.setText("Salary:"+e.getSalary());


        btnUpdate.setOnClickListener(v -> {
            e.setSalary(Double.parseDouble(editSalary.getText().toString()));
            Intent data = new Intent();
            data.putExtra("employee",e);
            setResult(2,data);
            finish();
        });
    }
}