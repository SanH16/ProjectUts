package com.si61.projectuts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {
    private EditText etNama, etKota, etAlamat;
    private Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.et_nama);
        etKota = findViewById(R.id.et_kota);
        etAlamat = findViewById(R.id.et_alamat_pasar);
        btnTambah = findViewById(R.id.btn_tambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama, kota, alamat;

                nama = etNama.getText().toString();
                kota = etKota.getText().toString();
                alamat = etAlamat.getText().toString();

                if (nama.trim().equals("")) {
                    etNama.setError("Nama pasar tidak boleh kosong");
                } else if (kota.trim().equals("")) {
                    etKota.setError("Kota/kabupaten tidak boleh kosong");
                } else if (alamat.trim().equals("")) {
                    etAlamat.setError("Alamat tidak boleh kosong");
                }else {
                    MyDatabaseHelper myDB = new MyDatabaseHelper(TambahActivity.this);
                    long eks = myDB.tambahData(nama, kota, alamat);
                    if (eks == -1) {
                        Toast.makeText(TambahActivity.this, "Tambah Data Gagal!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(TambahActivity.this, "Tambah Data Berhasil!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}