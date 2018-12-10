package com.example.abc.practice6;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

        private  static String CREATE_TABLE1;
        static String DATABASE_NAME = "EmployeeRecords";
    static String TABLE1_NAME = "employee";

    public static String ID = "id";
    public static String Name = "name";
    public static String Salary = "salary";

    ContentValues cValues;
    SQLiteDatabase database = null;
    Cursor cursor;

    public  DbHelper(Context context)
    {
        super(context,context.getExternalFilesDir(null).getAbsolutePath()+"/"+ DATABASE_NAME,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        CREATE_TABLE1 =  " CREATE TABLE " + TABLE1_NAME + "(" + ID + " INTEGER PRIMARY KEY autoincrement," + Name + " TEXT, " + Salary +" TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE1);
        System.out.println("Table is Created....................");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertRecord_employee(String name,String salary)
    {
        database = getWritableDatabase();
        cValues = new ContentValues();
        cValues.put(Name,name);
        cValues.put(Salary,salary);
        database.insert(TABLE1_NAME,null,cValues);

      //  String ROW1 = "INSERT INTO " + TABLE1_NAME + "("+ Name + ", " + Salary +") Values ( " + name + " , " + salary + ");";
     //   String ROW2 = "INSERT INTO " + TABLE1_NAME + "(" + Name + " , " + Salary + ") Values ( " + name + " , " + Salary + " )";
     //   String ROW2;

       // database.execSQL(ROW1);
        database.close();
    }

    public Cursor selectRecord_employee()
        {
            database = getReadableDatabase();
            cursor = database.rawQuery("select * from "+ TABLE1_NAME,null);
            return cursor;
    }
    public void updateRecord(String id,String name, String salary) {

        database = getWritableDatabase();

        cValues = new ContentValues();

        cValues.put(Name, name);
        cValues.put(Salary, salary);
//    Update data from database table
        database.update(DbHelper.TABLE1_NAME, cValues,
                ID + "= ?", new String[]{String.valueOf(id)});
                database.close();
    }

    public void deleteRecord(String id) {

        database = getWritableDatabase();

//    Deleting all records from database table
        database.delete(TABLE1_NAME, ID + "=?", new String[]{String.valueOf(id)});

        database.close();
    }


}
