package com.sunbeaminfo.app03;

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

    TextView textName, textEmpid;
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

        Employee employee = (Employee) getIntent().getSerializableExtra("employee");
        textEmpid.setText(""+employee.getEmpid());
        textName.setText(""+employee.getName());
        editSalary.setText(""+employee.getSalary());

        btnUpdate.setOnClickListener(v -> {
            employee.setSalary(Double.parseDouble(editSalary.getText().toString()));
            Intent intent = new Intent();
            intent.putExtra("employee",employee);
            setResult(2,intent);
            finish();
        });
    }
}