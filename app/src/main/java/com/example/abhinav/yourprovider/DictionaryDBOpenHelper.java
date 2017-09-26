package com.example.abhinav.yourprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abhinav on 9/26/2017.
 */

public class DictionaryDBOpenHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + DictionaryProviderContract.WordsTable.TABLE_NAME + " (" +
                    DictionaryProviderContract.WordsTable._ID + " INTEGER PRIMARY KEY," +
                    DictionaryProviderContract.WordsTable.WORDS + " TEXT)";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DictionaryDBOpenHelper.db";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " +  DictionaryProviderContract.WordsTable.TABLE_NAME;

    public DictionaryDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
