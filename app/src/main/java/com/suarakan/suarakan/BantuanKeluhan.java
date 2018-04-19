package com.suarakan.suarakan;

public class BantuanKeluhan {

    private String nama;
    private String email;
    private String bantuanKeluhan;

    public BantuanKeluhan() {
    }

    public BantuanKeluhan(String nama, String email, String bantuanKeluhan) {
        this.nama = nama;
        this.email = email;
        this.bantuanKeluhan = bantuanKeluhan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBantuanKeluhan() {
        return bantuanKeluhan;
    }

    public void setBantuanKeluhan(String bantuanKeluhan) {
        this.bantuanKeluhan = bantuanKeluhan;
    }
}

