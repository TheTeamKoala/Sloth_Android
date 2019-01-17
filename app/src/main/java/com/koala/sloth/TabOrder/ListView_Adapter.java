package com.koala.sloth.TabOrder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koala.sloth.R;

import java.util.ArrayList;

class ListView_Adapter extends BaseAdapter {
    private final LayoutInflater inflater;

    private ArrayList<ListView_Item> itemList;



    ListView_Adapter(Activity activityP, ArrayList<ListView_Item> itemListP) {
        inflater = (LayoutInflater) activityP.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemList = itemListP;
    }

    public ListView_Item getItem(int position) {
        return itemList.get(position);
    }
    @SuppressLint("InflateParams")
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;
        if (convertView!=null && ((TextView)convertView.findViewById(R.id.textView_name1)).getText().toString().equals(itemList.get(position).getName()))
            satirView = convertView;
        else
            satirView = inflater.inflate(R.layout.activity_order_row, null);

        TextView textView_name1 = satirView.findViewById(R.id.textView_name1);
        textView_name1.setText(itemList.get(position).getName());

        ImageView imageView_picture1 = satirView.findViewById(R.id.imageView_picture1);
        imageView_picture1.setImageDrawable(itemList.get(position).getPicture());

        return satirView;
    }
    public long getItemId(int position) {
        return position;
    }
    public int getCount() {
        return itemList.size();
    }

}
