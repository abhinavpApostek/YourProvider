package com.example.abhinav.yourprovider;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Abhinav on 9/26/2017.
 */

public class ShowWordActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_layout);
        listView=(ListView)findViewById(R.id.listView);
        Cursor c=getContentResolver().query(DictionaryProviderContract.CONTENT_URI,DictionaryProviderContract.WordsTable.PROJECTION_ALL,null,null,null);
        SimpleCursorAdapter simpleCursorAdapter=new SimpleCursorAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,c,new String[]{DictionaryProviderContract.WordsTable.WORDS},new int[]{android.R.id.text1},1);
        listView.setAdapter(simpleCursorAdapter);
    }
}
