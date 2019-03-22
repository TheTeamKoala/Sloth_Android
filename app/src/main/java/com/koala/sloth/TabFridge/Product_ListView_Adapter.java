package com.koala.sloth.TabFridge;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.koala.sloth.Database.Dao.Item.Product;
import com.koala.sloth.R;
import com.koala.sloth.Shared.Constant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

class Product_ListView_Adapter extends BaseAdapter {
    private final Activity activity;
    private final LayoutInflater inflater;
    private final SharedPreferences sharedPreferences;

    private final ArrayList<Product> itemList_first;
    private final ArrayList<Product> itemList_second;



    Product_ListView_Adapter(Activity activityP, ArrayList<Product> itemListP) {
        activity = activityP;
        inflater = (LayoutInflater) activityP.getSystemService(LAYOUT_INFLATER_SERVICE);
        sharedPreferences = activity.getApplicationContext().getSharedPreferences("settings", 0);

        itemList_first = new ArrayList<>();
        itemList_second= new ArrayList<>();

        for (int i = 0; i< itemListP.size(); i++) {
            if (i%2 == 0)
                itemList_first.add(itemListP.get(i));
            else
                itemList_second.add(itemListP.get(i));
        }
    }

    public Product getItem(int position) {
        return itemList_first.get(position);
    }
    @SuppressLint("InflateParams")
    public View getView(final int position, View convertView, ViewGroup parent) {
        View satirView;
        if (convertView!=null && ((TextView)convertView.findViewById(R.id.textView_name1)).getText().toString().equals(itemList_first.get(position).getName()))
            satirView = convertView;
        else
            satirView = inflater.inflate(R.layout.activity_order_product_row, null);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss", Locale.getDefault());

        final Product first_item= itemList_first.get(position);

        TextView textView_name1 = satirView.findViewById(R.id.textView_name1);
        textView_name1.setText(first_item.getName());

        ImageView imageView_picture1 = satirView.findViewById(R.id.imageView_picture1);
        imageView_picture1.setImageBitmap(first_item.getPicture());
        imageView_picture1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String name = itemList_first.get(position).getName();
                String controlProducts = sharedPreferences.getString("controlProducts", "");

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("controlProducts", controlProducts + name +"%");
                editor.apply();

                Toast.makeText(activity, name +" is added to the controller list!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        TextView textView_pricePerUnit1 = satirView.findViewById(R.id.textView_pricePerUnit1);
        textView_pricePerUnit1.setText(simpleDateFormat.format(first_item.getFirstDate()));


        TextView textView_name2 = satirView.findViewById(R.id.textView_name2);
        ImageView imageView_picture2 = satirView.findViewById(R.id.imageView_picture2);
        TextView textView_pricePerUnit2 = satirView.findViewById(R.id.textView_pricePerUnit2);
        if (position < itemList_second.size()) {
            final Product second_item= itemList_second.get(position);

            textView_name2.setText(second_item.getName());
            textView_pricePerUnit2.setText(simpleDateFormat.format(second_item.getFirstDate()));
            imageView_picture2.setImageBitmap(second_item.getPicture());
            imageView_picture2.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String name = itemList_second.get(position).getName();
                    String controlProducts = sharedPreferences.getString("controlProducts", "");

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("controlProducts", controlProducts + name +"%");
                    editor.apply();

                    Toast.makeText(activity, name +" is added to the controller list!", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
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
