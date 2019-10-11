package com.aarogya.pro.sqliteimportandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.aarogya.pro.sqliteimportandroid.AdapterS.Mydatabase;
import com.aarogya.pro.sqliteimportandroid.Bean.ModelData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView lbl;
    Mydatabase controller = new Mydatabase(this);
    Button btnimport;
    ListView lv;
    final Context context = this;
  //  ListAdapter adapter;
    ArrayList<HashMap<String, String>> myList;
    ArrayList<RDPSDATA>modelDatas;
    public static final int requestcode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modelDatas=new ArrayList<>();
        lbl=findViewById(R.id.name);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               MyData();
               /*Intent fileintent = new Intent(Intent.ACTION_GET_CONTENT);
               fileintent.setType("gagt/sdf");
               try {
                startActivityForResult(fileintent, requestcode);
               } catch (ActivityNotFoundException e) {
                   lbl.setText("No activity can handle picking a file. Showing alternatives.");
               }*/
           }
       },1000);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               GetData();
           }
       },4000);

    }

 /*   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null)
            return;
        switch (requestCode) {
            case requestcode:
             //   String filepath = data.getData().getPath();
                String FilePath = Environment.getExternalStorageDirectory() +"/temp_picture/"+"indoretobhp.csv";

                controller = new Mydatabase(getApplicationContext());
                SQLiteDatabase db = controller.getWritableDatabase();
                String tableName = "RDPSDATA";
                db.execSQL("delete from " + tableName);
                try {
                    if (resultCode == RESULT_OK) {
                        try {

                            FileReader file = new FileReader(FilePath);
                            BufferedReader buffer = new BufferedReader(file);
                            ContentValues contentValues = new ContentValues();
                            String line = "";
                            db.beginTransaction();
                            while ((line = buffer.readLine()) != null) {
                            String[] str = line.split(",", 6);  // defining 3 columns with null or blank field //values acceptance
                                //Id, Company,Name,Price
                                String KM = str[0].toString();
                                String DIS = str[1].toString();
                                String LAT = str[2].toString();
                                String LONG = str[3].toString();
                                String POINT = str[4].toString();
                                String FCODE = str[5].toString();

                                contentValues.put("KM", KM);
                                contentValues.put("DIS", DIS);
                                contentValues.put("LAT", LAT);
                                contentValues.put("LONG", LONG);
                                contentValues.put("POINT", POINT);
                                contentValues.put("FCODE", FCODE);

                                db.insert(tableName, null, contentValues);
                                lbl.setText("Successfully Updated Database.");
                            }
                            db.setTransactionSuccessful();
                            db.endTransaction();
                        } catch (IOException e) {
                            if (db.inTransaction())
                                db.endTransaction();
                            Dialog d = new Dialog(this);
                            d.setTitle(e.getMessage().toString() + "first");
                            d.show();
                            // db.endTransaction();
                        }
                    } else {
                        if (db.inTransaction())
                            db.endTransaction();
                        Dialog d = new Dialog(this);
                        d.setTitle("Only CSV files allowed");
                        d.show();
                    }
                } catch (Exception ex) {
                    if (db.inTransaction())
                        db.endTransaction();

                    Dialog d = new Dialog(this);
                    d.setTitle(ex.getMessage().toString() + "second");
                    d.show();
                    // db.endTransaction();
                }
        }
      *//*  myList = controller.getAllProducts();

        if (myList.size() != 0) {
            ListView lv = getListView();
            ListAdapter adapter = new SimpleAdapter(MainActivity.this, myList,
                    R.layout.v, new String[]{"Company", "Name", "Price"}, new int[]{
                    R.id.txtproductcompany, R.id.txtproductname, R.id.txtproductprice});
            setListAdapter(adapter);
            lbl.setText("Data Imported");
        }*//*
    }*/
    public void MyData(){
        String FilePath = Environment.getExternalStorageDirectory() +"/temp_picture/"+"BSNL.csv";
        controller = new Mydatabase(getApplicationContext());
        SQLiteDatabase db = controller.getWritableDatabase();
        String tableName = "RDPSDATA";
        db.execSQL("delete from " + tableName);
        try {
             try {
                  FileReader file = new FileReader(FilePath);
                    BufferedReader buffer = new BufferedReader(file);
                    ContentValues contentValues = new ContentValues();
                   // String line = "";
                    int lineNumber=0;
                   String previousLine = null;
                    db.beginTransaction();
                   while ((previousLine = buffer.readLine()) != null) {
                     String[] CompliteLine = previousLine.split(",");
                     if (++lineNumber < 20)
                         continue;
                       if (CompliteLine != null && CompliteLine.length > 5) {
                           /* while ((line = buffer.readLine()) != null) {*/
                           //    String[] str = line.split(",", 6);  // defining 3 columns with null or blank field //values acceptance
                           //Id, Company,Name,Price
                           String KM = CompliteLine[0];
                           String DIS = CompliteLine[1];
                           String LAT = CompliteLine[2];
                           String LONG = CompliteLine[3];
                           String POINT = CompliteLine[4];
                           String FCODE = CompliteLine[5];
                           contentValues.put("KM", KM);
                           contentValues.put("DIS", DIS);
                           contentValues.put("LAT", LAT);
                           contentValues.put("LONG", LONG);
                           contentValues.put("POINT", POINT);
                           contentValues.put("FCODE", FCODE);
                           db.insertWithOnConflict(tableName, null, contentValues,SQLiteDatabase.CONFLICT_REPLACE);
                        //    retvalue = Mydatabase.db.insertWithOnConflict(table, null, values, CONFLICT_REPLACE);
                           lbl.setText("Successfully Updated Database.");
                       }
                    }
                    db.setTransactionSuccessful();
                    db.endTransaction();
                } catch (IOException e) {
                    if (db.inTransaction())
                        db.endTransaction();
                    Dialog d = new Dialog(this);
                    d.setTitle(e.getMessage().toString() + "first");
                    d.show();
                    // db.endTransaction();
                }

        } catch (Exception ex) {
            if (db.inTransaction())
                db.endTransaction();

            Dialog d = new Dialog(this);
            d.setTitle(ex.getMessage().toString() + "second");
            d.show();
            // db.endTransaction();
        }
    }
    public void GetData(){
        modelDatas= controller.getAllRDPSDATA("566");
     //   rdpsdata= mydatabase.getAllRDPSDATA(fakeData.km_post);
         for (int i=0;i<modelDatas.size();i++)
        {
        //    HashMap<String, String> hashmap= myList.get(i);
             String string= modelDatas.get(i).getEvent();
             String stringd= String.valueOf(modelDatas.get(i).getLongitude());
             String stringdd= String.valueOf(modelDatas.get(i).getExtrapoint());
            String string1= modelDatas.get(i).getDistance();
            String string2= String.valueOf(modelDatas.get(i).getLatitude());
            String string3= modelDatas.get(i).getKilometer();
            Log.e("stringstring",""+string);
        }

         /* ListView lv = getListView();
          ListAdapter adapter = new SimpleAdapter(MainActivity.this, myList,
                  R.layout.v, new String[]{"Company", "Name", "Price"}, new int[]{
                  R.id.txtproductcompany, R.id.txtproductname, R.id.txtproductprice});
          setListAdapter(adapter);
          lbl.setText("");*/
        }
    }




