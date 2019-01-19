package com.koala.sloth.TabOrder;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.koala.sloth.Providers.OrderProvider;
import com.koala.sloth.R;

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
        calcelFromCategory();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            calcelFromCategory();
        }

        return super.onOptionsItemSelected(item);
    }
    private void calcelFromCategory() {
        if (listView.getAdapter()!=null && listView.getAdapter() instanceof Product_ListView_Adapter) {
            listView.setAdapter(new Category_ListView_Adapter(ActivityOrder.this, OrderProvider.getOrderCategories(this)));

            if (actionBar!=null)
                actionBar.setTitle("Order");
        }
        else
            finish();
    }

    private void load() {
        listView = findViewById(R.id.listView);
        listView.setAdapter(new Category_ListView_Adapter(ActivityOrder.this, OrderProvider.getOrderCategories(this)));

        actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setTitle("Order");

            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void setProductAdapter(String categoryName) {
        listView.setAdapter(new Product_ListView_Adapter(ActivityOrder.this, OrderProvider.getProducts(this, categoryName)));

        if (actionBar!=null)
            actionBar.setTitle(categoryName);
    }

}
