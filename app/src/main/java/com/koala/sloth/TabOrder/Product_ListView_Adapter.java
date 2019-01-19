package com.koala.sloth.TabOrder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.koala.sloth.R;

import java.util.ArrayList;

class Product_ListView_Adapter extends BaseAdapter {
    private final Activity activity;
    private final LayoutInflater inflater;

    private ArrayList<Product_ListView_Item> itemList_first;
    private ArrayList<Product_ListView_Item> itemList_second;



    Product_ListView_Adapter(Activity activityP, ArrayList<Product_ListView_Item> itemListP) {
        activity = activityP;
        inflater = (LayoutInflater) activityP.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        itemList_first = new ArrayList<>();
        itemList_second= new ArrayList<>();

        for (int i = 0; i< itemListP.size(); i++) {
            if (i%2 == 0)
                itemList_first.add(itemListP.get(i));
            else
                itemList_second.add(itemListP.get(i));
        }
    }

    public Product_ListView_Item getItem(int position) {
        return itemList_first.get(position);
    }
    @SuppressLint("InflateParams")
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;
        if (convertView!=null && ((TextView)convertView.findViewById(R.id.textView_name1)).getText().toString().equals(itemList_first.get(position).getName()))
            satirView = convertView;
        else
            satirView = inflater.inflate(R.layout.activity_order_product_row, null);


        Product_ListView_Item first_item= itemList_first.get(position);

        TextView textView_name1 = satirView.findViewById(R.id.textView_name1);
        textView_name1.setText(first_item.getName());

        ImageView imageView_picture1 = satirView.findViewById(R.id.imageView_picture1);
        imageView_picture1.setImageDrawable(first_item.getPicture());

        TextView textView_pricePerUnit1 = satirView.findViewById(R.id.textView_pricePerUnit1);
        textView_pricePerUnit1.setText(String.valueOf(first_item.getPrice() +" "+ first_item.priceUnitP()  +"/"+ first_item.getPhysicalUnit()));


        TextView textView_name2 = satirView.findViewById(R.id.textView_name2);
        ImageView imageView_picture2 = satirView.findViewById(R.id.imageView_picture2);
        TextView textView_pricePerUnit2 = satirView.findViewById(R.id.textView_pricePerUnit2);
        if (position < itemList_second.size()) {
            Product_ListView_Item second_item= itemList_second.get(position);

            textView_name2.setText(second_item.getName());
            imageView_picture2.setImageDrawable(second_item.getPicture());
            textView_pricePerUnit2.setText(String.valueOf(second_item.getPrice() +" "+ second_item.priceUnitP() +"/"+ second_item.getPhysicalUnit()));
        }
        else {
            textView_name2.setVisibility(View.INVISIBLE);
            imageView_picture2.setVisibility(View.INVISIBLE);
        }


        Display display = activity.getWindowManager().getDefaultDisplay();
        Point temp = new Point();
        display.getSize(temp);

        imageView_picture1.setLayoutParams(new FrameLayout.LayoutParams(temp.x/2, temp.x/3));
        imageView_picture2.setLayoutParams(new FrameLayout.LayoutParams(temp.x/2, temp.x/3));

        return satirView;
    }
    public long getItemId(int position) {
        return position;
    }
    public int getCount() {
        return itemList_first.size();
    }

}
