package com.koala.sloth.TabFridge;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.koala.sloth.Database.Dao.ProductDao;
import com.koala.sloth.R;


public class  ActivityFridge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);

        load();
    }
    public void onBackPressed() {
        finish();
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
        ListView listView = findViewById(R.id.listView_fridge);
        listView.setAdapter(new Product_ListView_Adapter(this, new ProductDao(getApplicationContext()).getFridgeProductList()));

        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null) {
            actionBar.setTitle("Fridge");

            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
