package com.aarogya.pro.sqliteimportandroid.AdapterS;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aarogya.pro.sqliteimportandroid.Bean.ModelData;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterRecyclerview extends RecyclerView.Adapter<CustomAdapterRecyclerview.MyHandler>{
  Context context;
  List<ModelData>modelData=new ArrayList<>();

   public CustomAdapterRecyclerview(Context context,List<ModelData>data){
      this.context=context;
      this.modelData=data;
   }

    public class MyHandler extends RecyclerView.ViewHolder {
        public MyHandler(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public CustomAdapterRecyclerview.MyHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterRecyclerview.MyHandler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return modelData.size();
    }


}
