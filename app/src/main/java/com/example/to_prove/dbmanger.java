package com.example.to_prove;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class dbmanger  {

    private dbhelper dbhelper;
    private final Context context ;
    private SQLiteDatabase db;


    public dbmanger(Context context) {
        this.context = context;
    }

    public void open () throws SQLException
    {
      this.dbhelper=new dbhelper(context);
       this.db=dbhelper.getWritableDatabase();
    }
    public void close(){
        db.close();
}
    public  void  insert(String str,String i){
        ContentValues content =new ContentValues();
        content.put(dbhelper.getDB_name,str);
        content.put(dbhelper.phone_no,i);
        db.insert(dbhelper.table_name,null,content);
    }
public void delete(int id){
        db.delete(dbhelper.table_name, ""+id,null);
}

    /*// we have created a new method for reading all the courses.
public ArrayList<CourseModal> readCourses()
{
	// on below line we are creating a
	// database for reading our database.
	SQLiteDatabase db = this.getReadableDatabase();

	// on below line we are creating a cursor with query to
	// read data from database.
	Cursor cursorCourses
		= db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

	// on below line we are creating a new array list.
	ArrayList<CourseModal> courseModalArrayList
		= new ArrayList<>();

	// moving our cursor to first position.
	if (cursorCourses.moveToFirst()) {
		do {
			// on below line we are adding the data from
			// cursor to our array list.
			courseModalArrayList.add(new CourseModal(
				cursorCourses.getString(1),
				cursorCourses.getString(4),
				cursorCourses.getString(2),
				cursorCourses.getString(3)));
		} while (cursorCourses.moveToNext());
		// moving our cursor to next.
	}
	// at last closing our cursor
	// and returning our array list.
	cursorCourses.close();
	return courseModalArrayList;
}
*/
public ArrayList<recylehelp> read(){
    Cursor read=db.rawQuery(" SELECT * FROM " + dbhelper.table_name,null);
    ArrayList<recylehelp> readdb=new ArrayList<>();
    if (read.moveToFirst()){
        do {
            readdb.add(new recylehelp(read.getInt(0),read.getString(1),read.getString(2)));
        }while (read.moveToNext());
    }
    read.close();
   return  readdb;
}
public  void  dbrest(){
    db.close();
    context.deleteDatabase(dbhelper.table_name);
}

}



class recylehelp{
    private String stname;
    private String stphone;
    private int id;
    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getStphone() {
        return stphone;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public void setStphone(String stphone) {
        this.stphone = stphone;
    }

    public recylehelp(int anInt, String stname, String stphone) {
        this.stname=stname;
        this.stphone=stphone;
        this.id=anInt;

    }
}