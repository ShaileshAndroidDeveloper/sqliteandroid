package com.example.abc.practice6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class
DeleteActivity extends AppCompatActivity {
    String id;
    DbHelper dbhelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.activity_delete);

        Intent in = getIntent();
         id = in.getStringExtra("id");
         dbhelper = new DbHelper(getApplicationContext());

        deleteData();
        finish();

    }

   public void deleteData() {

        dbhelper.deleteRecord(id);
        Intent in = new Intent(DeleteActivity.this,EmployeeActivity.class);
        startActivity(in);



    }
}

