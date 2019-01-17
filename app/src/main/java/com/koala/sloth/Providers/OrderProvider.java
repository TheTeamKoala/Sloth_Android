package com.koala.sloth.Providers;

import android.app.Activity;
import android.support.v4.content.ContextCompat;

import com.koala.sloth.R;
import com.koala.sloth.TabOrder.ListView_Item;

import java.util.ArrayList;

public class OrderProvider {

    public static ArrayList<ListView_Item>getOrder(Activity activity) {
        ArrayList<ListView_Item> arrayList_item = new ArrayList<>();

        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.coctail), "İçecek"));
        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.coctail), "Meyve"));
        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.coctail), "Sebze"));
        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.coctail), "Temizlik"));
        arrayList_item.add(new ListView_Item(ContextCompat.getDrawable(activity, R.drawable.coctail), "Kuruyemiş"));

        return arrayList_item;
    }

}
