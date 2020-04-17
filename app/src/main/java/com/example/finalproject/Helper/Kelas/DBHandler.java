package com.example.finalproject.Helper.Kelas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.finalproject.Model.Kelas;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_finalproject";
    private static final String TABLE_KELAS = "kelas";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAMA_KELAS = "nama_kelas";
    private static final String COLUMN_KOMPETENSI = "komptensi";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override //Untuk buat database
    public void onCreate(SQLiteDatabase db) {
        String CREATE_KELAS_TABLE = "CREATE TABLE " + TABLE_KELAS + "("
                + COLUMN_ID + "INTEGER PRIMARY KEY, "
                + COLUMN_NAMA_KELAS + " TEXT, "
                + COLUMN_KOMPETENSI + " TEXT" + ")";
        db.execSQL(CREATE_KELAS_TABLE);
    }

    @Override //Untuk cek database
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KELAS);
        onCreate(db);
    }

    public void tambahKelas (Kelas kelas) { //Untuk tambah data kelas
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(COLUMN_NAMA_KELAS, kelas.getNama_kelas());
        val.put(COLUMN_KOMPETENSI, kelas.getKompetensi());

        db.insert(TABLE_KELAS, null, val);
        db.close();
    }

    public Kelas getKelas(int id_kelas) {//Untuk ambil 1 data
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cur = db.query(TABLE_KELAS, new String[]{COLUMN_ID, COLUMN_NAMA_KELAS, COLUMN_KOMPETENSI},
                     COLUMN_ID + "=?", new String[]{String.valueOf(id_kelas)}, null, null, null, null);
        if (cur != null)
            cur.moveToFirst();

        Kelas kelas = new Kelas(cur.getString( 1), cur.getString(2));
        return kelas;
    }

    public List<Kelas> getSemuaKelas() { //Untuk ambil semua data kelas
        List<Kelas> kelasList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_KELAS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery(selectQuery, null);

        if (cur.moveToFirst()) {
            do {
                Kelas kelas = new Kelas(cur.getString(1), cur.getString(2));
                kelasList.add(kelas);
            } while (cur.moveToNext());
        }
        return kelasList;
    }

    public int getKelasCount() { //Untuk menghitung jumlah data
        String countQuery = "SELECT * FROM " + TABLE_KELAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery(countQuery, null);
        cur.close();
        return cur.getCount();
    }

    public int update(Kelas kelas) { //Untuk update data kelas
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(COLUMN_NAMA_KELAS, kelas.getNama_kelas());
        val.put(COLUMN_KOMPETENSI, kelas.getKompetensi());

        return db.update(TABLE_KELAS, val, COLUMN_ID + " = ?",
                    new String[]{String.valueOf(kelas.getId())});
    }

    public void delete(Kelas kelas) {
        SQLiteDatabase db = getWritableDatabase();

        String whereClause = COLUMN_NAMA_KELAS+"='" + COLUMN_NAMA_KELAS +"'";
        db.delete(TABLE_KELAS, whereClause, null);
    }

}
