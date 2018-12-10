package com.example.abc.practice6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    String Id;
    String Name;
    String Salary;
    DbHelper dbhelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        TextView txtId = (TextView)findViewById(R.id.txtId);
        EditText edtName = (EditText)findViewById(R.id.edtName);
        EditText edtSalary = (EditText)findViewById(R.id.edtSalary);
        Button btnEdit = (Button)findViewById(R.id.btnEdit);
        dbhelper = new DbHelper(getApplicationContext());
        Intent in = getIntent();
        Id=in.getStringExtra("id");
        Name = in.getStringExtra("Name");
        Salary = in.getStringExtra("Salary");
        txtId.setText(Id);

        edtName.setText(Name);
        edtSalary.setText(Salary);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edtName = (EditText)findViewById(R.id.edtName);
                EditText edtSalary = (EditText)findViewById(R.id.edtSalary);

                Name = edtName.getText().toString();
                Salary =  edtSalary.getText().toString();

                updateData();
                finish();

            }
        });




    }

    public void updateData()
    {

        String Id1 = Id;
        String Name1 = Name;
        String Salary1 = Salary;
        dbhelper.updateRecord(Id1,Name1,Salary1);

            Intent in = new Intent(UpdateActivity.this,EmployeeActivity.class);
            startActivity(in);
        Toast.makeText(UpdateActivity.this, "Record Updated Successfully..!  \n" +
                " Employee Name :" + Name1 +
                "\n Salary :" + Salary1, Toast.LENGTH_LONG).show();

    }
}
