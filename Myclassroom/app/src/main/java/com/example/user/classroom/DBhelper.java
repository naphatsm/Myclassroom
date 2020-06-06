package com.example.user.classroom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myDB.db";
    public static final String TABLE_NAME = "nametable";
    public static final String TABLE_NAME2 = "datatable";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ID2 = "id2";
    public static final String COLUMN_NAME ="nameuser";
    public static final String COLUMN_CLASSNAME ="classname";
    public static final String COLUMN_THEACHERNAME = "teachername";
    public static final String COLUMN_ROOMNO = "roomno";
    public static final String COLUMN_DATEMIDTERM ="datemid";
    public static final String COLUMN_TIMEMIDTERM = "timemid";
    public static final String COLUMN_ROOMNOMIDTERM = "roommid";
    public static final String COLUMN_DATEFINAL ="datefin";
    public static final String COLUMN_TIMEFINAL = "timefin";
    public static final String COLUMN_ROOMNOFINAL = "roomfin";
    public static final String COLUMN_DAY ="day";
    public static final String COLUMN_STARTH ="startH";
    public static final String COLUMN_STARTM ="startM";
    public static final String COLUMN_ENDH ="endH";
    public static final String COLUMN_ENDM ="endM";
    private static final String query = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"  +
            COLUMN_NAME + " TEXT" + " );";
    private static final String query2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + " (" +
            COLUMN_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            COLUMN_CLASSNAME + " TEXT, " +
            COLUMN_THEACHERNAME + " TEXT, " +
            COLUMN_ROOMNO + " TEXT, " +
            COLUMN_DATEMIDTERM + " TEXT," +
            COLUMN_TIMEMIDTERM + " TEXT," +
            COLUMN_ROOMNOMIDTERM + " TEXT," +
            COLUMN_DATEFINAL + " TEXT," +
            COLUMN_TIMEFINAL + " TEXT," +
            COLUMN_ROOMNOFINAL + " TEXT," +
            COLUMN_DAY + " TEXT," +
            COLUMN_STARTH + " TEXT," +
            COLUMN_STARTM + " TEXT," +
            COLUMN_ENDH + " TEXT," +
            COLUMN_ENDM + " TEXT " + " );";
    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }
    public boolean addName(String nameTable){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,nameTable);
        long result = db.insert(TABLE_NAME,null,values);
        if (result == -1){
            return false;
        }else {
            return true;
        }
    }
    public boolean addData(String a , String b ,String c, String d, String e ,String f, String g , String h , String j,String i,int k,
                           int l,int m, int n){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CLASSNAME,a);
        contentValues.put(COLUMN_THEACHERNAME,b);
        contentValues.put(COLUMN_ROOMNO,c);
        contentValues.put(COLUMN_DATEMIDTERM,d);
        contentValues.put(COLUMN_TIMEMIDTERM,e);
        contentValues.put(COLUMN_ROOMNOMIDTERM,f);
        contentValues.put(COLUMN_DATEFINAL,g);
        contentValues.put(COLUMN_TIMEFINAL,h);
        contentValues.put(COLUMN_ROOMNOFINAL,j);
        contentValues.put(COLUMN_DAY,i);
        contentValues.put(COLUMN_STARTH,k);
        contentValues.put(COLUMN_STARTM,l);
        contentValues.put(COLUMN_ENDH,m);
        contentValues.put(COLUMN_ENDM,n);
        long result = db.insert(TABLE_NAME2,null,contentValues);
        if (result == -1){
            return false;
        }else {
            return true;
        }
    }
    public boolean updateName(String updatename){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,updatename);
        db.update(TABLE_NAME,values," id = ?" ,new String[]{"1"});
        return  true;
    }
    public boolean updateData(String id,String updatedata,String a,String b,String c,String e,String f,String g,String h,String j,String i,int k,
                             int l,int m, int n){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID2,id);
        values.put(COLUMN_CLASSNAME,updatedata);
        values.put(COLUMN_THEACHERNAME,a);
        values.put(COLUMN_ROOMNO,b);
        values.put(COLUMN_DATEMIDTERM,c);
        values.put(COLUMN_TIMEMIDTERM,e);
        values.put(COLUMN_ROOMNOMIDTERM,f);
        values.put(COLUMN_DATEFINAL,g);
        values.put(COLUMN_TIMEFINAL,h);
        values.put(COLUMN_ROOMNOFINAL,j);
        values.put(COLUMN_DAY,i);
        values.put(COLUMN_STARTH,k);
        values.put(COLUMN_STARTM,l);
        values.put(COLUMN_ENDH,m);
        values.put(COLUMN_ENDM,n);
        db.update(TABLE_NAME2,values," id2 = ?" ,new String[] { id });
        return  true;
    }
    public Cursor getNameTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from nametable where id = " + 1,null);
        return  res;
    }
    public Cursor getDataTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from datatable ",null);
        return  res;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("datatable","id2 = ?",new String[] {id});
    }
}
