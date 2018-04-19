package com.suarakan.suarakan;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Kandidat {

    private int noUrut;
    private String namaPasangan;
    private static List<Kandidat> kandidats = new ArrayList<>();

    public static enum City {
        KOTA_BANDUNG, KABUPATEN_BANDUNG_BARAT, KOTA_BOGOR,
        KABUPATEN_BOGOR, KOTA_CIREBON, KABUPATEN_CIREBON,
        KOTA_SUKABUMI, KOTA_BANJAR, KOTA_BEKASI,
        KABUPATEN_PURWAKARTA, KABUPATEN_SUMEDANG,
        KABUPATEN_SUBANG, KABUPATEN_KUNINGAN,
        KABUPATEN_MAJALENGKA, KABUPATEN_GARUT,
        KABUPATEN_CIAMIS
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
            case KOTA_BANDUNG:
                paslon = context.getResources().getStringArray(R.array.kota_bandung);
                break;
            case KABUPATEN_BANDUNG_BARAT:
                paslon = context.getResources().getStringArray(R.array.kabupaten_bandung_barat);
                break;
            case KOTA_BOGOR:
                paslon = context.getResources().getStringArray(R.array.kota_bogor);
                break;
            case KABUPATEN_BOGOR:
                paslon = context.getResources().getStringArray(R.array.kabupaten_bogor);
                break;
            case KOTA_CIREBON:
                paslon = context.getResources().getStringArray(R.array.kota_cirebon);
                break;
            case KABUPATEN_CIREBON:
                paslon = context.getResources().getStringArray(R.array.kabupaten_cirebon);
                break;
            case KOTA_SUKABUMI:
                paslon = context.getResources().getStringArray(R.array.kota_sukabumi);
                break;
            case KOTA_BANJAR:
                paslon = context.getResources().getStringArray(R.array.kota_banjar);
                break;
            case KOTA_BEKASI:
                paslon = context.getResources().getStringArray(R.array.kota_bekasi);
                break;
            case KABUPATEN_PURWAKARTA:
                paslon = context.getResources().getStringArray(R.array.kabupaten_purwakarta);
                break;
            case KABUPATEN_SUMEDANG:
                paslon = context.getResources().getStringArray(R.array.kabupaten_sumedang);
                break;
            case KABUPATEN_SUBANG:
                paslon = context.getResources().getStringArray(R.array.kabupaten_subang);
                break;
            case KABUPATEN_KUNINGAN:
                paslon = context.getResources().getStringArray(R.array.kabupaten_kuningan);
                break;
            case KABUPATEN_MAJALENGKA:
                paslon = context.getResources().getStringArray(R.array.kabupaten_majalengka);
                break;
            case KABUPATEN_GARUT:
                paslon = context.getResources().getStringArray(R.array.kabupaten_garut);
                break;
            case KABUPATEN_CIAMIS:
                paslon = context.getResources().getStringArray(R.array.kabupaten_ciamis);
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
