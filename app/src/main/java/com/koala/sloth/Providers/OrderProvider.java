package com.koala.sloth.Providers;

import android.app.Activity;
import android.support.v4.content.ContextCompat;

import com.koala.sloth.R;
import com.koala.sloth.Shared.Constant;
import com.koala.sloth.TabOrder.Category_ListView_Item;
import com.koala.sloth.TabOrder.Product_ListView_Item;

import java.util.ArrayList;

public class OrderProvider {

    public static ArrayList<Category_ListView_Item>getOrderCategories(Activity activity) {
        ArrayList<Category_ListView_Item> arrayList_item = new ArrayList<>();

        arrayList_item.add(new Category_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.fruit), Constant.ORDER_CATEGORY_FRUIT));
        arrayList_item.add(new Category_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.vegetable), Constant.ORDER_CATEGORY_VEGETABLE));
        arrayList_item.add(new Category_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.meat), Constant.ORDER_CATEGORY_MEAT));
        arrayList_item.add(new Category_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.drink), Constant.ORDER_CATEGORY_DRINK));
        arrayList_item.add(new Category_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.nut), Constant.ORDER_CATEGORY_NUT));
        arrayList_item.add(new Category_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.spice), Constant.ORDER_CATEGORY_SPICE));
        arrayList_item.add(new Category_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.junk_food), Constant.ORDER_CATEGORY_JUNK_FOOD));
        arrayList_item.add(new Category_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.cleaning), Constant.ORDER_CATEGORY_CLEANING));

        return arrayList_item;
    }

    public static ArrayList<Product_ListView_Item>getProducts(Activity activity, String categoryName) {
        ArrayList<Product_ListView_Item> arrayList_item = new ArrayList<>();

        if (categoryName.equals(Constant.ORDER_CATEGORY_FRUIT)) {
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.apple), "Apple", 1.25, "tl", "kg"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.orange), "Orange", 1.50, "tl",  "kg"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.banana), "Banana", 1.75, "tl",  "kg"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.kiwi), "Kiwi", 2.0, "tl",  "kg"));
        }
        else if (categoryName.equals(Constant.ORDER_CATEGORY_VEGETABLE)) {
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.tomato), "Tomato", 0.25, "tl",  "kg"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.cucumber), "Cucumber", 0.50, "tl",  "kg"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.potato), "Potato", 0.75, "tl",  "kg"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.carrot), "Carrot", 1.00, "tl",  "kg"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.pepper), "Pepper", 1.25, "tl",  "kg"));
        }
        else if (categoryName.equals(Constant.ORDER_CATEGORY_MEAT)) {
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.tenderloin), "Tenderloin", 35.50, "tl",  "kg"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.entrecote), "Entrecote", 55.50, "tl",  "kg"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.pinar_salami), "Pinar Salami", 3.25, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.pinar_sausage), "Pinar Sausage", 5.25, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.namet_salami), "Namet Salami", 3.75, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.namet_sausage), "Namet Sausage", 5.75, "tl",  "piece"));
        }
        else if (categoryName.equals(Constant.ORDER_CATEGORY_DRINK)) {
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.pepsi_cola), "Pepsi Cola", 2.25, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.fanta), "Fanta", 2.50, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.soda), "Soda", 0.75, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.sprite), "Sprite", 2.00, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.sek_juice), "Sek Juice", 2.25, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.cappy_juice), "Cappy Juice", 2.50, "tl",  "piece"));
        }
        else if (categoryName.equals(Constant.ORDER_CATEGORY_NUT)) {
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.hazelnut), "Hazelnut", 15.25, "tl",  "kg"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.peanut), "Peanut", 16.50, "tl",  "kg"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.walnut), "Walnut", 17.75, "tl",  "kg"));
        }
        else if (categoryName.equals(Constant.ORDER_CATEGORY_SPICE)) {
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.red_pepper_flakes), "Rep Pepper Flakes", 4.25, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.coconut), "Coconut", 4.50, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.thyme), "Thyme", 3.75, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.mint), "Mint", 4.00, "tl",  "piece"));
        }
        else if (categoryName.equals(Constant.ORDER_CATEGORY_JUNK_FOOD)) {
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.hanimeller), "Hanımeller", 1.25, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.ruffles), "Ruffles", 3.50, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.rocco), "Rocco", 0.75, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.canga), "Canga", 1.00, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.toblerone), "Toblerone", 5.25, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.toffie), "Toffie", 3.25, "tl",  "piece"));
        }
        else if (categoryName.equals(Constant.ORDER_CATEGORY_CLEANING)) {
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.head_and_shoulders), "Shampoo H6S", 13.25, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.ipek), "Shampoo İpek", 14.50, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.hobby_blackberry), "Soap Blackberry", 5.75, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.hobby_orchide), "Orchide", 5.00, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.toilet_paper_papia), "Toilet Paper Papia", 8.25, "tl",  "piece"));
            arrayList_item.add(new Product_ListView_Item(ContextCompat.getDrawable(activity, R.drawable.toilet_paper_solo), "Toilet Paper Solo", 7.25, "tl",  "piece"));
        }

        return arrayList_item;
    }

}
