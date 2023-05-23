package com.example.sqlite_ex2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import kotlinx.coroutines.flow.AbstractFlow;

public class MyDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "product.sqlite";
    public static final int DB_VERSION = 1;
    public static final String TBL_NAME = "Product";

    public static final String COL_CODE = "ProductCode";
    public static final String COL_NAME = "ProductName";
    public static final String COL_PRICE = "ProductPrice";

    public MyDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " ( " + COL_CODE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " VARCHAR(50), " + COL_PRICE + " REAL)";
        sqLiteDatabase.execSQL(sql);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TBL_NAME);
    }
    public  void execSql(String sql){
        SQLiteDatabase sqLiteDatabase =  getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    public Cursor queryData(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);
    }

    public int getNumberOfRows(String sql){
        Cursor c = queryData("SELECT * FROM " + TBL_NAME);
        int numbOfRows = c.getCount();
        c.close();
        return numbOfRows;
    }

    public void createSampleData(){
        int numb = getNumberOfRows("SELECT * FROM "+ TBL_NAME);
        if(numb == 0){
            execSql("INSERT INTO "+ TBL_NAME +" VALUES (null, 'Tiger', 19000)");
            execSql("INSERT INTO "+ TBL_NAME +" VALUES (null, 'Heineken', 19000)");
            execSql("INSERT INTO "+ TBL_NAME +" VALUES (null, 'Sapporo', 19000)");
            execSql("INSERT INTO "+ TBL_NAME +" VALUES (null, 'SaiGon', 19000)");
        }
    }

}
