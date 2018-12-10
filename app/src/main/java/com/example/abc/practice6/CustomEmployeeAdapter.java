package com.example.abc.practice6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomEmployeeAdapter extends BaseAdapter {
    DbHelper dbhelper;

    Context context;
    ArrayList<Employee>  employeedetail;
    public  CustomEmployeeAdapter(Context context,ArrayList<Employee> employeedetail)
    {
        this.context = context;
        this.employeedetail = employeedetail;


    }

    private static class ViewHolder {

        public final LinearLayout rootView;
        public final TextView txtId;
        public final TextView txtName;
        public final TextView txtSalary;
        public final Button btnEdit;
        public final Button btnDelete;

        private ViewHolder(LinearLayout rootView, TextView txtId,TextView txtName, TextView txtSalary,Button btnEdit,Button btnDelete) {
            this.rootView = rootView;
            this.txtId = txtId;
            this.txtName = txtName;
            this.txtSalary = txtSalary;
            this.btnEdit = btnEdit;
            this.btnDelete = btnDelete;
        }

        public static ViewHolder create(LinearLayout rootView) {


            TextView txtId = (TextView)rootView.findViewById(R.id.txtId);
            TextView txtName = (TextView)rootView.findViewById( R.id.txtName );
            TextView txtSalary = (TextView)rootView.findViewById( R.id.txtSalary );
            Button btnEdit = (Button)rootView.findViewById(R.id.btnEdit);
            Button btnDelete = (Button)rootView.findViewById(R.id.btnDelete);
            return new ViewHolder( rootView,txtId, txtName, txtSalary,btnEdit,btnDelete );
        }
    }
    @Override
    public int getCount() {
        return employeedetail.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private LayoutInflater mInflater;
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final CustomEmployeeAdapter.ViewHolder vh;
        if ( convertView == null ) {
            View view = mInflater.inflate( R.layout.listitem_employee, parent, false );
            vh = ViewHolder.create( (LinearLayout)view );
            view.setTag( vh );
        } else {
            vh = (ViewHolder)convertView.getTag();
        }

        Object item = getItem( position );

        // TODOBind your data to the views here
        vh.txtId.setText(employeedetail.get(position).getId().toString());
        vh.txtName.setText(employeedetail.get(position).getName().toString());
        vh.txtSalary.setText(employeedetail.get(position).getSalary().toString());

       vh.btnEdit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String id = employeedetail.get(position).getId().toString();
                String Name = employeedetail.get(position).getName().toString();
                String Salary = employeedetail.get(position).getSalary().toString();
               Intent in = new Intent(context,UpdateActivity.class);
               in.putExtra("id",id);
               in.putExtra("Name",Name);
               in.putExtra("Salary",Salary);
               context.startActivity(in);
           }
       });
       vh.btnDelete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


               String id = employeedetail.get(position).getId().toString();

               Intent in = new Intent(context,DeleteActivity.class);
               in.putExtra("id",id);
               context.startActivity(in);

           }
       });

        return vh.rootView;
    }

}


