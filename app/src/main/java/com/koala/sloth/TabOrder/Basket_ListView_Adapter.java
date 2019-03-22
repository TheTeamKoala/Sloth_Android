package com.koala.sloth.TabOrder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.koala.sloth.Database.Dao.Item.Product;
import com.koala.sloth.R;
import com.koala.sloth.Shared.Constant;
import com.koala.sloth.Shared.Methods;

import java.util.ArrayList;

class Basket_ListView_Adapter extends BaseAdapter {
    private final Activity activity;
    private final LayoutInflater inflater;

    private final ArrayList<Product> itemList;



    Basket_ListView_Adapter(Activity activityP) {
        activity = activityP;
        inflater = (LayoutInflater) activityP.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemList = Constant.basket;
    }

    public Product getItem(int position) {
        return itemList.get(position);
    }
    @SuppressLint("InflateParams")
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;
        if (convertView!=null)
            satirView = convertView;
        else
            satirView = inflater.inflate(R.layout.dialog_basket_row, null);

        if (position==0) {
            ImageView imageView_picture = satirView.findViewById(R.id.imageView_picture);
            imageView_picture.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.basket_all));

            Spannable spannableString;

            TextView textView_name = satirView.findViewById(R.id.textView_name);
            spannableString = new SpannableString("Total Item number: " + Constant.basket.size());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 0, 18, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView_name.setText(spannableString);

            TextView textView_number = satirView.findViewById(R.id.textView_number);
            spannableString = new SpannableString("Total Quantity: " + Methods.getTotalQuantity());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView_number.setText(spannableString);

            TextView textView_totalPrice = satirView.findViewById(R.id.textView_totalPrice);
            spannableString = new SpannableString("Total Price: " + Methods.getTotalPrice());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView_totalPrice.setText(spannableString);

            TextView textView_pricePerUnit = satirView.findViewById(R.id.textView_pricePerUnit);
            textView_pricePerUnit.setVisibility(View.GONE);

            Button button_remove = satirView.findViewById(R.id.button_remove);
            button_remove.setVisibility(View.INVISIBLE);

            return satirView;
        }


        final Product item = itemList.get(position-1);

        ImageView imageView_picture = satirView.findViewById(R.id.imageView_picture);
        imageView_picture.setImageBitmap(item.getPicture());

        Spannable spannableString;

        TextView textView_name = satirView.findViewById(R.id.textView_name);
        spannableString = new SpannableString("Name: "+item.getName());
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView_name.setText(spannableString);

        TextView textView_pricePerUnit = satirView.findViewById(R.id.textView_pricePerUnit);
        spannableString = new SpannableString("Price: "+item.getTotalPricePerUnit());
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView_pricePerUnit.setText(spannableString);

        TextView textView_number = satirView.findViewById(R.id.textView_number);
        spannableString = new SpannableString("Quantity: "+item.getQuantity());
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView_number.setText(spannableString);

        TextView textView_totalPrice = satirView.findViewById(R.id.textView_totalPrice);
        spannableString = new SpannableString("Total Price: "+item.getTotalPriceString());
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 0, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView_totalPrice.setText(spannableString);


        final BaseAdapter basketListViewAdapter = this;
        Button button_remove = satirView.findViewById(R.id.button_remove);
        button_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Methods.removeItemToBasket(item.getName());
                basketListViewAdapter.notifyDataSetChanged();
            }
        });

        return satirView;
    }
    public long getItemId(int position) {
        return position;
    }
    public int getCount() {
        return itemList.size()+1;
    }

}
