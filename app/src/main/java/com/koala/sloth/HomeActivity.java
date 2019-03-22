package com.koala.sloth;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.koala.sloth.Database.Dao.Item.Order;
import com.koala.sloth.Database.Dao.Item.Product;
import com.koala.sloth.Database.Dao.OrdersDao;
import com.koala.sloth.Database.Dao.ProductDao;
import com.koala.sloth.TabFridge.ActivityFridge;
import com.koala.sloth.TabHistory.ActivityHistory;
import com.koala.sloth.TabOrder.ActivityOrder;
import  com.koala.sloth.ServerConnection.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RequestQueue queue ;
    static ServerConnectionForProduct connP ;
    static ServerConnectionForOrder connO ;
    static ArrayList<com.koala.sloth.ServerConnection.Product> serverProd;
    static ArrayList<com.koala.sloth.ServerConnection.Order> serverOrder;
    static  OrdersDao ordersDao ;
    static  ProductDao productDao ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ordersDao = new OrdersDao(this);
        productDao = new ProductDao(this);

        /*queue = Volley.newRequestQueue(this);
        connP = new ServerConnectionForProduct(queue);
        connO = new ServerConnectionForOrder(queue);

        connP.returnAllProduct();
        connO.returnAllOrder();*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final EditText editText_findProduct = findViewById(R.id.editText_findProduct);
        editText_findProduct.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()!=KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (editText_findProduct.getText().toString().equals("")) {
                        return true;
                    }

                    Product product = productDao.getProductByName(editText_findProduct.getText().toString());

                    final Dialog dialog = new Dialog(HomeActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setCancelable(true);
                    dialog.setContentView(R.layout.dialog_find_product);

                    TextView textView_name = dialog.findViewById(R.id.textView_name);
                    TextView textView_date = dialog.findViewById(R.id.textView_date);
                    if (product == null) {
                        String text = "Wrong product name!";
                        textView_name.setText(text);
                        textView_date.setVisibility(View.INVISIBLE);
                    }
                    else {
                        if (product.isInFridge() == 1) {
                            SpannableString spannableString = new SpannableString("You have " + product.getName() + " in the fridge.");
                            spannableString.setSpan(new ForegroundColorSpan(Color.RED), 4, 9 + product.getName().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            textView_name.setText(spannableString);

                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss", Locale.getDefault());
                            textView_date.setText(String.valueOf("First seen: " + simpleDateFormat.format(product.getFirstDate())));
                        } else {
                            SpannableString spannableString = new SpannableString("You don't have " + product.getName() + " in the fridge.");
                            spannableString.setSpan(new ForegroundColorSpan(Color.RED), 4, 15 + product.getName().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            textView_name.setText(spannableString);

                            textView_date.setVisibility(View.INVISIBLE);
                        }
                    }

                    Button button_ok = dialog.findViewById(R.id.button_ok);
                    button_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }

                return false;
            }
        });
    }
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(getApplicationContext(), "First", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_fridge) {
            Intent intent = new Intent(getApplicationContext(), ActivityFridge.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_order) {
            Intent intent = new Intent(getApplicationContext(), ActivityOrder.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_history) {
            Intent intent = new Intent(getApplicationContext(), ActivityHistory.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_settings) {
            Toast.makeText(getApplicationContext(), "Seventh", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.loadExampleDatabase) {
            new ProductDao(getApplicationContext()).implementExampleDatabase();
            new OrdersDao(getApplicationContext()).implementExampleDatabase();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public static  void sencProducts(){
        ArrayList<Product> products = productDao.getProductList();
        serverProd = connP.products;

        ArrayList<com.koala.sloth.ServerConnection.Product> diff = new ArrayList<>();
        Boolean bdiff=true;
        for (int i = 0 ; i<serverProd.size();i++){
            com.koala.sloth.ServerConnection.Product temp = serverProd.get(i);
            for (int j = 0 ; j<products.size();j++){
                Product temp2=products.get(j);
                if(temp.getId()==temp2.getId()){
                    if(temp.getInFridge()!=temp2.isInFridge()){
                        if(temp.getInFridge()==1){
                             productDao.addToFridge(temp2.getId());
                        }
                        else{
                            productDao.removeFromFridge(temp2.getId());
                        }

                    }
                    bdiff=false;
                    break;
                }
            }
            if (bdiff)
                diff.add(temp);
            bdiff=true;
        }

        for (int i =0 ; i<diff.size();i++){
            com.koala.sloth.ServerConnection.Product get = diff.get(i);
             String name=get.getName();
             String brand=get.getBrand();
             String category=get.getCategory();
             double price=get.getPrice();
             String priceUnit=get.getPriceUnit();
             String physicalUnit=get.getPhysicalUnit();
             long firstDate=get.getFirstDate();
             int inFridgeInt=get.getInFridge();
             boolean inFridge=false;
             if(inFridgeInt==1){
                 inFridge=true;
             }
             else{
                 inFridge=false;
             }
             productDao.addOrderProduct(name,brand,category,price,priceUnit,physicalUnit,firstDate,inFridge,null);

        }
    }
    public static  void sencOrders(){
        ArrayList<Order> orders = ordersDao.getOrderList();
        serverOrder = connO.orders;

        ArrayList<com.koala.sloth.ServerConnection.Order> diff = new ArrayList<>();
        Boolean bdiff=true;
        for (int i = 0 ; i<serverOrder.size();i++){
            com.koala.sloth.ServerConnection.Order temp = serverOrder.get(i);
            for (int j = 0 ; j<orders.size();j++){
                Order temp2=orders.get(j);
                if(temp.getId()==temp2.getProductId()){
                    bdiff=false;
                    break;
                }
            }
            if (bdiff)
                diff.add(temp);
            bdiff=true;
        }

        for (int i =0 ; i<diff.size();i++){
            com.koala.sloth.ServerConnection.Order get = diff.get(i);
            Integer productId=get.getProductId();
            Integer quantity=get.getQuantity();
            long date=get.getDate();

            ordersDao.addOrder(productId,quantity,date);
        }
    }

}
