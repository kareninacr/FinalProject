package com.example.finalproject.Activities.Admin.InputData.DataSiswa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.Activities.Admin.InputData.InputDataActivity;
import com.example.finalproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InputSiswa extends AppCompatActivity implements View.OnClickListener {

    ImageView back;
    FloatingActionButton btnTambah;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_siswa);

        back = (ImageView) findViewById(R.id.back);
        btnTambah = (FloatingActionButton) findViewById(R.id.btnTambah);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                Intent kembali = new Intent(InputSiswa.this, InputDataActivity.class);
                startActivity(kembali);
                break;
            default:
                break;
        }
    }
}
