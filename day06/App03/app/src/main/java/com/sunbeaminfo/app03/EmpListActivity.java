package com.sunbeaminfo.app03;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmpListActivity extends AppCompatActivity implements EmpListAdapter.onEditClickListner{

    ImageView imgAdd;
    RecyclerView recyclerView;
    List<Employee> employeeList;
    EmpListAdapter empListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_list);
        imgAdd = findViewById(R.id.imgAdd);
        recyclerView = findViewById(R.id.recyclerView);
        addDummayEmployees();

        //empListAdapter = new EmpListAdapter(this, employeeList);
        empListAdapter = new EmpListAdapter(this, employeeList,this);


        recyclerView.setAdapter(empListAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        imgAdd.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEmpActivity.class);
            activityResultLauncher.launch(intent);

        });
    }

    ActivityResultLauncher activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

            if (result.getResultCode()==1){
                Intent intent = result.getData();
                Employee employee = (Employee) intent.getSerializableExtra("employee");
                employeeList.add(employee);
                empListAdapter.notifyDataSetChanged();
            }
            else if(result.getResultCode()==2){
                Employee employee = (Employee) result.getData().getSerializableExtra("employee");

                //int index = employeeList.indexOf(employee);
                //employeeList.get(index).setSalary(employee.getSalary());

                employeeList.remove(employee);
                employeeList.add(employee);
                empListAdapter.notifyDataSetChanged();
            }
        }
    });

    @Override
    public void onEditClick(Employee employee){
        Intent intent = new Intent(this, EditEmpActivity.class);
        intent.putExtra("employee",employee);
        activityResultLauncher.launch(intent);
    }


    private void addDummayEmployees() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Rutuja",10000));
        employeeList.add(new Employee(2,"Rasika",20000));
        employeeList.add(new Employee(3,"Pratiksha",30000));
        employeeList.add(new Employee(4,"Sonam",40000));
        employeeList.add(new Employee(5,"Anshu",50000));

    }
}