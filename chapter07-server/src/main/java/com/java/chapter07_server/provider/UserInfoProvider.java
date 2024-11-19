package com.java.chapter07_server.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.java.chapter07_server.database.UserDBHelper;

public class UserInfoProvider extends ContentProvider {

    private UserDBHelper dbHelper;

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //content://com.java.chapter07_server.provider.UserInfoProvider/user
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.d("ldd", "UserInfoProvider insert");
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert(UserDBHelper.TABLE_NAME,null,values);
        // TODO: Implement this to handle requests to insert a new row.
        return uri;
    }

    @Override
    public boolean onCreate() {
        Log.d("ldd", "UserInfoProvider onCreate");
        dbHelper=UserDBHelper.getInstance(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.d("ldd", "UserInfoProvider query");
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.query(UserDBHelper.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}