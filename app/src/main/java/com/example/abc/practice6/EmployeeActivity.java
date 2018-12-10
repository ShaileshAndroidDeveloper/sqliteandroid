package com.example.abc.practice6;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EmployeeActivity extends AppCompatActivity {
    ListView lstEmployee;
    ArrayList<Employee> arrayList;
    CustomEmployeeAdapter customEmployeeAdapter;
    DbHelper dbhelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        dbhelper = new DbHelper(getApplicationContext());
        lstEmployee =(ListView)findViewById(R.id.lstEmployee);

        getData();
       // Intent in = getIntent();
       // String strName = in.getStringExtra("name");
       // String strSalary = in.getStringExtra("salary");

       // arrayList.add(new Employee(strName,strSalary));

        customEmployeeAdapter = new CustomEmployeeAdapter(EmployeeActivity.this,arrayList);

        lstEmployee.setAdapter(customEmployeeAdapter);

       customEmployeeAdapter.notifyDataSetChanged();



    }

    public void getData()
    {
        Cursor cursor =  dbhelper.selectRecord_employee();
        arrayList = new ArrayList<Employee>();
        arrayList.clear();

        if (cursor.moveToFirst())
        {

            do {
                String Id= cursor.getString(cursor.getColumnIndex(DbHelper.ID));
                String strName = cursor.getString(cursor.getColumnIndex(DbHelper.Name));
                String strSalary = cursor.getString(cursor.getColumnIndex(DbHelper.Salary));

                  arrayList.add(new Employee(Id,strName,strSalary));


            } while (cursor.moveToNext());

        }

        cursor.close();
    }
}
