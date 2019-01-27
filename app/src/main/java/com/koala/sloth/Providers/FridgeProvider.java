package com.koala.sloth.Providers;
import android.app.Activity;
import android.support.v4.content.ContextCompat;

import com.koala.sloth.R;
import com.koala.sloth.TabFridge.FridgeCategory_Item;
import com.koala.sloth.TabOrder.Product_Item;

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

    public static ArrayList<Product_Item>getProducts(Activity activity) {
        ArrayList<Product_Item> arrayList_item = new ArrayList<>();


            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.apple), "Apple", 1.25, "tl", "kg"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.orange), "Orange", 1.50, "tl",  "kg"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.banana), "Banana", 1.75, "tl",  "kg"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.kiwi), "Kiwi", 2.0, "tl",  "kg"));

            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.tomato), "Tomato", 0.25, "tl",  "kg"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.cucumber), "Cucumber", 0.50, "tl",  "kg"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.potato), "Potato", 0.75, "tl",  "kg"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.carrot), "Carrot", 1.00, "tl",  "kg"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.pepper), "Pepper", 1.25, "tl",  "kg"));

            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.tenderloin), "Tenderloin", 35.50, "tl",  "kg"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.entrecote), "Entrecote", 55.50, "tl",  "kg"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.pinar_salami), "Pinar Salami", 3.25, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.pinar_sausage), "Pinar Sausage", 5.25, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.namet_salami), "Namet Salami", 3.75, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.namet_sausage), "Namet Sausage", 5.75, "tl",  "piece"));

            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.pepsi_cola), "Pepsi Cola", 2.25, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.fanta), "Fanta", 2.50, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.soda), "Soda", 0.75, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.sprite), "Sprite", 2.00, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.sek_juice), "Sek Juice", 2.25, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.cappy_juice), "Cappy Juice", 2.50, "tl",  "piece"));

            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.hazelnut), "Hazelnut", 15.25, "tl",  "kg"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.peanut), "Peanut", 16.50, "tl",  "kg"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.walnut), "Walnut", 17.75, "tl",  "kg"));

            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.red_pepper_flakes), "Rep Pepper Flakes", 4.25, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.coconut), "Coconut", 4.50, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.thyme), "Thyme", 3.75, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.mint), "Mint", 4.00, "tl",  "piece"));

            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.hanimeller), "Hanımeller", 1.25, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.ruffles), "Ruffles", 3.50, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.rocco), "Rocco", 0.75, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.canga), "Canga", 1.00, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.toblerone), "Toblerone", 5.25, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.toffie), "Toffie", 3.25, "tl",  "piece"));

            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.head_and_shoulders), "Shampoo H6S", 13.25, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.ipek), "Shampoo İpek", 14.50, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.hobby_blackberry), "Soap Blackberry", 5.75, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.hobby_orchide), "Orchide", 5.00, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.toilet_paper_papia), "Toilet Paper Papia", 8.25, "tl",  "piece"));
            arrayList_item.add(new Product_Item(ContextCompat.getDrawable(activity, R.drawable.toilet_paper_solo), "Toilet Paper Solo", 7.25, "tl",  "piece"));


        return arrayList_item;
    }


}
