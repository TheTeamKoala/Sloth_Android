package com.koala.sloth.Database.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.koala.sloth.Database.Dao.Item.HistoryProduct;
import com.koala.sloth.Database.DatabaseHelper;

import java.util.ArrayList;

@SuppressWarnings({"WeakerAccess", "unused"})
public class HistoryProductDao {
    private final Context context;



    public HistoryProductDao(Context contextP) {
        context = contextP;
    }

    public void addHistoryProduct(String product, double price, String priceUnit, String physicalUnit, int quantity, long time) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("PRODUCT", product);
        values.put("PRICE", price);
        values.put("PRICE_UNIT", priceUnit);
        values.put("PHYSICAL_UNIT", physicalUnit);
        values.put("QUANTITY", quantity);
        values.put("TIME", time);

        db.insert("HISTORY_PRODUCT", null, values);
        db.close();
    }

    public void removeHistoryProduct(String product) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        db.delete("HISTORY_PRODUCT", "PRODUCT = ?", new String[] { product });
        db.close();
    }

    public ArrayList<HistoryProduct> getHistoryProductList() {
        ArrayList<HistoryProduct> arrayList = new ArrayList<>();

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor  cursor = db.rawQuery("SELECT * FROM HISTORY_PRODUCT", new String[] {});

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String product = cursor.getString(cursor.getColumnIndex("PRODUCT"));
                double price = cursor.getDouble(cursor.getColumnIndex("PRICE"));
                String priceUnit = cursor.getString(cursor.getColumnIndex("PRICE_UNIT"));
                String physicalUnit = cursor.getString(cursor.getColumnIndex("PHYSICAL_UNIT"));
                int quantity = cursor.getInt(cursor.getColumnIndex("QUANTITY"));
                long time = cursor.getLong(cursor.getColumnIndex("TIME"));

                arrayList.add(new HistoryProduct(product, price, priceUnit, physicalUnit, quantity, time));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return arrayList;
    }

    public void implementExampleDatabase() {    // ORNEK BIR DATABASE OLUSTURMAK ICIN SADECE BIR KERE CAGRILDI.
        addHistoryProduct("Apple", 2.00, "TL", "kg", 1, 1551615240120L);
        addHistoryProduct("Pepper", 3.00, "TL", "kg",  2, 1551615240120L);
        addHistoryProduct("Mint", 1.75, "TL", "piece",  1, 1549215962160L);
        addHistoryProduct("Toblerone", 6.00, "TL", "piece",  3, 1551629647524L);
    }

}
