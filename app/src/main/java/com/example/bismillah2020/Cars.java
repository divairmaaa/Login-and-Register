package com.example.bismillah2020;

import com.google.gson.annotations.SerializedName;

public class Cars {

    @SerializedName("id") private int Id;
    @SerializedName("kategori") private String Kategori;
    @SerializedName("jumlah") private String Jumlah;

    public int getId() { return Id; }

    public String getKategori() {
        return Kategori;
    }

    public String getJumlah() {
        return Jumlah;
    }
}
