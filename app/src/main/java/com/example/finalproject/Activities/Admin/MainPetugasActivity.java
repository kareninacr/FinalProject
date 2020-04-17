package com.example.finalproject.Activities.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.Activities.Admin.InputData.InputDataActivity;
import com.example.finalproject.Activities.Admin.Laporan.LaporanActivity;
import com.example.finalproject.Activities.Admin.Riwayat.RiwayatActivity;
import com.example.finalproject.Activities.Admin.Transaksi.TransaksiActivity;
import com.example.finalproject.R;

public class MainPetugasActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnInput, btnTransaksi, btnRiwayat, btnLaporan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        btnInput       = (ImageButton) findViewById(R.id.btnInput);
        btnTransaksi   = (ImageButton) findViewById(R.id.btnTransaksi);
        btnRiwayat     = (ImageButton) findViewById(R.id.btnRiwayat);
        btnLaporan     = (ImageButton) findViewById(R.id.btnLaporan);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnInput:
                Intent input = new Intent(MainPetugasActivity.this, InputDataActivity.class);
                startActivity(input);
                break;
            case R.id.btnTransaksi:
                Intent transaksi = new Intent(MainPetugasActivity.this, TransaksiActivity.class);
                startActivity(transaksi);
                break;
            case R.id.btnRiwayat:
                Intent riwayat = new Intent(MainPetugasActivity.this, RiwayatActivity.class);
                startActivity(riwayat);
                break;
            case R.id.btnLaporan:
                Intent laporan = new Intent(MainPetugasActivity.this, LaporanActivity.class);
                startActivity(laporan);
                break;
            default:
                break;
        }
    }
}
