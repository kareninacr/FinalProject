package com.example.finalproject.Activities.Admin.InputData.DataKelas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Activities.Admin.InputData.InputDataActivity;
import com.example.finalproject.Adapter.KelasAdapter;
import com.example.finalproject.Helper.Kelas.DBHandler;
import com.example.finalproject.Model.Kelas;
import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.List;

public class DataKelas extends AppCompatActivity {

    private RecyclerView rvKelas;
    private LinearLayoutManager layoutManager;
    private KelasAdapter adapter;
    private DBHandler dbHandler;
    private List<Kelas> kelasList = new ArrayList<>();
    private Button btnTambah;
    private ImageButton btnKembali;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kelas);

        initRecyclerView();
        initComponents();
    }

    private void initRecyclerView() { //Untuk init recyclerview dan adapter
        rvKelas = (RecyclerView) findViewById(R.id.rvKelas);
        rvKelas.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvKelas.setLayoutManager(layoutManager);

        dbHandler = new DBHandler(DataKelas.this);
        kelasList = dbHandler.getSemuaKelas();
        adapter = new KelasAdapter(kelasList,DataKelas.this);
        rvKelas.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initComponents() {
        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnKembali = (ImageButton) findViewById(R.id.back);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataKelas.this, TambahKelas.class));
                finish();
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DataKelas.this, InputDataActivity.class));
                finish();
            }
        });
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
