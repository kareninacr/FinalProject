package com.example.finalproject.Activities.Admin.InputData.DataKelas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.Adapter.KelasAdapter;
import com.example.finalproject.Helper.Kelas.DBHandler;
import com.example.finalproject.Model.Kelas;
import com.example.finalproject.R;
import java.util.List;

public class TambahKelas extends AppCompatActivity {
    private EditText etKelas, etKompetensi;
    private Button btnSimpan, btnLihat;
    private DBHandler dbHandler;
    private KelasAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_kelas);

        dbHandler = new DBHandler(this);
        initComponents();
    }

    private void initComponents() {
        etKelas      = (EditText) findViewById(R.id.etKelas);
        etKompetensi = (EditText) findViewById(R.id.etKompetensi);
        btnSimpan    = (Button) findViewById(R.id.btnSimpan);
        btnLihat     = (Button) findViewById(R.id.btnLihat);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiForm();
            }
        });

        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TambahKelas.this, DataKelas.class));
            }
        });
    }

    private void validasiForm() {
        String form_kelas = etKelas.getText().toString();
        String form_kompetensi = etKompetensi.getText().toString();

        if (form_kelas.isEmpty()) {
            etKelas.setError("Isi nama kelas");
            etKelas.requestFocus();
        }
        if (form_kompetensi.isEmpty()) {
            etKompetensi.setError("Isi kompetensi kelas");
            etKompetensi.requestFocus();
        } else {
            dbHandler.tambahKelas(new Kelas(form_kelas, form_kompetensi));
            List<Kelas> kelasList = dbHandler.getSemuaKelas();
            adapter = new KelasAdapter(kelasList,TambahKelas.this);
            adapter.notifyDataSetChanged();

            Toast.makeText(TambahKelas.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
        }
    }
}
