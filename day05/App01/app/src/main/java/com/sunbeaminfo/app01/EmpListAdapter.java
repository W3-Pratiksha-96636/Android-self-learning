package com.sunbeaminfo.app01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

public class EmpListAdapter extends BaseAdapter{

    Context context;
    List<Employee> employeeList;

    public EmpListAdapter(Context context, List<Employee> employeeList){
        this.context = context;
        this.employeeList =employeeList;
    }


    @Override
    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_emp, null);
        TextView textEmpid = view.findViewById(R.id.textEmpid);
        TextView textName = view.findViewById(R.id.textName);
        TextView textSalary = view.findViewById(R.id.textSalary);

        Employee emp = employeeList.get(position);

        textEmpid.setText("Empid: " + emp.getEmpid());
        textName.setText("Name: "+emp.getName());
        textSalary.setText("Salary: "+emp.getSalary());

        return view;
    }
}
