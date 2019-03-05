package com.koala.sloth.TabOrder;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.koala.sloth.Database.Dao.HistoryProductDao;
import com.koala.sloth.Database.Dao.Item.OrderProduct;
import com.koala.sloth.Database.Dao.OrderProductDao;
import com.koala.sloth.R;
import com.koala.sloth.Shared.Constant;

import java.util.ArrayList;

public class ActivityOrder extends AppCompatActivity {
    private ListView listView;
    private ActionBar actionBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        load();
    }
    public void onBackPressed() {
        cancelFromCategory();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.order, menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            cancelFromCategory();
        }
        else if (id == R.id.menu_find) {
            showDialog_Find();
        }

        return super.onOptionsItemSelected(item);
    }
    private void cancelFromCategory() {
        if (listView.getAdapter()!=null && listView.getAdapter() instanceof Product_ListView_Adapter) {
            listView.setAdapter(new Category_ListView_Adapter(ActivityOrder.this, getOrderCategories(this)));

            if (actionBar!=null)
                actionBar.setTitle("Order");
        }
        else
            finish();
    }

    private void load() {
        listView = findViewById(R.id.listView);
        listView.setAdapter(new Category_ListView_Adapter(ActivityOrder.this, getOrderCategories(this)));

        actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setTitle("Order");

            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
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
        listView_basket.setAdapter(new Basket_ListView_Adapter(this));

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
                Toast.makeText(ActivityOrder.this, "Your order is on the way!", Toast.LENGTH_SHORT).show();

                HistoryProductDao historyProductDao = new HistoryProductDao(getApplicationContext());
                for (int i=0; i<Constant.basket.size(); i++) {
                    OrderProduct orderProduct = Constant.basket.get(i);
                    historyProductDao.addHistoryProduct(orderProduct.getName(), orderProduct.getPrice(), orderProduct.getPriceUnit(), orderProduct.getPhysicalUnit(), orderProduct.getQuantity(), System.currentTimeMillis());
                }

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
    private void showDialog_Find() {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("My Basket");
        dialog.setCancelable(true);

        final LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View layout = inflater.inflate(R.layout.dialog_order_find, (ViewGroup) findViewById(R.id.linearLayout_orderFind));

        final EditText editText = layout.findViewById(R.id.editText_orderfind);
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
                String text = editText.getText().toString();
                if (text.length()==0) {
                    Toast.makeText(getApplicationContext(), "Please enter something!", Toast.LENGTH_SHORT).show();

                    return;
                }

                OrderProductDao ordersDao = new OrderProductDao(getApplicationContext());
                listView.setAdapter(new Product_ListView_Adapter(ActivityOrder.this, ordersDao.findOrderProductList(editText.getText().toString())));

                dialog.dismiss();
            }
        });

        Display display = getWindowManager().getDefaultDisplay();
        Point temp = new Point();
        display.getSize(temp);

        editText.setLayoutParams(new LinearLayout.LayoutParams((int)(temp.x/1.25), ViewGroup.LayoutParams.WRAP_CONTENT));

        dialog.setContentView(layout);
        dialog.show();
    }

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

    public void setProductAdapter(String categoryName) {
        OrderProductDao ordersDao = new OrderProductDao(getApplicationContext());
        listView.setAdapter(new Product_ListView_Adapter(ActivityOrder.this, ordersDao.getOrderProductList(categoryName)));
        Constant.currentOrderCategory = categoryName;

        if (actionBar!=null)
            actionBar.setTitle(categoryName);
    }

}
