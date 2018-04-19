package com.suarakan.suarakan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class BantuanActivity extends AppCompatActivity {

    private FirebaseDatabase fDb;
    private TextInputLayout txtNama, txtEmail, txtKeluhan;
    private Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fDb = FirebaseDatabase.getInstance();
        setContentView(R.layout.activity_bantuan);
        setViewById();
    }

    private void setViewById() {
        txtNama = findViewById(R.id.input_text_nama);
        txtEmail = findViewById(R.id.input_text_email);
        txtKeluhan = findViewById(R.id.input_text_keluhan);
        btnSubmit = findViewById(R.id.button_submit_bantuan);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushToDb();
            }
        });
    }

    private void pushToDb() {
        String nama = txtNama.getEditText().getText().toString();
        String email = txtEmail.getEditText().getText().toString();
        String keluhan = txtKeluhan.getEditText().getText().toString();
        if (verifyContent(nama, email, keluhan)) {
            BantuanKeluhan bantuanKeluhan = new BantuanKeluhan(nama, email, keluhan);
            fDb.getReference().child("bantuan_keluhan").push().setValue(bantuanKeluhan);
            Toast.makeText(this, "Bantuan/Keluhan Tercatat di Database",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public boolean verifyContent(String nama, String email, String keluhan) {
        if (nama.isEmpty()) {
            txtNama.setError("Harap isi nama anda");
            txtNama.setErrorEnabled(true);
            txtEmail.setErrorEnabled(false);
            txtKeluhan.setErrorEnabled(false);
            return false;
        } else if (email.isEmpty()) {
            txtEmail.setError("Harap isi email anda");
            txtEmail.setErrorEnabled(true);
            txtNama.setErrorEnabled(false);
            txtKeluhan.setErrorEnabled(false);
            return false;
        } else if (keluhan.isEmpty()) {
            txtKeluhan.setError("Harap isi bantuan/keluhan anda");
            txtKeluhan.setErrorEnabled(true);
            txtNama.setErrorEnabled(false);
            txtEmail.setErrorEnabled(false);
            return false;
        } else {
            return true;
        }
    }
}
