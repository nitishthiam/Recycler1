package com.nitish.recycler1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editTextName,editTextDesignation;
    Button buttonSubmit;

    MyRecyclerAdapter myRecyclerAdapter;
    ArrayList<Employee> memployeeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        editTextName = (EditText) findViewById(R.id.et_name);
        editTextDesignation = (EditText) findViewById(R.id.et_designation);

        memployeeArrayList = new ArrayList<>();
        myRecyclerAdapter = new MyRecyclerAdapter(this,memployeeArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(myRecyclerAdapter);

    }

    public void submit(View view){
        Employee employee = new Employee(editTextName.getText().toString(),
                editTextDesignation.getText().toString());
        memployeeArrayList.add(employee);

        myRecyclerAdapter.notifyItemInserted(memployeeArrayList.size()-1);
        myRecyclerAdapter.notifyItemRangeChanged(memployeeArrayList.size()-1,memployeeArrayList.size());

    }
}
