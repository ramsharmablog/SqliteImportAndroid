package com.aarogya.pro.sqliteimportandroid.AdapterS;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aarogya.pro.sqliteimportandroid.RDPSDATA;

import java.util.ArrayList;


public class Mydatabase extends SQLiteOpenHelper {

    public Mydatabase(Context context ) {
        super(context, "IMPORTCSV", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
   //  String query = "CREATE TABLE IF NOT EXISTS RDPSDATA(Id INTEGER PRIMARY KEY, KM VARCHAR,DIS VARCHAR,LAT DOUBLE,LONG DOUBLE,POINT VARCHAR,FCODE VARCHAR)";
   String query = "CREATE TABLE IF NOT EXISTS RDPSDATA (Id INTEGER PRIMARY KEY,KM VARCHAR,DIS VARCHAR,LAT DOUBLE,LONG DOUBLE,POINT VARCHAR,FCODE VARCHAR);";
        sqLiteDatabase.execSQL(query);
     }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query;
        query = "DROP TABLE IF EXISTS RDPSDATA";
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }
    public ArrayList<RDPSDATA> getAllRDPSDATA(String K)
    {
        ArrayList<RDPSDATA> machineNoArr=new ArrayList<>();
        SQLiteDatabase db =this.getWritableDatabase();
        String selectQuery = "SELECT * FROM RDPSDATA where KM="+K;
        Cursor cur = db.rawQuery(selectQuery, null);
        while( cur.moveToNext() )
        {
            machineNoArr.add(new RDPSDATA(cur.getDouble(3),cur.getDouble(4),cur.getString(6),cur.getString(2),cur.getString(1),cur.getString(5))) ;
            //machineNoArr.add(new RDPSDATA() ;
            //    rdpsdata.add(new RDPSDATA(Double.parseDouble(CompliteLine[2]),Double.parseDouble(CompliteLine[3]),CompliteLine[5],CompliteLine[1],CompliteLine[0],""));
        }
        cur.close();
        db.close();
        return  machineNoArr;
    }
/*    public ArrayList<HashMap<String, String>> getAllRDPSDATA(String km) {
        ArrayList<HashMap<String, String>> proList;
        proList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT * FROM RDPSDATA where KM ="+km;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                //Id, Company,Name,Price
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("Id", cursor.getString(0));
                map.put("KM", cursor.getString(1));
                map.put("DIS", cursor.getString(2));
                map.put("LAT", cursor.getString(3));
                map.put("LONG", cursor.getString(4));
                map.put("POINT", cursor.getString(5));
                map.put("FCODE", cursor.getString(6));
                proList.add(map);
            } while (cursor.moveToNext());
        }

        return proList;
    }*/
}
