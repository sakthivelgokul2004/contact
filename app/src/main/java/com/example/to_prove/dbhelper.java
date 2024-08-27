package com.example.to_prove;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    public  static  final  String DB_name="contacts";

    public static  final  int db_version=4  ;
    public static  final String table_name="pname";
    public static  final String ID="_id";
    public static  final String getDB_name="name";
    public static  final String phone_no="phone_no";


    public  static final String query="CREATE TABLE "+table_name+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT ," +getDB_name+"  TEXT,"+phone_no+" TEXT "+");";

    public dbhelper(@Nullable Context context) {
        super(context, DB_name, null, db_version);
    }


    //public dbhelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
  //      super(context, DB_name, null, db_version);
    //}
    /*String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DURATION_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + TRACKS_COL + " TEXT)";*/

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_name);
    onCreate(sqLiteDatabase);
    }
}
