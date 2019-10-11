package com.aarogya.pro.sqliteimportandroid;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DemoActviituy extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    swp();swpwtv();
        prime();
        //fact();
       // fib();
      //  reverse();
      //  strrecerse();
    }

    private void strrecerse() {
        String name="vikasyadav";
        byte namee[]=name.getBytes();
        byte namenew[]=new byte[namee.length];
        for (int i=0;i<namee.length;i++){
            namenew[i]=namee[namee.length-i-1];
        }
        Log.e("strrecerse","strrecerse"+new String(namenew));
    }

    private void reverse() {
        int a=123456 ,rev = 0,rem=0;
        while (a!=0){
         rem=a%10;
         rev=rev*10+rem;
         a=a/10;
        }
        Log.e("reverse",""+rev);
    }

    private void fib() {
        int f=0,sec=1,sum=0;
        for(int i=0;i<=10;i++){
            if (i<=1){
                sum=i;
            }else {
                sum=f+sec;
                f=sec;
                sec=sum;
            }
            Log.e("sumsumsum","sum"+sum+"f"+f+"sec+"+sec);
        }
    }

    private void fact() {
       int fact=1;
        for (int i=1;i<=4;i++){
            fact*=i;
        }
        Log.e("<<<<<<<<",""+fact);
    }

    private void prime() {
        int count =0;
        for (int i=0;i<=10;i++){
            count=0;
         for (int j=i;j>=1;j--){
             if (i%j==0){
               count=count+1;
           }
        }
         if (count==2){
             Log.e("???????"+count,"iiiii"+i);
         }

         }
    }

    private void swpwtv() {
        int a=10,b=20;
        a=a+b;
        b=a-b;
        a=a-b;
        Log.e("swpwtvswpwtv","sum"+a+">>>>>>b"+b);
    }

    private void swp() {
        int a=10,b=20,c=0;
        c=a;
        a=b;
        b=c;
        Log.e("swpswp","sum"+a+">>>>>>b"+b);
    }
}
