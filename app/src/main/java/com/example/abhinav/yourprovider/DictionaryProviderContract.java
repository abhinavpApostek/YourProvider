package com.example.abhinav.yourprovider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Abhinav on 9/26/2017.
 */

public class DictionaryProviderContract {

    public static final String AUTHORITY ="com.example.abhinav.yourprovider.dictionaryprovider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static final class WordsTable implements BaseColumns{
        public static final String TABLE_NAME="wordstable";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(DictionaryProviderContract.CONTENT_URI,"words");
        public static  final String WORDS="words";
        public static final String[] PROJECTION_ALL ={_ID,WORDS};
    }
}
