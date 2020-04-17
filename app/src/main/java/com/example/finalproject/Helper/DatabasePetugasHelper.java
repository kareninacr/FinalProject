package com.example.finalproject.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.finalproject.Model.Petugas;

import java.util.ArrayList;
import java.util.List;

public class DatabasePetugasHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION=1;
    private static final String DB_NAME="db_spp";
    private static final String TABLE_NAME="tbl_petugas";
    private static final String KEY_NAME="nama";
    private static final String KEY_USERNAME="username";
    private static final String KEY_PASSWORD="password";
    private static final String KEY_LEVEL="level";

    public DatabasePetugasHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable="Create Table "+TABLE_NAME+"("+KEY_NAME+" TEXT PRIMARY KEY, "+KEY_USERNAME+" TEXT, "+KEY_PASSWORD+" PASSWORD, "+KEY_LEVEL+" TEXT"+")";
        db.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql=("drop table if exists " +TABLE_NAME);
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Petugas petugas) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,petugas.getNama());
        values.put(KEY_USERNAME,petugas.getUsername());
        values.put(KEY_PASSWORD,petugas.getPassword());
        values.put(KEY_LEVEL,petugas.getLevel());

        db.insert(TABLE_NAME,null,values);
    }

    public List<Petugas> selectPetugasData() {
        ArrayList<Petugas> petugasList = new ArrayList<Petugas>();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {KEY_NAME, KEY_USERNAME, KEY_PASSWORD, KEY_LEVEL};

        Cursor c = db.query(TABLE_NAME,columns,null,null,null,null,null);

        while(c.moveToNext()) {
            String nama = c.getString(0);
            String username = c.getString(1);
            String password = c.getString(2);
            String level = c.getString(3);

            Petugas petugas = new Petugas();
            petugas.setNama(nama);
            petugas.setUsername(username);
            petugas.setPassword(password);
            petugas.setLevel(level);
        }
        return petugasList;
    }

    public void delete(String nama) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = KEY_NAME+"='"+nama+"'";
        db.delete(TABLE_NAME,whereClause,null);
    }

    public void update(Petugas petugas) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME,petugas.getUsername());
        values.put(KEY_PASSWORD,petugas.getPassword());
        values.put(KEY_LEVEL,petugas.getLevel());
        String whereClause = KEY_NAME+"='"+petugas.getNama()+"'";
        db.update(TABLE_NAME,values,whereClause,null);
    }
}
