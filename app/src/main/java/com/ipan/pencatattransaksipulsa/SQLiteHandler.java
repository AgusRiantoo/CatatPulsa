package com.ipan.pencatattransaksipulsa;

/**
 * Created by HP on 17-Sep-16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLiteHandler extends SQLiteOpenHelper {

    private static final String TAG = SQLiteHandler.class.getSimpleName();


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "transaksiPulsa";

    private static final String TABLE_PULSA = "pulsa";
    private static final String KEY_ID = "id";
    private static final String KEY_KODE = "kode";
    private static final String KEY_JENIS = "jenis";
    private static final String KEY_HARGA = "harga";
    private static final String KEY_HARGA_JUAL = "hargajual";


    private static final String TABLE_TRANSAKSI = "transaksi";
    private static final String KEY_TGL = "tanggal";

    private static final String TABLE_SALDO = "saldo";
    private static final String KEY_TOTAL_SALDO = "totalsaldo";
    private static final String KEY_KEUNTUNGAN = "keutungan";


    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_PULSA = "CREATE TABLE " + TABLE_PULSA + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_KODE + " TEXT,"
                + KEY_JENIS + " TEXT," + KEY_HARGA + " TEXT,"
                + KEY_HARGA_JUAL + " TEXT)";

        String CREATE_TABLE_TRANSAKSI = "CREATE TABLE " + TABLE_TRANSAKSI + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TGL + " TEXT,"
                + KEY_JENIS + " TEXT," + KEY_HARGA + " TEXT)";

        String CREATE_TABLE_SALDO = "CREATE TABLE " + TABLE_SALDO + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TOTAL_SALDO + " TEXT,"
                + KEY_KEUNTUNGAN + " TEXT)";


        db.execSQL(CREATE_TABLE_TRANSAKSI);

        db.execSQL(CREATE_TABLE_PULSA);
        //Pulsa Telkomsel 5000
        ContentValues value = new ContentValues();
        value.put(KEY_KODE, "SL5");
        value.put(KEY_JENIS, "Telkomsel 5000");
        value.put(KEY_HARGA, 5650);
        value.put(KEY_HARGA_JUAL, 7000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Telkomsel 10000
        value.put(KEY_KODE, "SL10");
        value.put(KEY_JENIS, "Telkomsel 10000");
        value.put(KEY_HARGA, 10650);
        value.put(KEY_HARGA_JUAL, 12000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Telkomsel 20000
        value.put(KEY_KODE, "SL20");
        value.put(KEY_JENIS, "Telkomsel 20000");
        value.put(KEY_HARGA, 20200);
        value.put(KEY_HARGA_JUAL, 22000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Telkomsel 25000
        value.put(KEY_KODE, "SL25");
        value.put(KEY_JENIS, "Telkomsel 25000");
        value.put(KEY_HARGA, 25000);
        value.put(KEY_HARGA_JUAL, 27000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Telkomsel 50000
        value.put(KEY_KODE, "SL50");
        value.put(KEY_JENIS, "Telkomsel 50000");
        value.put(KEY_HARGA, 49200);
        value.put(KEY_HARGA_JUAL, 52000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Telkomsel 100000
        value.put(KEY_KODE, "SL20");
        value.put(KEY_JENIS, "Telkomsel 100000");
        value.put(KEY_HARGA, 97100);
        value.put(KEY_HARGA_JUAL, 102000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Indosat 5000
        value.put(KEY_KODE, "IL5");
        value.put(KEY_JENIS, "Indosat 5000");
        value.put(KEY_HARGA, 5600);
        value.put(KEY_HARGA_JUAL, 7000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Indosat 10000
        value.put(KEY_KODE, "IL10");
        value.put(KEY_JENIS, "Indosat 10000");
        value.put(KEY_HARGA, 10600);
        value.put(KEY_HARGA_JUAL, 12000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Indosat 25000
        value.put(KEY_KODE, "IL25");
        value.put(KEY_JENIS, "Indosat 25000");
        value.put(KEY_HARGA, 25200);
        value.put(KEY_HARGA_JUAL, 27000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Indosat 50000
        value.put(KEY_KODE, "IL50");
        value.put(KEY_JENIS, "Indosat 50000");
        value.put(KEY_HARGA, 49500);
        value.put(KEY_HARGA_JUAL, 52000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Indosat 100000
        value.put(KEY_KODE, "IL100");
        value.put(KEY_JENIS, "Indosat 100000");
        value.put(KEY_HARGA, 98500);
        value.put(KEY_HARGA_JUAL, 102000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa XL 5000
        value.put(KEY_KODE, "XL5");
        value.put(KEY_JENIS, "XL 5000");
        value.put(KEY_HARGA, 5650);
        value.put(KEY_HARGA_JUAL, 7000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa XL 10000
        value.put(KEY_KODE, "XL10");
        value.put(KEY_JENIS, "XL 10000");
        value.put(KEY_HARGA, 10650);
        value.put(KEY_HARGA_JUAL, 12000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa XL 25000
        value.put(KEY_KODE, "XL25");
        value.put(KEY_JENIS, "XL 25000");
        value.put(KEY_HARGA, 25150);
        value.put(KEY_HARGA_JUAL, 27000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa XL 50000
        value.put(KEY_KODE, "XL50");
        value.put(KEY_JENIS, "XL 50000");
        value.put(KEY_HARGA, 50100);
        value.put(KEY_HARGA_JUAL, 52000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa XL 100000
        value.put(KEY_KODE, "XL100");
        value.put(KEY_JENIS, "XL 100000");
        value.put(KEY_HARGA, 99000);
        value.put(KEY_HARGA_JUAL, 102000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Axis 5000
        value.put(KEY_KODE, "AX5");
        value.put(KEY_JENIS, "Axis 5000");
        value.put(KEY_HARGA, 5650);
        value.put(KEY_HARGA_JUAL, 7000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Axis 10000
        value.put(KEY_KODE, "AX10");
        value.put(KEY_JENIS, "Axis 10000");
        value.put(KEY_HARGA, 10650);
        value.put(KEY_HARGA_JUAL, 12000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Axis 25000
        value.put(KEY_KODE, "AX25");
        value.put(KEY_JENIS, "Axis 25000");
        value.put(KEY_HARGA, 24800);
        value.put(KEY_HARGA_JUAL, 27000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa XL 50000
        value.put(KEY_KODE, "AX50");
        value.put(KEY_JENIS, "Axis 50000");
        value.put(KEY_HARGA, 49600);
        value.put(KEY_HARGA_JUAL, 52000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa XL 100000
        value.put(KEY_KODE, "AX100");
        value.put(KEY_JENIS, "Axis 100000");
        value.put(KEY_HARGA, 99100);
        value.put(KEY_HARGA_JUAL, 102000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Tri 1000
        value.put(KEY_KODE, "T1");
        value.put(KEY_JENIS, "Tri 1000");
        value.put(KEY_HARGA, 1050);
        value.put(KEY_HARGA_JUAL, 2000);

        //Pulsa Tri 5000
        value.put(KEY_KODE, "T5");
        value.put(KEY_JENIS, "Tri 5000");
        value.put(KEY_HARGA, 4975);
        value.put(KEY_HARGA_JUAL, 7000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Tri 10000
        value.put(KEY_KODE, "T10");
        value.put(KEY_JENIS, "Tri 10000");
        value.put(KEY_HARGA, 9900);
        value.put(KEY_HARGA_JUAL, 12000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Tri 20000
        value.put(KEY_KODE, "T20");
        value.put(KEY_JENIS, "Tri 20000");
        value.put(KEY_HARGA, 19700);
        value.put(KEY_HARGA_JUAL, 22000);
        db.insert(TABLE_PULSA, null, value);


        //Pulsa Tri 25000
        value.put(KEY_KODE, "T25");
        value.put(KEY_JENIS, "Tri 25000");
        value.put(KEY_HARGA, 24700);
        value.put(KEY_HARGA_JUAL, 27000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Tri 30000
        value.put(KEY_KODE, "T30");
        value.put(KEY_JENIS, "Tri 30000");
        value.put(KEY_HARGA, 29600);
        value.put(KEY_HARGA_JUAL, 32000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Tri 50000
        value.put(KEY_KODE, "T50");
        value.put(KEY_JENIS, "Tri 50000");
        value.put(KEY_HARGA, 49250);
        value.put(KEY_HARGA_JUAL, 52000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Tri 100000
        value.put(KEY_KODE, "T100");
        value.put(KEY_JENIS, "Tri 100000");
        value.put(KEY_HARGA, 98450);
        value.put(KEY_HARGA_JUAL, 102000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Smartfren 5000
        value.put(KEY_KODE, "SM5");
        value.put(KEY_JENIS, "Smartfren 5000");
        value.put(KEY_HARGA, 5150);
        value.put(KEY_HARGA_JUAL, 7000);
        db.insert(TABLE_PULSA, null, value);


        //Pulsa Smartfren 10000
        value.put(KEY_KODE, "SM10");
        value.put(KEY_JENIS, "Smartfren 10000");
        value.put(KEY_HARGA, 10150);
        value.put(KEY_HARGA_JUAL, 12000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Smartfren 20000
        value.put(KEY_KODE, "SM20");
        value.put(KEY_JENIS, "Smartfren 20000");
        value.put(KEY_HARGA, 20150);
        value.put(KEY_HARGA_JUAL, 22000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Smartfren 25000
        value.put(KEY_KODE, "SM25");
        value.put(KEY_JENIS, "Smartfren 25000");
        value.put(KEY_HARGA, 25150);
        value.put(KEY_HARGA_JUAL, 27000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Smartfren 30000
        value.put(KEY_KODE, "SM30");
        value.put(KEY_JENIS, "Smartfren 30000");
        value.put(KEY_HARGA, 30050);
        value.put(KEY_HARGA_JUAL, 32000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Smartfren 50000
        value.put(KEY_KODE, "SM50");
        value.put(KEY_JENIS, "Smartfren 50000");
        value.put(KEY_HARGA, 49200);
        value.put(KEY_HARGA_JUAL, 52000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Smartfren 60000
        value.put(KEY_KODE, "SM60");
        value.put(KEY_JENIS, "Smartfren 60000");
        value.put(KEY_HARGA, 59300);
        value.put(KEY_HARGA_JUAL, 62000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Smartfren 100000
        value.put(KEY_KODE, "SM100");
        value.put(KEY_JENIS, "Smartfren 100000");
        value.put(KEY_HARGA, 97000);
        value.put(KEY_HARGA_JUAL, 102000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Bolt 25000
        value.put(KEY_KODE, "BO25");
        value.put(KEY_JENIS, "Bolt 25000");
        value.put(KEY_HARGA, 24500);
        value.put(KEY_HARGA_JUAL, 27000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Bolt 50000
        value.put(KEY_KODE, "BO50");
        value.put(KEY_JENIS, "Bolt 50000");
        value.put(KEY_HARGA, 48900);
        value.put(KEY_HARGA_JUAL, 52000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Bolt 100000
        value.put(KEY_KODE, "BO100");
        value.put(KEY_JENIS, "Bolt 100000");
        value.put(KEY_HARGA, 97900);
        value.put(KEY_HARGA_JUAL, 102000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Bolt 150000
        value.put(KEY_KODE, "BO150");
        value.put(KEY_JENIS, "Bolt 150000");
        value.put(KEY_HARGA, 145900);
        value.put(KEY_HARGA_JUAL, 152000);
        db.insert(TABLE_PULSA, null, value);

        //Pulsa Bolt 200000
        value.put(KEY_KODE, "BO200");
        value.put(KEY_JENIS, "Bolt 200000");
        value.put(KEY_HARGA, 194900);
        value.put(KEY_HARGA_JUAL, 202000);
        db.insert(TABLE_PULSA, null, value);
        Log.e(TAG, "tables PULSA created");


        ContentValues value2 = new ContentValues();

        db.execSQL(CREATE_TABLE_SALDO);
        value2.put(KEY_TOTAL_SALDO, "0");
        value2.put(KEY_KEUNTUNGAN, "0");
        db.insert(TABLE_SALDO, null, value2);
        Log.e(TAG, "tables SALDO created");

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PULSA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSAKSI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SALDO);
        onCreate(db);
    }

    /**
     * Storing user details in database
     */
    public void addTransaksi(String tgl, String jenis, String harga, int saldoakhir, int keuntungan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TGL, tgl); // Name
        values.put(KEY_JENIS, jenis); // Email
        values.put(KEY_HARGA, harga); // Token
        // Inserting Row
        long id = db.insert(TABLE_TRANSAKSI, null, values);

        ContentValues saldo = new ContentValues();
        saldo.put(KEY_TOTAL_SALDO,saldoakhir);
        saldo.put(KEY_KEUNTUNGAN,keuntungan);
        db.update(TABLE_SALDO, saldo, KEY_ID + "= ?", new String[]{"1"});

        db.close(); // Closing database connection
        Log.d(TAG, "New user inserted into sqlite: " + id);
    }

    public HashMap<String, String> showHarga(String jenis) {
        HashMap<String, String> user = new HashMap<>();
        String selectQuery = "SELECT * FROM " + TABLE_PULSA + " WHERE " + KEY_JENIS + "='" + jenis + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("kode", cursor.getString(1));
            user.put("harga", cursor.getString(3));
            user.put("hargajual", cursor.getString(4));
        }
        cursor.close();
        db.close();
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

        return user;
    }

    public ArrayList<ArrayList<Object>> showPulsa() {

        ArrayList<ArrayList<Object>> dataArray = new
                ArrayList<ArrayList<Object>>();

        try {
            String selectQuery = "SELECT  * FROM " + TABLE_PULSA;

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            // Move to first row
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    ArrayList<Object> dataList = new ArrayList<Object>();
                    dataList.add(cursor.getString(0));
                    dataList.add(cursor.getString(1));
                    dataList.add(cursor.getString(2));
                    dataList.add(cursor.getString(3));
                    dataList.add(cursor.getString(4));
                    dataArray.add(dataList);

                } while (cursor.moveToNext());
                db.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.e("fail","gagal ambil data");
        }
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + dataArray.toString());

        return dataArray;
    }


    public ArrayList<ArrayList<Object>> showTransaksi() {

        ArrayList<ArrayList<Object>> dataArray = new
                ArrayList<ArrayList<Object>>();

        try {
            String selectQuery = "SELECT  * FROM " + TABLE_TRANSAKSI;

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            // Move to first row
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                do {
                    ArrayList<Object> dataList = new ArrayList<Object>();
                    dataList.add(cursor.getString(0));
                    dataList.add(cursor.getString(1));
                    dataList.add(cursor.getString(2));
                    dataList.add(cursor.getString(3));
                    dataArray.add(dataList);
                } while (cursor.moveToNext());
                db.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.e("fail","gagal ambil data");
        }
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + dataArray.toString());

        return dataArray;
    }

    public HashMap<String, String> showSaldo() {
        HashMap<String, String> user = new HashMap<>();
        String selectQuery = "SELECT  * FROM " + TABLE_SALDO;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("totalsaldo", cursor.getString(1));
            user.put("keuntungan", cursor.getString(2));
        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

        return user;
    }

    public void updatePulsa(String kode,String harga, String hargajual) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_HARGA, harga);
        values.put(KEY_HARGA_JUAL, hargajual);
        db.update(TABLE_PULSA, values, KEY_KODE + "= ?", new String[]{String.valueOf(kode)});

        db.close(); // Closing database connection
    }

    public void updateSaldo(String totalsaldo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TOTAL_SALDO, totalsaldo);
        // Inserting Row
        long id = db.update(TABLE_SALDO, values, KEY_ID + "= ?", new String[]{String.valueOf(1)});

        db.close(); // Closing database connection
        Log.d(TAG, "Update into sqlite: " + id);
    }


}
