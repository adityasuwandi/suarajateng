package com.suarakan.suarakan;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Kandidat {

    private int noUrut;
    private String namaPasangan;
    private static List<Kandidat> kandidats = new ArrayList<>();

    public static enum City {
        KABUPATEN_BANYUMAS,KABUPATEN_KARANGANYAR,KABUPATEN_KUDUS,KABUPATEN_MAGELANG,
        KABUPATEN_TEMANGGUNG,KABUPATEN_TEGAL,KOTA_TEGAL;
    }

    public Kandidat() {
    }

    public Kandidat(int noUrut, String namaPasangan) {
        this.noUrut = noUrut;
        this.namaPasangan = namaPasangan;
    }

    public int getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(int noUrut) {
        this.noUrut = noUrut;
    }

    public String getNamaPasangan() {
        return namaPasangan;
    }

    public void setNamaPasangan(String namaPasangan) {
        this.namaPasangan = namaPasangan;
    }

    public String getUrutanPanjang() {
        return "Nomor Urut " + String.valueOf(noUrut);
    }

    public static List<Kandidat> getKandidats(City city, Context context) {
        String[] paslon = null;
        switch (city) {
            case KABUPATEN_BANYUMAS:
                paslon = context.getResources().getStringArray(R.array.kabupaten_banyumas);
                break;
            case KABUPATEN_KARANGANYAR:
                paslon = context.getResources().getStringArray(R.array.kabupaten_karanganyar);
                break;
            case KABUPATEN_KUDUS:
                paslon = context.getResources().getStringArray(R.array.kabupaten_kudus);
                break;
            case KABUPATEN_MAGELANG:
                paslon = context.getResources().getStringArray(R.array.kabupaten_magelang);
                break;
            case KABUPATEN_TEMANGGUNG:
                paslon = context.getResources().getStringArray(R.array.kabupaten_temanggung);
                break;
            case KABUPATEN_TEGAL:
                paslon = context.getResources().getStringArray(R.array.kabupaten_tegal);
                break;
            case KOTA_TEGAL:
                paslon = context.getResources().getStringArray(R.array.kota_tegal);
                break;
        }
        addToList(paslon);
        return kandidats;
    }

    private static void addToList(String[] paslon) {
        kandidats.clear();
        for (int i=0;i<paslon.length;i++) {
            kandidats.add(new Kandidat(i+1, paslon[i]));
        }
    }

}
