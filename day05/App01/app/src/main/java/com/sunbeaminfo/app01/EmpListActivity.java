package com.sunbeaminfo.app01;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class EmpListActivity extends AppCompatActivity {

    ListView listEmployees;
    Toolbar toolbar;
    List<Employee> employeeList;

    EmpListAdapter empListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_list);
        listEmployees = findViewById(R.id.listView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        employeeList = new ArrayList<>();
        empListAdapter = new EmpListAdapter(this,employeeList);
        listEmployees.setAdapter(empListAdapter);

        dummyEmployees();

        listEmployees.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(EmpListActivity.this,employeeList.get(position).getName(),Toast.LENGTH_LONG).show();

            }
        });

        registerForContextMenu(listEmployees);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("edit");
        menu.add("Delete");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getTitle().equals("Delete")) {
            employeeList.remove(adapterContextMenuInfo.position);
            empListAdapter.notifyDataSetChanged();
        }else if(item.getTitle().equals("edit")){
            Intent intent = new Intent(this, EditEmpActivity.class);
            intent.putExtra("employee",employeeList.get(adapterContextMenuInfo.position));
            activityResultLauncher.launch(intent);

        }

        return super.onContextItemSelected(item);
    }
    ActivityResultLauncher activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode()== 1){
                Intent intent = result.getData();
                Employee e = (Employee) intent.getSerializableExtra("employee");
                employeeList.add(e);
                empListAdapter.notifyDataSetChanged();
            }
            else if(result.getResultCode() == 2){
                Intent intent = result.getData();
                Employee e = (Employee) intent.getSerializableExtra("employee");
                employeeList.remove(e);
                employeeList.add(e);
                empListAdapter.notifyDataSetChanged();
            }
        }
    });

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("add").setIcon(R.drawable.add).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, AddEmpActivity.class);
        activityResultLauncher.launch(intent);
        return super.onOptionsItemSelected(item);
    }

    private void dummyEmployees(){
        employeeList.add(new Employee(1,"Rutuja",10000));
        employeeList.add(new Employee(2,"Rasika",20000));
        employeeList.add(new Employee(3,"Pratiksha",30000));
        employeeList.add(new Employee(4,"Sonam",40000));
        employeeList.add(new Employee(5,"Anshu",50000));
        employeeList.add(new Employee(6,"Prajkta",60000));



    }
}