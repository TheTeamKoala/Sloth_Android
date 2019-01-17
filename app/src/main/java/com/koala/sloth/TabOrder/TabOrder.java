package com.koala.sloth.TabOrder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.koala.sloth.Providers.OrderProvider;
import com.koala.sloth.R;

public class TabOrder extends AppCompatActivity {

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

    private void load() {
        ListView listView_orderCategories = findViewById(R.id.listView_orderCategories);
        listView_orderCategories.setAdapter(new ListView_Adapter(TabOrder.this, OrderProvider.getOrder(this)));
    }

}
