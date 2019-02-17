package com.koala.sloth.Providers;

import android.app.Activity;
import android.support.v4.content.ContextCompat;

import com.koala.sloth.R;
import com.koala.sloth.Shared.Constant;
import com.koala.sloth.TabHistory.History_Item;
import com.koala.sloth.TabOrder.Category_ListView_Item;
import com.koala.sloth.TabOrder.Product_Item;

import java.util.ArrayList;
import java.util.Date;

public class HistoryProvider {

    public static ArrayList<History_Item>getHistory(Activity activity) {
        ArrayList<History_Item> arrayList_item = new ArrayList<>();

        arrayList_item.add(new History_Item("Domates", 5.0, "TL", "kg", 10, new Date()));
        arrayList_item.add(new History_Item("Salatalık", 4.0, "TL", "kg", 10, new Date()));
        arrayList_item.add(new History_Item("Ruffles", 2, "TL", "piece", 2, new Date()));
        arrayList_item.add(new History_Item("Karam", 1.5, "TL", "piece", 1, new Date()));
        arrayList_item.add(new History_Item("Canga", 2.5, "TL", "piece", 1, new Date()));

        return arrayList_item;
    }

}
