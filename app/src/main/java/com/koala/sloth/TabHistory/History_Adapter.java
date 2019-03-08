package com.koala.sloth.TabHistory;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.koala.sloth.Database.Dao.OrdersDao;
import com.koala.sloth.Database.Dao.Item.Order;
import com.koala.sloth.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

class History_Adapter extends BaseAdapter {
    private final LayoutInflater inflater;

    private final ArrayList<Order> itemList;



    History_Adapter(Activity activityP) {
        inflater = (LayoutInflater) activityP.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        itemList = new OrdersDao(activityP.getApplicationContext()).getOrderList();
    }

    public Order getItem(int position) {
        return itemList.get(position);
    }
    @SuppressLint("InflateParams")
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;
        if (convertView!=null)
            satirView = convertView;
        else
            satirView = inflater.inflate(R.layout.activity_history_row, null);

        Order historyItem = itemList.get(position);

        TextView textView_name = satirView.findViewById(R.id.textView_name);
        textView_name.setText(historyItem.getProduct().getName());

        TextView textView_price = satirView.findViewById(R.id.textView_price);
        textView_price.setText(String.valueOf(historyItem.getProduct().getPrice() +" "+ historyItem.getProduct().getPriceUnit() +"/"+ historyItem.getProduct().getPhysicalUnit()));

        TextView textView_quantity = satirView.findViewById(R.id.textView_quantity);
        textView_quantity.setText(String.valueOf(historyItem.getQuantity()));

        TextView textView_totalPrice = satirView.findViewById(R.id.textView_totalPrice);
        textView_totalPrice.setText(String.valueOf(historyItem.getProduct().getPrice()*historyItem.getQuantity() +" "+ historyItem.getProduct().getPriceUnit()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss dd:MM:yyyy", Locale.getDefault());
        TextView textView_date = satirView.findViewById(R.id.textView_date);
        textView_date.setText(simpleDateFormat.format(historyItem.getDate()));

        return satirView;
    }
    public long getItemId(int position) {
        return position;
    }
    public int getCount() {
        return itemList.size();
    }

}
