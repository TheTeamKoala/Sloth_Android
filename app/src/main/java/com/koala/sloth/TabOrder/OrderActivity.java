package com.koala.sloth.TabOrder;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.koala.sloth.Providers.OrderProvider;
import com.koala.sloth.R;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        load();
    }
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void load() {
        ListView listView_orderCategories = findViewById(R.id.listView_orderCategories);
        listView_orderCategories.setAdapter(new ListView_Adapter(OrderActivity.this, OrderProvider.getOrder(this)));

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setTitle("Order");

            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
