package com.koala.sloth.TabOrder;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.koala.sloth.Providers.FridgeProvider;
import com.koala.sloth.R;

public class ActivityFridge extends AppCompatActivity {
    private ListView listView;
    private ActionBar actionBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);

        load();
    }


    private void load() {
        listView = findViewById(R.id.listView);
        listView.setAdapter(new FridgeCategory_Adapter(ActivityFridge.this, FridgeProvider.getFridgeCategories(this)));

    }


}
