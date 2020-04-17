package com.example.finalproject.Activities.Admin.InputData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.Activities.Admin.InputData.DataKelas.DataKelas;
import com.example.finalproject.Activities.Admin.InputData.DataPetugas.InputPetugas;
import com.example.finalproject.Activities.Admin.InputData.DataSiswa.InputSiswa;
import com.example.finalproject.Activities.Admin.InputData.DataSpp.InputSpp;
import com.example.finalproject.Activities.Admin.MainPetugasActivity;
import com.example.finalproject.R;

public class InputDataActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnPetugas, btnSiswa, btnKelas, btnSpp, back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_admin);

        btnPetugas  = (ImageButton) findViewById(R.id.btnPetugas);
        btnSiswa    = (ImageButton) findViewById(R.id.btnSiswa);
        btnKelas    = (ImageButton) findViewById(R.id.btnKelas);
        btnSpp      = (ImageButton) findViewById(R.id.btnSpp);
        back        = (ImageButton) findViewById(R.id.back);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPetugas:
                Intent petugas = new Intent(InputDataActivity.this, InputPetugas.class);
                startActivity(petugas);
                break;
            case R.id.btnSiswa:
                Intent siswa = new Intent(InputDataActivity.this, InputSiswa.class);
                startActivity(siswa);
                break;
            case R.id.btnKelas:
                Intent kelas = new Intent(InputDataActivity.this, DataKelas.class);
                startActivity(kelas);
                break;
            case R.id.btnSpp:
                Intent spp = new Intent(InputDataActivity.this, InputSpp.class);
                startActivity(spp);
                break;
            case R.id.back:
                Intent kembali = new Intent(InputDataActivity.this, MainPetugasActivity.class);
                startActivity(kembali);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

