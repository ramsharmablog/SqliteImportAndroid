package com.aarogya.pro.sqliteimportandroid.AdapterS;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseAdapter extends SQLiteOpenHelper {

    public DataBaseAdapter(Context context) {
        super(context, "data", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE  if not exists Mydata(id INTEGER PRIMARY KEY ,name TEXT,pass TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      sqLiteDatabase.execSQL("DROP TABLE IF EXISTS RDPSDATA");
      onCreate(sqLiteDatabase);
    }
}
