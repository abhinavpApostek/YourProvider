package com.example.abhinav.yourprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Abhinav on 9/26/2017.
 */

public class DictionaryProvider extends ContentProvider {

    private DictionaryDBOpenHelper mHelper;
    private SQLiteDatabase db;
    @Override
    public boolean onCreate() {
        mHelper=new DictionaryDBOpenHelper(getContext(),DictionaryDBOpenHelper.DATABASE_NAME,null,DictionaryDBOpenHelper.DATABASE_VERSION);

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        db=mHelper.getReadableDatabase();
        return db.query(true,DictionaryProviderContract.WordsTable.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder,null);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        db=mHelper.getWritableDatabase();
        db.insert(DictionaryProviderContract.WordsTable.TABLE_NAME,null,values);
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
