package com.koala.sloth.Providers;
import android.app.Activity;
import android.support.v4.content.ContextCompat;

import com.koala.sloth.R;
import com.koala.sloth.TabFridge.FridgeCategory_Item;

import java.util.ArrayList;

public class FridgeProvider {
    public static ArrayList<FridgeCategory_Item> getFridgeCategories(Activity activity) {
        ArrayList<FridgeCategory_Item> arrayList_item = new ArrayList<>();

        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.apple), "Apple"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(5);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.orange), "Orange"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(12);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.banana), "Banana"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(4);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.kiwi), "Kiwi"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(0);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.tomato), "Tomato"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(3);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.cucumber), "Cucumber"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(2);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.potato), "Potato"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(4);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.carrot), "Carrot"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(2);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.pepper), "Pepper"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(1);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.tenderloin), "Tenderloin"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(4);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.entrecote), "Entrecote"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(1);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.pinar_salami), "Pinar Salami"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(0);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.pinar_sausage), "Pinar Sausage"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(9);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.namet_salami), "Namet Salami"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(12);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.namet_sausage), "Namet Sausage"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(5);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.pepsi_cola), "Pepsi Cola"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(0);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.fanta), "Fanta"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(1);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.soda), "Soda"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(1);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.sprite), "Sprite"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(1);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.sek_juice), "Sek Juice"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(1);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.cappy_juice), "Cappy Juice"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(1);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.hazelnut), "Hazelnut"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(1);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.peanut), "Peanut"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(2);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.walnut), "Walnut"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(2);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.red_pepper_flakes), "Rep Pepper Flakes"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(2);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.coconut), "Coconut"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(4);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.thyme), "Thyme"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(3);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.mint), "Mint"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(0);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.hanimeller), "Hanımeller"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(0);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.ruffles), "Ruffles"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(0);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.rocco), "Rocco"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(1);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.canga), "Canga"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(1);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.toblerone), "Toblerone"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(3);
        arrayList_item.add(new FridgeCategory_Item(ContextCompat.getDrawable(activity, R.drawable.toffie), "Toffie"));
        arrayList_item.get(arrayList_item.size()-1).setNumber(5);








        return arrayList_item;
    }



}
