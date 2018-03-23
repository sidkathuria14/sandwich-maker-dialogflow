package com.example.sidkathuria14.sandwich;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sidkathuria14.sandwich.models.StringWithBinary;

import java.util.ArrayList;

/**
 * Created by sidkathuria14 on 23/3/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
ArrayList<StringWithBinary> arrayList;
Context context;

    public MyAdapter(ArrayList<StringWithBinary> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutType;
        if(viewType == 0){
            layoutType = R.layout.item_view_left;
        }else{
            layoutType = R.layout.item_view_right;
        }
//        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(layoutType
                ,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {
        StringWithBinary thisStringWithBinary = arrayList.get(position);
        if (thisStringWithBinary.getBinary() == 0){
            return 0;
        }
        return 1;
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
StringWithBinary thisString = arrayList.get(position);
holder.tvText.setText(thisString.gettext());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
TextView tvText;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvText = (TextView)itemView.findViewById(R.id.tvText);
        }
    }
}
