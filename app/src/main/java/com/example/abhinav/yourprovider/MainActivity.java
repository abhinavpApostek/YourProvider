package com.example.abhinav.yourprovider;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button){

            Intent intent=new Intent(this,ShowWordActivity.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.button2)
        {
            if(editText.getText().toString().trim().length()>0)
            {
                ContentValues contentValues=new ContentValues();
                contentValues.put(DictionaryProviderContract.WordsTable.WORDS,editText.getText().toString().trim());
                getContentResolver().insert(DictionaryProviderContract.CONTENT_URI,contentValues);
            }
        }
    }
}
