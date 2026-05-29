package com.sunbeaminfo.app03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmpListAdapter extends RecyclerView.Adapter<EmpListAdapter.MyViewHolder>{

    public interface onEditClickListner{
        void onEditClick(Employee employee);
    }

    Context context;
    List<Employee> employeeList;
    onEditClickListner onEditClickListner = null;


    public EmpListAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    public EmpListAdapter(Context context, List<Employee> employeeList, onEditClickListner onEditClickListner) {
        this.context = context;
        this.employeeList = employeeList;
        this.onEditClickListner = onEditClickListner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_emp,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.textEmpid.setText("Empid : "+ employee.getEmpid());
        holder.textName.setText("Name : "+ employee.getName());
        holder.textSalary.setText("Salary :"+ employee.getSalary());
        holder.imgDelete.setOnClickListener(v -> {
            employeeList.remove(position);
            notifyDataSetChanged();
        });

        holder.imgEdit.setOnClickListener(v -> onEditClickListner.onEditClick(employee));

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textEmpid, textName, textSalary;
        ImageView imgEdit, imgDelete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textEmpid = itemView.findViewById(R.id.textEmpid);
            textName = itemView.findViewById(R.id.textName);
            textSalary = itemView.findViewById(R.id.textSalary);
            imgEdit = itemView.findViewById(R.id.imgEdit);
            imgDelete = itemView.findViewById(R.id.imgDelete);

        }
    }

}
