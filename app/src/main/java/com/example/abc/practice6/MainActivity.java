package com.example.abc.practice6;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button btnInsert,btnSelect;
    EditText edtName,edtSalary;
    Cursor cursor;
    DbHelper dbHelper;
    ArrayList<Employee> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnSelect = (Button)findViewById(R.id.btnSelect);
        edtName = (EditText)findViewById(R.id.edtName);
        edtSalary= (EditText)findViewById(R.id.edtSalary);
            dbHelper = new DbHelper(getApplicationContext());
        arrayList = new ArrayList<Employee>();
        btnInsert.setOnClickListener(this);
        btnSelect.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnInsert:
                    String Name1 = edtName.getText().toString();
                    String Salary1 = edtSalary.getText().toString();
                    dbHelper.insertRecord_employee(Name1,Salary1);
                edtName.setText("");
                edtSalary.setText("");
                Toast.makeText(MainActivity.this,"Record Inserted Success",Toast.LENGTH_LONG).show();
                break;

            case R.id.btnSelect:
             //   Toast.makeText(MainActivity.this,"shailesh",Toast.LENGTH_LONG).show();
                Intent in = new Intent(MainActivity.this,EmployeeActivity.class);
                startActivity(in);

        }

    }
}
