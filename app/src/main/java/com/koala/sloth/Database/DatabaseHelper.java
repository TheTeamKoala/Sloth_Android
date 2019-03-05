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
		String CREATE_TABLE_ORDER_PRODUCT = "CREATE TABLE ORDER_PRODUCT (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR, CATEGORY VARCHAR, PRICE DOUBLE, PRICE_UNIT VARCHAR, PHYSICAL_UNIT VARCHAR, PICTURE BLOB)";
        String CREATE_TABLE_HISTORY_PRODUCT = "CREATE TABLE HISTORY_PRODUCT (ID INTEGER PRIMARY KEY AUTOINCREMENT, PRODUCT VARCHAR, PRICE DOUBLE, PRICE_UNIT VARCHAR, PHYSICAL_UNIT VARCHAR, QUANTITY INTEGER, TIME LONG)";

        db.execSQL(CREATE_TABLE_ORDER_PRODUCT);
		db.execSQL(CREATE_TABLE_HISTORY_PRODUCT);
	}
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}


}