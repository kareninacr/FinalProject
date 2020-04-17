package com.example.finalproject.Activities.Admin.InputData.DataKelas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.Helper.Kelas.DBHandler;
import com.example.finalproject.R;

public class ShowDataKelas extends AppCompatActivity {

    private ImageView back;
    private Button btnTambah;
    private DBHandler dbHandler;
    private ImageButton btnBack;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_kelas);
        btnBack = (ImageButton) findViewById(R.id.back_data_kelas);


        dbHandler = new DBHandler(ShowDataKelas.this);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDataKelas.this, DataKelas.class);
                startActivity(intent);
            }
        });
    }

}
