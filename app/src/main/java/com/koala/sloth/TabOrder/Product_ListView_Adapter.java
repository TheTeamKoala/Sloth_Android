package com.koala.sloth.TabOrder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.koala.sloth.Database.Dao.Item.OrderProduct;
import com.koala.sloth.R;
import com.koala.sloth.Shared.Constant;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

class Product_ListView_Adapter extends BaseAdapter {
    private final Activity activity;
    private final LayoutInflater inflater;

    private final ArrayList<OrderProduct> itemList_first;
    private final ArrayList<OrderProduct> itemList_second;



    Product_ListView_Adapter(Activity activityP, ArrayList<OrderProduct> itemListP) {
        activity = activityP;
        inflater = (LayoutInflater) activityP.getSystemService(LAYOUT_INFLATER_SERVICE);

        itemList_first = new ArrayList<>();
        itemList_second= new ArrayList<>();

        for (int i = 0; i< itemListP.size(); i++) {
            if (i%2 == 0)
                itemList_first.add(itemListP.get(i));
            else
                itemList_second.add(itemListP.get(i));
        }
    }

    public OrderProduct getItem(int position) {
        return itemList_first.get(position);
    }
    @SuppressLint("InflateParams")
    public View getView(final int position, View convertView, ViewGroup parent) {
        View satirView;
        if (convertView!=null && ((TextView)convertView.findViewById(R.id.textView_name1)).getText().toString().equals(itemList_first.get(position).getName()))
            satirView = convertView;
        else
            satirView = inflater.inflate(R.layout.activity_order_product_row, null);


        final OrderProduct first_item= itemList_first.get(position);

        TextView textView_name1 = satirView.findViewById(R.id.textView_name1);
        textView_name1.setText(first_item.getName());

        ImageView imageView_picture1 = satirView.findViewById(R.id.imageView_picture1);
        imageView_picture1.setImageBitmap(first_item.getPicture());
        imageView_picture1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(first_item);
            }
        });

        TextView textView_pricePerUnit1 = satirView.findViewById(R.id.textView_pricePerUnit1);
        textView_pricePerUnit1.setText(String.valueOf(first_item.getPrice() +" "+ first_item.getPriceUnit()  +"/"+ first_item.getPhysicalUnit()));


        TextView textView_name2 = satirView.findViewById(R.id.textView_name2);
        ImageView imageView_picture2 = satirView.findViewById(R.id.imageView_picture2);
        TextView textView_pricePerUnit2 = satirView.findViewById(R.id.textView_pricePerUnit2);
        if (position < itemList_second.size()) {
            final OrderProduct second_item= itemList_second.get(position);

            textView_name2.setText(second_item.getName());
            textView_pricePerUnit2.setText(String.valueOf(second_item.getPrice() +" "+ second_item.getPriceUnit() +"/"+ second_item.getPhysicalUnit()));

            imageView_picture2.setImageBitmap(second_item.getPicture());
            imageView_picture2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog(second_item);
                }
            });
        }
        else {
            textView_name2.setVisibility(View.INVISIBLE);
            imageView_picture2.setVisibility(View.INVISIBLE);
        }


        Display display = activity.getWindowManager().getDefaultDisplay();
        Point temp = new Point();
        display.getSize(temp);

        imageView_picture1.setLayoutParams(new FrameLayout.LayoutParams(temp.x/2, temp.x/3));
        imageView_picture2.setLayoutParams(new FrameLayout.LayoutParams(temp.x/2, temp.x/3));

        return satirView;
    }
    public long getItemId(int position) {
        return position;
    }
    public int getCount() {
        return itemList_first.size();
    }

    private void showDialog(final OrderProduct item) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);

        final LayoutInflater inflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View layout = inflater.inflate(R.layout.dialog_order_no, (ViewGroup) activity.findViewById(R.id.linearLayout_dialog));


        final TextView textView_product = layout.findViewById(R.id.textView_product);
        final TextView textView_price = layout.findViewById(R.id.textView_price);
        final TextView textView_totalPrice = layout.findViewById(R.id.textView_totalPrice);
        textView_product.setText(String.valueOf("Product: "+ item.getName()));
        textView_price.setText(String.valueOf("Price: "+ item.getPrice() +" "+ item.getPriceUnit()+"/"+ item.getPhysicalUnit()));
        textView_totalPrice.setText(String.valueOf("Total Price: "+ item.getPrice()));

        final NumberPicker numberPicker_order = layout.findViewById(R.id.numberPicker_order);
        numberPicker_order.setMinValue(1);
        numberPicker_order.setMaxValue(10);
        numberPicker_order.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                textView_totalPrice.setText(String.valueOf("Total Price: "+ newVal*item.getPrice()));
            }
        });


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
                item.setQuantity(numberPicker_order.getValue());

                Constant.addItemToBasket(item);

                Toast.makeText(activity, "Your order has been added to your basket.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


        Display display = activity.getWindowManager().getDefaultDisplay();
        Point temp = new Point();
        display.getSize(temp);

        LinearLayout linearLayout_buttons = layout.findViewById(R.id.linearLayout_buttons);
        linearLayout_buttons.setLayoutParams(new LinearLayout.LayoutParams((temp.x/2), ViewGroup.LayoutParams.WRAP_CONTENT));

        dialog.setContentView(layout);
        dialog.show();
    }

}
