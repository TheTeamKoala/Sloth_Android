package com.koala.sloth.Providers;
import android.app.Activity;
import android.support.v4.content.ContextCompat;

import com.koala.sloth.R;
import com.koala.sloth.Shared.Constant;
import com.koala.sloth.TabOrder.FridgeCategory_Item;

import java.util.ArrayList;

public class FridgeProvider {
    public static ArrayList<FridgeCategory_Item> getFridgeCategories(Activity activity) {
        ArrayList<FridgeCategory_Item> arrayList_item = new ArrayList<>();

        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.fruit), Constant.ORDER_CATEGORY_FRUIT));
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.vegetable), Constant.ORDER_CATEGORY_VEGETABLE));
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.meat), Constant.ORDER_CATEGORY_MEAT));
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.drink), Constant.ORDER_CATEGORY_DRINK));
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.nut), Constant.ORDER_CATEGORY_NUT));
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.spice), Constant.ORDER_CATEGORY_SPICE));
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.junk_food), Constant.ORDER_CATEGORY_JUNK_FOOD));
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.cleaning), Constant.ORDER_CATEGORY_CLEANING));

        return arrayList_item;
    }



}
