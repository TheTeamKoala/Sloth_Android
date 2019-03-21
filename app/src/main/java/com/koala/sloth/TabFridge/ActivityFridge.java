package com.koala.sloth.TabFridge;

import android.app.Dialog;
import android.graphics.Point;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.koala.sloth.R;
import com.koala.sloth.Shared.Constant;


import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;


public class  ActivityFridge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);

        load();
    }
    public void onBackPressed() {
        cancelFromCategory();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            cancelFromCategory();
        }

        return super.onOptionsItemSelected(item);
    }
    private void cancelFromCategory() {
            finish();
    }

    private void load() {
        ListView listView = findViewById(R.id.listView);
        //TODO HAŞİM HELP
        //listView.setAdapter(new FridgeCategory_Adapter(ActivityFridge.this, FridgeProvider.getFridgeCategories(this) , FridgeProvider.getProducts(this)));


        ActionBar actionBar = getSupportActionBar();



        if (actionBar !=null) {
            actionBar.setTitle("Fridge");

            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setIcon(R.drawable.ic_menu_call);
        }
        Constant.basket = new ArrayList<>();
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton_basket);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog_Basket();
            }
        });
    }

    private void showDialog_Basket() {
        if (Constant.basket.size()==0) {
            Toast.makeText(this, "Your basket is empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        final Dialog dialog = new Dialog(this);
        dialog.setTitle("My Basket");
        dialog.setCancelable(true);

        final LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View layout = inflater.inflate(R.layout.dialog_basket, (ViewGroup) findViewById(R.id.linearLayout_basket));


        ListView listView_basket = layout.findViewById(R.id.listView_basket);
        listView_basket.setAdapter(new Basket_Adapter_forFridge(this));

        Button button_cancel = layout.findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button button_ok = layout.findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityFridge.this, "Your order is on the way!", Toast.LENGTH_SHORT).show();
                Constant.basket = new ArrayList<>();

                dialog.dismiss();
            }
        });


        Display display = getWindowManager().getDefaultDisplay();
        Point temp = new Point();
        display.getSize(temp);

        listView_basket.setLayoutParams(new LinearLayout.LayoutParams((int)(temp.x/1.25), (int)(temp.y/1.25)));

        dialog.setContentView(layout);
        dialog.show();
    }




}
