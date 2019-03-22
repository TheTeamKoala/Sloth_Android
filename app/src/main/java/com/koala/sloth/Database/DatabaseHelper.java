package com.koala.sloth.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "sloth_database";

	private static DatabaseHelper databaseHelper = null;



    public static DatabaseHelper getInstance(Context context) {
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(context);
        }

        return databaseHelper;
    }
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE_PRODUCT = "CREATE TABLE PRODUCT (" +
				"ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"NAME VARCHAR, " +
				"BRAND VARCHAR, " +
				"CATEGORY VARCHAR, " +
				"PRICE FLOAT, " +
				"PRICE_UNIT VARCHAR, " +
				"PHYSICAL_UNIT VARCHAR, " +
				"FIRST_DATE LONG, " +
				"IN_FRIDGE INTEGER, " +
				"PICTURE BLOB)";

        String CREATE_TABLE_ORDER = "CREATE TABLE ORDERS (" +
				"ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"PRODUCT_ID INTEGER, " +
				"QUANTITY INTEGER, " +
				"DATE LONG)";

        db.execSQL(CREATE_TABLE_PRODUCT);
		db.execSQL(CREATE_TABLE_ORDER);
	}
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

	public void resetAutoIncrementProduct() {
		String RESET_PRODUCT = "UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='PRODUCT'";
		getWritableDatabase().execSQL(RESET_PRODUCT);
	}

	public void resetAutoIncrementOrders() {
		String RESET_ORDERS = "UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='ORDERS'";
		getWritableDatabase().execSQL(RESET_ORDERS);
	}

}