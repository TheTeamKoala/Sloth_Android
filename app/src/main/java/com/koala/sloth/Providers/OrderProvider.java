package com.koala.sloth.Providers;

import android.app.Activity;
import android.support.v4.content.ContextCompat;

import com.koala.sloth.R;
import com.koala.sloth.TabOrder.ListView_Item;

import java.util.ArrayList;

public class OrderProvider {

    public static ArrayList<ListView_Item>getOrder(Activity activity) {
        ArrayList<ListView_Item> arrayList_item = new ArrayList<>();

        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.fruit), "Fruit"));
        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.vegetable), "Vegetable"));
        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.meat), "Meat"));
        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.drink), "Drink"));
        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.nuts), "Nut"));
        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.spice), "Spice"));
        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.junk_food), "Junk Food"));
        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.cleaning), "Cleaning"));

        return arrayList_item;
    }

}
