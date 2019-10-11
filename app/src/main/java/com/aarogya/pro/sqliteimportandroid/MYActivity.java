package com.aarogya.pro.sqliteimportandroid;

import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.aarogya.pro.sqliteimportandroid.Fragmnet.FragmentOne;
import com.aarogya.pro.sqliteimportandroid.Fragmnet.FragmentTwo;

public class MYActivity extends AppCompatActivity {
    Button view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

}}
