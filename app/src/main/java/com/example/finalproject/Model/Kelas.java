package com.example.finalproject.Model;

public class Kelas {
    private int id;
    private String nama_kelas, kompetensi;

    public Kelas() {

    }

    public Kelas(String nama_kelas, String kompetensi) {
        this.nama_kelas = nama_kelas;
        this.kompetensi = kompetensi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getKompetensi() {
        return kompetensi;
    }

    public void setKompetensi(String kompetensi) {
        this.kompetensi = kompetensi;
    }
}
