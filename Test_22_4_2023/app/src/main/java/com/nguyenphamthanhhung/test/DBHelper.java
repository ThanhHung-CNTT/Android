package com.nguyenphamthanhhung.test;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "product.sqlite";
    public static final int DB_VERSION = 1;
    public static final String TBL_NAME = "Tour";

    public static final String COL_ID = "Id";
    public static final String COL_TEN = "Tên";
    public static final String COL_MOTA = "Mô tả";
    public static final String COL_SOLUONG = "Số lượng";
    public static final String COL_LICHTRINH = "Lịch trình";
    public static final String COL_GIA = "Giá";


    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_TEN + " VARCHAR(50), " + COL_MOTA + "TEXT, " + COL_SOLUONG + "INTERGER, " + COL_LICHTRINH + "TEXT, " + COL_GIA + "FLOAT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
    }

    public void execSql(String sql) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    public Cursor queryData(String sql) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);

    }

    public int getNumberOfRows(String sql) {
        Cursor c = queryData(sql);
        int numbOfRows = c.getCount();
        c.close();
        return numbOfRows;
    }

    public void createSampleData() {
        int numb = getNumberOfRows("SELECT * FROM " + TBL_NAME);
        if (numb == 0) {
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Tour Vung tau', 'Tham quan biển', 2, '1 ngày', 21000)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Tour Ninh Thuận', 'Tham quan du lịch biển và cảnh quan', 4, '1 ngày 1 đêm', 500000)");
            execSql("INSERT INTO " + TBL_NAME + " VALUES (null, 'Tour Sài Gòn', 'Tham gia đại hội thể thao tàn quốc', 10, '2 nagỳ 1 đêm', 3000000)");
        }
    }
}
