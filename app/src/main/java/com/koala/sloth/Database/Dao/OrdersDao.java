package com.koala.sloth.Database.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.koala.sloth.Database.Dao.Item.Order;
import com.koala.sloth.Database.DatabaseHelper;

import java.util.ArrayList;

@SuppressWarnings({"WeakerAccess", "unused"})
public class OrdersDao {
    private final Context context;
    private ProductDao productDao;


    public OrdersDao(Context contextP) {
        context = contextP;
        productDao = new ProductDao(contextP);
    }

    public void addOrder(int productId,int quantity, long date) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("PRODUCT_ID", productId);
        values.put("QUANTITY", quantity);
        values.put("DATE", date);

        db.insert("ORDERS", null, values);
        db.close();
    }

    public ArrayList<Order> getOrderList() {
        ArrayList<Order> arrayList = new ArrayList<>();

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor  cursor = db.rawQuery("SELECT * FROM ORDERS", new String[] {});

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int productId = cursor.getInt(cursor.getColumnIndex("PRODUCT_ID"));
                int quantity = cursor.getInt(cursor.getColumnIndex("QUANTITY"));
                long date = cursor.getLong(cursor.getColumnIndex("DATE"));

                arrayList.add(new Order(productId, quantity, date,null));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return arrayList;
    }

    public void implementExampleDatabase() {    // ORNEK BIR DATABASE OLUSTURMAK ICIN SADECE BIR KERE CAGRILDI.
        addOrder(1, 2, 1551615240120L);
        addOrder(5, 3, 1551615240120L);
        addOrder(7, 1, 1549215962160L);
        addOrder(15,3, 1551629647524L);
    }

}
