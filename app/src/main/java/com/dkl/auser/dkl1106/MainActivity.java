package com.dkl.auser.dkl1106;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {

    private InputStream is;
    private FileOutputStream os;
    private String DB_File;
    private SQLiteDatabase sb;
    private String DB_FILE;
    private File f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DB_File = getFilesDir()+ File.separator+"test.sqlite";
//        is= getResources().openRawResource(R.raw.test);
//        try {
//            os = new FileOutputStream(DB_File);
//            int read;
//            while((read = is.read())!=-1){os.write(read);}
//            os.close();
//            is.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//    public void onClick(View v)
//    {
//        SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_File, null, SQLiteDatabase.OPEN_READWRITE);
//        Cursor c = db.rawQuery("Select * from tel", null);
//        c.moveToFirst();
//        Log.d("DATA", c.getString(1) + "," + c.getString(2));
////public  void onClick(View view){
////    sb =SQLiteDatabase.openDatabase(DB_File,null,SQLiteDatabase.OPEN_READWRITE);
////    Cursor c = sb.rawQuery("Select*from name",null);
////    c.moveToFirst();
////Log.d("Data",c.getString(1)+","+c.getString(2));
//
//
//}
//
//}
        f = new File(DB_FILE);
        if(! f.exists()) {
            DB_FILE = getFilesDir() + File.separator + "mydata.sqlite";
            try {
                InputStream is = getResources().openRawResource(R.raw.mydata);
                OutputStream os = new FileOutputStream(DB_FILE);
                int read;
                while ((read = is.read()) != -1) {
                    os.write(read);
                }
                os.close();
                is.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public void onClick(View v)
    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_FILE, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor c = db.rawQuery("Select * from phone", null);
        if (c.moveToFirst())
        {
            do {
                Log.d("DATA", c.getString(1) + "," + c.getString(2));
            } while (c.moveToNext());
        }
    }
}
