package com.koala.sloth.Database.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.koala.sloth.Database.Dao.Item.OrderProduct;
import com.koala.sloth.Database.DatabaseHelper;
import com.koala.sloth.R;
import com.koala.sloth.Shared.Constant;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

@SuppressWarnings({"WeakerAccess", "unused"})
public class OrderProductDao {
    private final Context context;



    public OrderProductDao(Context contextP) {
        context = contextP;
    }

    public void addOrderProduct(String name, String category, double price, String priceUnit, String physicalUnit, byte picture[]) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("NAME", name);
        values.put("CATEGORY", category);
        values.put("PRICE", price);
        values.put("PRICE_UNIT", priceUnit);
        values.put("PHYSICAL_UNIT", physicalUnit);
        values.put("PICTURE", picture);

        db.insert("ORDER_PRODUCT", null, values);
        db.close();
    }

    public void removeOrderProduct(String name) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        db.delete("ORDER_PRODUCT", "NAME = ?", new String[] { name });
        db.close();
    }

    public ArrayList<OrderProduct> getOrderProductList(String categoryName) {
        ArrayList<OrderProduct> arrayList = new ArrayList<>();

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor  cursor = db.rawQuery("SELECT * FROM ORDER_PRODUCT WHERE CATEGORY = ?", new String[] { categoryName });

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex("NAME"));
                String category = cursor.getString(cursor.getColumnIndex("CATEGORY"));
                double price = cursor.getDouble(cursor.getColumnIndex("PRICE"));
                String priceUnit = cursor.getString(cursor.getColumnIndex("PRICE_UNIT"));
                String physicalUnit = cursor.getString(cursor.getColumnIndex("PHYSICAL_UNIT"));
                byte picture[] = cursor.getBlob(cursor.getColumnIndex("PICTURE"));

                arrayList.add(new OrderProduct(name, category, price, priceUnit, physicalUnit, getImage(picture)));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return arrayList;
    }

    public ArrayList<OrderProduct> findOrderProductList(String word) {
        ArrayList<OrderProduct> arrayList = new ArrayList<>();

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor  cursor;
        if (Constant.currentOrderCategory == null)
            cursor = db.rawQuery("SELECT * FROM ORDER_PRODUCT WHERE NAME LIKE ?", new String[] { "%"+ word +"%" });
        else
            cursor = db.rawQuery("SELECT * FROM ORDER_PRODUCT WHERE CATEGORY = ? AND NAME LIKE ?", new String[] { Constant.currentOrderCategory, "%"+ word +"%" });

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex("NAME"));
                String category = cursor.getString(cursor.getColumnIndex("CATEGORY"));
                double price = cursor.getDouble(cursor.getColumnIndex("PRICE"));
                String priceUnit = cursor.getString(cursor.getColumnIndex("PRICE_UNIT"));
                String physicalUnit = cursor.getString(cursor.getColumnIndex("PHYSICAL_UNIT"));
                byte picture[] = cursor.getBlob(cursor.getColumnIndex("PICTURE"));

                arrayList.add(new OrderProduct(name, category, price, priceUnit, physicalUnit, getImage(picture)));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return arrayList;
    }

    public void implementExampleDatabase() {    // ORNEK BIR DATABASE OLUSTURMAK ICIN SADECE BIR KERE CAGRILDI.
        addOrderProduct("Apple", "Fruit", 2.00, "TL", "kg", getDrawableAsByteArray(R.drawable.apple));
        addOrderProduct("Orange", "Fruit", 2.25, "TL", "kg", getDrawableAsByteArray(R.drawable.orange));
        addOrderProduct("Banana", "Fruit", 2.50, "TL", "kg", getDrawableAsByteArray(R.drawable.banana));
        addOrderProduct("Kiwi", "Fruit", 2.75, "TL", "kg", getDrawableAsByteArray(R.drawable.kiwi));

        addOrderProduct("Tomato", "Vegetable", 2.00, "TL", "kg", getDrawableAsByteArray(R.drawable.tomato));
        addOrderProduct("Cucumber", "Vegetable", 2.25, "TL", "kg", getDrawableAsByteArray(R.drawable.cucumber));
        addOrderProduct("Potato", "Vegetable", 2.50, "TL", "kg", getDrawableAsByteArray(R.drawable.potato));
        addOrderProduct("Carrot", "Vegetable", 2.75, "TL", "kg", getDrawableAsByteArray(R.drawable.carrot));
        addOrderProduct("Pepper", "Vegetable", 3.00, "TL", "kg", getDrawableAsByteArray(R.drawable.pepper));

        addOrderProduct("Terderloin", "Meat", 10.00, "TL", "kg", getDrawableAsByteArray(R.drawable.tenderloin));
        addOrderProduct("Entrecote", "Meat", 10.25, "TL", "kg", getDrawableAsByteArray(R.drawable.entrecote));
        addOrderProduct("Pinar Salami", "Meat", 10.50, "TL", "piece", getDrawableAsByteArray(R.drawable.pinar_salami));
        addOrderProduct("Pinar Sausage", "Meat", 10.75, "TL", "piece", getDrawableAsByteArray(R.drawable.pinar_sausage));
        addOrderProduct("Namet Salami", "Meat", 11.00, "TL", "piece", getDrawableAsByteArray(R.drawable.namet_salami));
        addOrderProduct("Namet Sausage", "Meat", 11.25, "TL", "piece", getDrawableAsByteArray(R.drawable.namet_sausage));

        addOrderProduct("Pepsi Cola", "Drink", 3.00, "TL", "piece", getDrawableAsByteArray(R.drawable.pepsi_cola));
        addOrderProduct("Fanta", "Drink", 3.25, "TL", "piece", getDrawableAsByteArray(R.drawable.fanta));
        addOrderProduct("Soda", "Drink", 3.50, "TL", "piece", getDrawableAsByteArray(R.drawable.soda));
        addOrderProduct("Sprite", "Drink", 3.75, "TL", "piece", getDrawableAsByteArray(R.drawable.sprite));
        addOrderProduct("Sek Juice", "Drink", 4.00, "TL", "piece", getDrawableAsByteArray(R.drawable.sek_juice));
        addOrderProduct("Cappy Juice", "Drink", 4.25, "TL", "piece", getDrawableAsByteArray(R.drawable.cappy_juice));

        addOrderProduct("Hazelnut", "Nut", 15.00, "TL", "kg", getDrawableAsByteArray(R.drawable.hazelnut));
        addOrderProduct("Peanut", "Nut", 15.25, "TL", "kg", getDrawableAsByteArray(R.drawable.peanut));
        addOrderProduct("Walnut", "Nut", 15.50, "TL", "kg", getDrawableAsByteArray(R.drawable.walnut));

        addOrderProduct("Red Pepper Flakes", "Spice", 1.00, "TL", "piece", getDrawableAsByteArray(R.drawable.red_pepper_flakes));
        addOrderProduct("Coconut", "Spice", 1.25, "TL", "piece", getDrawableAsByteArray(R.drawable.coconut));
        addOrderProduct("Tyhme", "Spice", 1.50, "TL", "piece", getDrawableAsByteArray(R.drawable.thyme));
        addOrderProduct("Mint", "Spice", 1.75, "TL", "piece", getDrawableAsByteArray(R.drawable.mint));

        addOrderProduct("Hanımeller", "Junk Food", 5.00, "TL", "piece", getDrawableAsByteArray(R.drawable.hanimeller));
        addOrderProduct("Ruffles", "Junk Food", 5.25, "TL", "piece", getDrawableAsByteArray(R.drawable.ruffles));
        addOrderProduct("Rocco", "Junk Food", 5.50, "TL", "piece", getDrawableAsByteArray(R.drawable.rocco));
        addOrderProduct("Canga", "Junk Food", 5.75, "TL", "piece", getDrawableAsByteArray(R.drawable.canga));
        addOrderProduct("Toblerone", "Junk Food", 6.00, "TL", "piece", getDrawableAsByteArray(R.drawable.toblerone));
        addOrderProduct("Toffie", "Junk Food", 6.25, "TL", "piece", getDrawableAsByteArray(R.drawable.toffie));

        addOrderProduct("H&S Shampoo", "Cleaning", 7.00, "TL", "piece", getDrawableAsByteArray(R.drawable.head_and_shoulders));
        addOrderProduct("İpek Shampoo", "Cleaning", 7.25, "TL", "piece", getDrawableAsByteArray(R.drawable.ipek));
        addOrderProduct("Hobby Soap Blackberry", "Cleaning", 7.50, "TL", "piece", getDrawableAsByteArray(R.drawable.hobby_blackberry));
        addOrderProduct("Hobby Soap Orchide", "Cleaning", 7.75, "TL", "piece", getDrawableAsByteArray(R.drawable.hobby_orchide));
        addOrderProduct("Papia Toilet Paper", "Cleaning", 8.00, "TL", "piece", getDrawableAsByteArray(R.drawable.toilet_paper_papia));
        addOrderProduct("Solo Toilet Paper", "Cleaning", 8.25, "TL", "piece", getDrawableAsByteArray(R.drawable.toilet_paper_solo));
    }


    private byte[] getDrawableAsByteArray(int drawable) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), drawable);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }
    private Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

}
