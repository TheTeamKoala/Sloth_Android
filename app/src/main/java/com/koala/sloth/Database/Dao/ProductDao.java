package com.koala.sloth.Database.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.koala.sloth.Database.Dao.Item.Product;
import com.koala.sloth.Database.DatabaseHelper;
import com.koala.sloth.R;
import com.koala.sloth.Shared.Constant;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

@SuppressWarnings({"WeakerAccess", "unused"})
public class ProductDao {
    private final Context context;



    public ProductDao(Context contextP) {
        context = contextP;
    }

    public void addOrderProduct(String name, String brand, String category, double price, String priceUnit, String physicalUnit, long firstDate, boolean inFridge, byte picture[]) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("NAME", name);
        values.put("CATEGORY", category);
        if (brand==null)
            values.putNull("BRAND");
        else
            values.put("BRAND", brand);
        values.put("PRICE", price);
        values.put("PRICE_UNIT", priceUnit);
        values.put("PHYSICAL_UNIT", physicalUnit);
        values.put("FIRST_DATE", firstDate);
        values.put("IN_FRIDGE", inFridge);
        values.put("PICTURE", picture);

        db.insert("PRODUCT", null, values);
        db.close();
    }

    public void removeOrderProduct(String name) {
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
        db.delete("PRODUCT", "NAME = ?", new String[] { name });
        db.close();
    }

    public Product getProductById(int Id) {
        ArrayList<Product> arrayList = new ArrayList<>();

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor  cursor = db.rawQuery("SELECT * FROM PRODUCT WHERE ID = ?", new String[] { String.valueOf(Id) });

        Product product = null;
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String name = cursor.getString(cursor.getColumnIndex("NAME"));
                String brand = cursor.getString(cursor.getColumnIndex("BRAND"));
                String category = cursor.getString(cursor.getColumnIndex("CATEGORY"));
                float price = cursor.getFloat(cursor.getColumnIndex("PRICE"));
                String priceUnit = cursor.getString(cursor.getColumnIndex("PRICE_UNIT"));
                String physicalUnit = cursor.getString(cursor.getColumnIndex("PHYSICAL_UNIT"));
                long firstDate = cursor.getLong(cursor.getColumnIndex("FIRST_DATE"));
                int inFridge = cursor.getInt(cursor.getColumnIndex("IN_FRIDGE"));
                byte picture[] = cursor.getBlob(cursor.getColumnIndex("PICTURE"));

                product = new Product(id, name, brand, category, price, priceUnit, physicalUnit, firstDate, inFridge, getImage(picture));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return product;
    }

    public Product getProductByName(String name) {
        ArrayList<Product> arrayList = new ArrayList<>();

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor  cursor = db.rawQuery("SELECT * FROM PRODUCT WHERE NAME = ?", new String[] { name });

        Product product = null;
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String brand = cursor.getString(cursor.getColumnIndex("BRAND"));
            String category = cursor.getString(cursor.getColumnIndex("CATEGORY"));
            float price = cursor.getFloat(cursor.getColumnIndex("PRICE"));
            String priceUnit = cursor.getString(cursor.getColumnIndex("PRICE_UNIT"));
            String physicalUnit = cursor.getString(cursor.getColumnIndex("PHYSICAL_UNIT"));
            long firstDate = cursor.getLong(cursor.getColumnIndex("FIRST_DATE"));
            int inFridge = cursor.getInt(cursor.getColumnIndex("IN_FRIDGE"));
            byte picture[] = cursor.getBlob(cursor.getColumnIndex("PICTURE"));
            product = new Product(id, name, brand, category, price, priceUnit, physicalUnit, firstDate, inFridge, getImage(picture));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();

        return product;
    }

    public ArrayList<Product> getProductList() {
        ArrayList<Product> arrayList = new ArrayList<>();

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor  cursor = db.rawQuery("SELECT * FROM PRODUCT ", new String[] {});

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String name = cursor.getString(cursor.getColumnIndex("NAME"));
                String brand = cursor.getString(cursor.getColumnIndex("BRAND"));
                String category = cursor.getString(cursor.getColumnIndex("CATEGORY"));
                float price = cursor.getFloat(cursor.getColumnIndex("PRICE"));
                String priceUnit = cursor.getString(cursor.getColumnIndex("PRICE_UNIT"));
                String physicalUnit = cursor.getString(cursor.getColumnIndex("PHYSICAL_UNIT"));
                long firstDate = cursor.getLong(cursor.getColumnIndex("FIRST_DATE"));
                int inFridge = cursor.getInt(cursor.getColumnIndex("IN_FRIDGE"));
                byte picture[] = cursor.getBlob(cursor.getColumnIndex("PICTURE"));

                arrayList.add(new Product(id, name, brand, category, price, priceUnit, physicalUnit, firstDate, inFridge, getImage(picture)));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return arrayList;
    }

    public ArrayList<Product> getOrderProductList(String categoryName) {
        ArrayList<Product> arrayList = new ArrayList<>();

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor  cursor = db.rawQuery("SELECT * FROM PRODUCT WHERE CATEGORY = ?", new String[] { categoryName });

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String name = cursor.getString(cursor.getColumnIndex("NAME"));
                String brand = cursor.getString(cursor.getColumnIndex("BRAND"));
                String category = cursor.getString(cursor.getColumnIndex("CATEGORY"));
                float price = cursor.getFloat(cursor.getColumnIndex("PRICE"));
                String priceUnit = cursor.getString(cursor.getColumnIndex("PRICE_UNIT"));
                String physicalUnit = cursor.getString(cursor.getColumnIndex("PHYSICAL_UNIT"));
                long firstDate = cursor.getLong(cursor.getColumnIndex("FIRST_DATE"));
                int inFridge = cursor.getInt(cursor.getColumnIndex("IN_FRIDGE"));
                byte picture[] = cursor.getBlob(cursor.getColumnIndex("PICTURE"));

                arrayList.add(new Product(id, name, brand, category, price, priceUnit, physicalUnit, firstDate, inFridge, getImage(picture)));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return arrayList;
    }

    public ArrayList<Product> getFridgeProductList() {
        ArrayList<Product> arrayList = new ArrayList<>();

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor  cursor = db.rawQuery("SELECT * FROM PRODUCT WHERE IN_FRIDGE = ?", new String[] { "1" });

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String name = cursor.getString(cursor.getColumnIndex("NAME"));
                String brand = cursor.getString(cursor.getColumnIndex("BRAND"));
                String category = cursor.getString(cursor.getColumnIndex("CATEGORY"));
                float price = cursor.getFloat(cursor.getColumnIndex("PRICE"));
                String priceUnit = cursor.getString(cursor.getColumnIndex("PRICE_UNIT"));
                String physicalUnit = cursor.getString(cursor.getColumnIndex("PHYSICAL_UNIT"));
                long firstDate = cursor.getLong(cursor.getColumnIndex("FIRST_DATE"));
                int inFridge = cursor.getInt(cursor.getColumnIndex("IN_FRIDGE"));
                byte picture[] = cursor.getBlob(cursor.getColumnIndex("PICTURE"));

                arrayList.add(new Product(id, name, brand, category, price, priceUnit, physicalUnit, firstDate, inFridge, getImage(picture)));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return arrayList;
    }

    public ArrayList<Product> findOrderProductList(String word) {
        ArrayList<Product> arrayList = new ArrayList<>();

        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        Cursor  cursor;
        if (Constant.currentOrderCategory == null)
            cursor = db.rawQuery("SELECT * FROM PRODUCT WHERE NAME LIKE ?", new String[] { "%"+ word +"%" });
        else
            cursor = db.rawQuery("SELECT * FROM PRODUCT WHERE CATEGORY = ? AND NAME LIKE ?", new String[] { Constant.currentOrderCategory, "%"+ word +"%" });

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String name = cursor.getString(cursor.getColumnIndex("NAME"));
                String brand = cursor.getString(cursor.getColumnIndex("BRAND"));
                String category = cursor.getString(cursor.getColumnIndex("CATEGORY"));
                float price = cursor.getFloat(cursor.getColumnIndex("PRICE"));
                String priceUnit = cursor.getString(cursor.getColumnIndex("PRICE_UNIT"));
                String physicalUnit = cursor.getString(cursor.getColumnIndex("PHYSICAL_UNIT"));
                long firstDate = cursor.getLong(cursor.getColumnIndex("FIRST_DATE"));
                int inFridge = cursor.getInt(cursor.getColumnIndex("IN_FRIDGE"));
                byte picture[] = cursor.getBlob(cursor.getColumnIndex("PICTURE"));

                arrayList.add(new Product(id, name, brand, category, price, priceUnit, physicalUnit, firstDate, inFridge, getImage(picture)));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return arrayList;
    }

    public void addToFridge(int id){
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        db.execSQL("UPDATE PRODUCT SET IN_FRIDGE=1  WHERE id=" + id);
    }

    public void removeFromFridge(int id){
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        db.execSQL("UPDATE PRODUCT SET IN_FRIDGE=0  WHERE id="+id);
    }

    public void setDateProduct(int id,long date){
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
        db.execSQL("UPDATE PRODUCT SET FIRST_DATE= ? WHERE id="+id,new String[]{""+date});
    }

    public void implementExampleDatabase() {    // ORNEK BIR DATABASE OLUSTURMAK ICIN CAGRILIYOR.
        DatabaseHelper.getInstance(context).getWritableDatabase().delete("PRODUCT", null,null);
        DatabaseHelper.getInstance(context).resetAutoIncrementProduct();

        addOrderProduct("Apple", null,"Fruit", 2.00, "TL", "kg", 1551215240120L, true, getDrawableAsByteArray(R.drawable.a1));
        addOrderProduct("Orange", null,"Fruit", 2.25, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a2));
        addOrderProduct("Banana", null,"Fruit", 2.50, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a3));
        addOrderProduct("Kiwi", null,"Fruit", 2.75, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a4));

        addOrderProduct("Tomato",null, "Vegetable", 2.00, "TL", "kg", 1551210240120L, true, getDrawableAsByteArray(R.drawable.a14));
        addOrderProduct("Cucumber", null,"Vegetable", 2.25, "TL", "kg", 1551311240120L, true, getDrawableAsByteArray(R.drawable.a11));
        addOrderProduct("Potato", null,"Vegetable", 2.50, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a31));
        addOrderProduct("Carrot", null,"Vegetable", 2.75, "TL", "kg", 1551319040120L, true, getDrawableAsByteArray(R.drawable.a12));
        addOrderProduct("Pepper", null,"Vegetable", 3.00, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a13));

        addOrderProduct("Terderloin", null, "Meat", 10.00, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a32));
        addOrderProduct("Entrecote", null,"Meat", 10.25, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a33));
        addOrderProduct("Salami", "Pinar","Meat", 10.50, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a34));
        addOrderProduct("Sausage","Pinar", "Meat", 10.75, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a35));
        addOrderProduct("Salami", "Namet","Meat", 11.00, "TL", "piece", 1551317280120L, true, getDrawableAsByteArray(R.drawable.namet_salami));
        addOrderProduct("Sausage", "Namet","Meat", 11.25, "TL", "piece", 1551318940120L, true, getDrawableAsByteArray(R.drawable.namet_sausage));

        addOrderProduct("Pepsi Cola", "Pepsi","Drink", 3.00, "TL", "piece", 1551414240120L, true, getDrawableAsByteArray(R.drawable.a21));
        addOrderProduct("Fanta", null,"Drink", 3.25, "TL", "piece", 1551413260120L, true, getDrawableAsByteArray(R.drawable.a16));
        addOrderProduct("Soda", "Beypazari","Drink", 3.50, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a26));
        addOrderProduct("Sprite",null, "Drink", 3.75, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a17));
        addOrderProduct("Juice","SEK", "Drink", 4.00, "TL", "piece", 1551412200120L, true, getDrawableAsByteArray(R.drawable.a24));
        addOrderProduct("Juice","Cappy", "Drink", 4.25, "TL", "piece", 1551411540120L, true, getDrawableAsByteArray(R.drawable.cappy_juice));

        addOrderProduct("Hazelnut", null,"Nut", 15.00, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a36));
        addOrderProduct("Peanut", null,"Nut", 15.25, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a37));
        addOrderProduct("Walnut",null, "Nut", 15.50, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.walnut));

        addOrderProduct("Red Pepper Flakes", "Bagdat","Spice", 1.00, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.red_pepper_flakes));
        addOrderProduct("Coconut","Diyar", "Spice", 1.25, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a38));
        addOrderProduct("Tyhme","Bagdat", "Spice", 1.50, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a39));
        addOrderProduct("Mint", "Bagdat","Spice", 1.75, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a40));

        addOrderProduct("Hanımeller","Ulker", "Junk Food", 5.00, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a41));
        addOrderProduct("Ruffles", null,"Junk Food", 5.25, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a42));
        addOrderProduct("Rocco", null,"Junk Food", 5.50, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a43));
        addOrderProduct("Canga", "Eti","Junk Food", 5.75, "TL", "piece", 1551512040120L, true, getDrawableAsByteArray(R.drawable.a44));
        addOrderProduct("Toblerone", null,"Junk Food", 6.00, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a45));
        addOrderProduct("Toffie",null, "Junk Food", 6.25, "TL", "piece", 1551510040120L, true, getDrawableAsByteArray(R.drawable.a46));

        addOrderProduct("Shampoo","H&S", "Cleaning", 7.00, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a47));
        addOrderProduct("Shampoo", "İpek","Cleaning", 7.25, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.ipek));
        addOrderProduct("Soap Blackberry","Hobby ", "Cleaning", 7.50, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.hobby_blackberry));
        addOrderProduct("Soap Orchide","Hobby ", "Cleaning", 7.75, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.hobby_orchide));
        addOrderProduct("Toilet Paper","Papia", "Cleaning", 8.00, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.toilet_paper_papia));
        addOrderProduct("Toilet Paper", "Solo","Cleaning", 8.25, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a49));
    }

    public void implementExampleDatabase2() {    // ORNEK BIR DATABASE OLUSTURMAK ICIN CAGRILIYOR.
        DatabaseHelper.getInstance(context).getWritableDatabase().delete("PRODUCT", null,null);
        DatabaseHelper.getInstance(context).resetAutoIncrementProduct();

        addOrderProduct("Apple", null,"Fruit", 2.00, "TL", "kg", 1551215240120L, true, getDrawableAsByteArray(R.drawable.a1));
        addOrderProduct("Orange", null,"Fruit", 2.25, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a2));
        addOrderProduct("Banana", null,"Fruit", 2.50, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a3));
        addOrderProduct("Kiwi", null,"Fruit", 2.75, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a4));

        addOrderProduct("Tomato",null, "Vegetable", 2.00, "TL", "kg", 1551210240120L, true, getDrawableAsByteArray(R.drawable.a14));
        addOrderProduct("Cucumber", null,"Vegetable", 2.25, "TL", "kg", 1551311240120L, true, getDrawableAsByteArray(R.drawable.a11));
        addOrderProduct("Potato", null,"Vegetable", 2.50, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a31));
        addOrderProduct("Carrot", null,"Vegetable", 2.75, "TL", "kg", 1551319040120L, true, getDrawableAsByteArray(R.drawable.a12));
        addOrderProduct("Pepper", null,"Vegetable", 3.00, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a13));

        addOrderProduct("Terderloin", null, "Meat", 10.00, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a32));
        addOrderProduct("Entrecote", null,"Meat", 10.25, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a33));
        addOrderProduct("Salami", "Pinar","Meat", 10.50, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a34));
        addOrderProduct("Sausage","Pinar", "Meat", 10.75, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a35));
        addOrderProduct("Salami", "Namet","Meat", 11.00, "TL", "piece", 1551317280120L, true, getDrawableAsByteArray(R.drawable.namet_salami));
        addOrderProduct("Sausage", "Namet","Meat", 11.25, "TL", "piece", 1551318940120L, true, getDrawableAsByteArray(R.drawable.namet_sausage));

        addOrderProduct("Pepsi Cola", "Pepsi","Drink", 3.00, "TL", "piece", 1551414240120L, true, getDrawableAsByteArray(R.drawable.a21));
        addOrderProduct("Fanta", null,"Drink", 3.25, "TL", "piece", 1551413260120L, true, getDrawableAsByteArray(R.drawable.a16));
        addOrderProduct("Soda", "Beypazari","Drink", 3.50, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a26));
        addOrderProduct("Sprite",null, "Drink", 3.75, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a17));
        addOrderProduct("Juice","SEK", "Drink", 4.00, "TL", "piece", 1551412200120L, true, getDrawableAsByteArray(R.drawable.a24));
        addOrderProduct("Juice","Cappy", "Drink", 4.25, "TL", "piece", 1551411540120L, true, getDrawableAsByteArray(R.drawable.cappy_juice));

        addOrderProduct("Hazelnut", null,"Nut", 15.00, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a36));
        addOrderProduct("Peanut", null,"Nut", 15.25, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a37));
        addOrderProduct("Walnut",null, "Nut", 15.50, "TL", "kg", 1551615240120L, false, getDrawableAsByteArray(R.drawable.walnut));

        addOrderProduct("Red Pepper Flakes", "Bagdat","Spice", 1.00, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.red_pepper_flakes));
        addOrderProduct("Coconut","Diyar", "Spice", 1.25, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a38));
        addOrderProduct("Tyhme","Bagdat", "Spice", 1.50, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a39));
        addOrderProduct("Mint", "Bagdat","Spice", 1.75, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a40));

        addOrderProduct("Hanımeller","Ulker", "Junk Food", 5.00, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a41));
        addOrderProduct("Ruffles", null,"Junk Food", 5.25, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a42));
        addOrderProduct("Rocco", null,"Junk Food", 5.50, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a43));
        addOrderProduct("Canga", "Eti","Junk Food", 5.75, "TL", "piece", 1551512040120L, true, getDrawableAsByteArray(R.drawable.a44));
        addOrderProduct("Toblerone", null,"Junk Food", 6.00, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a45));
        addOrderProduct("Toffie",null, "Junk Food", 6.25, "TL", "piece", 1551510040120L, true, getDrawableAsByteArray(R.drawable.a46));

        addOrderProduct("Shampoo","H&S", "Cleaning", 7.00, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a47));
        addOrderProduct("Shampoo", "İpek","Cleaning", 7.25, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.ipek));
        addOrderProduct("Soap Blackberry","Hobby ", "Cleaning", 7.50, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.hobby_blackberry));
        addOrderProduct("Soap Orchide","Hobby ", "Cleaning", 7.75, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.hobby_orchide));
        addOrderProduct("Toilet Paper","Papia", "Cleaning", 8.00, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.toilet_paper_papia));
        addOrderProduct("Toilet Paper", "Solo","Cleaning", 8.25, "TL", "piece", 1551615240120L, false, getDrawableAsByteArray(R.drawable.a49));
    }

    public byte[] getDrawableAsByteArray(int drawable) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), drawable);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    private Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

}
