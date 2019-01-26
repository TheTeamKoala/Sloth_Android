package com.koala.sloth.TabFridge;


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
import com.koala.sloth.TabFridge.FridgeCategory_Item;

import java.util.ArrayList;
class FridgeCategory_Adapter extends BaseAdapter  {
    private final Activity activity;
    private final LayoutInflater inflater;

    private final ArrayList<FridgeCategory_Item> itemList_first;
    private final ArrayList<FridgeCategory_Item> itemList_second;

    FridgeCategory_Adapter(Activity activityP, ArrayList<FridgeCategory_Item> itemListP) {
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

    public int getCount() {
        return itemList_first.size();
    }

    public Object getItem(int position) {
        return itemList_first.get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    @SuppressLint("InflateParams")
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;
        if (convertView!=null && ((TextView)convertView.findViewById(R.id.textView_name1)).getText().toString().equals(itemList_first.get(position).getName()))
            satirView = convertView;
        else
            satirView = inflater.inflate(R.layout.activity_fridge_category_row, null);

        final TextView textView_name1 = satirView.findViewById(R.id.textView_name1);
        textView_name1.setText(String.valueOf(itemList_first.get(position).getName() + " / " + itemList_first.get(position).getNumber()));

        ImageView imageView_picture1 = satirView.findViewById(R.id.imageView_picture1);
        imageView_picture1.setImageDrawable(itemList_first.get(position).getPicture());

        final TextView textView_name2 = satirView.findViewById(R.id.textView_name2);
        ImageView imageView_picture2 = satirView.findViewById(R.id.imageView_picture2);
        if (position < itemList_second.size()) {
            textView_name2.setText(String.valueOf(itemList_second.get(position).getName() + " / " + itemList_second.get(position).getNumber()));
            imageView_picture2.setImageDrawable(itemList_second.get(position).getPicture());
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
}
