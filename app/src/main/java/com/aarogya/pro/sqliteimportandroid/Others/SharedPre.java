package com.aarogya.pro.sqliteimportandroid.Others;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPre {
    public static final String UserName="Uname";
    public static final String Password="Pass";
    public static final String AppName="AppName";
    SharedPreferences preferences;
    Context context;
    SharedPreferences.Editor  editor;
    public SharedPre(Context context){
        this.context=context;
        this.preferences=context.getSharedPreferences(AppName,Context.MODE_PRIVATE);
        this.editor=preferences.edit();
    }
    public void Putdata(String userName,String password){
        editor.putString(UserName,userName);
        editor.putString(Password,password);
        editor.commit();
    }
    public String getUserName(){
        return preferences.getString(UserName,"");
    }
    public String getPassword(){
        return preferences.getString(Password,"");
    }

}
