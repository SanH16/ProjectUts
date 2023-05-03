package com.si61.projectuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabTambah;
    private RecyclerView rvPasar;
    private MyDatabaseHelper myDB;
    private ArrayList<String> arrId, arrNama, arrKota, arrAlamat;
    private AdapterPasar adPasar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabTambah = findViewById(R.id.fab_tambah);
        rvPasar = findViewById(R.id.rv_pasar);

        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TambahActivity.class));
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
    }

    private void SQLiteToArrayList() {
        Cursor varCursor = myDB.bacaDataDestinasi();
        if (varCursor.getCount() == 0){
            Toast.makeText(this, "Data Tidak Tersedia", Toast.LENGTH_SHORT).show();
        }
        else {
            while (varCursor.moveToNext()){
                arrId.add(varCursor.getString(0));
                arrNama.add(varCursor.getString(1));
                arrKota.add(varCursor.getString(2));
                arrAlamat.add(varCursor.getString(3));
            }
        }
    }

    private void tampilDestinasi(){
        arrId = new ArrayList<>();
        arrNama = new ArrayList<>();
        arrAlamat = new ArrayList<>();
        arrKota = new ArrayList<>();

        SQLiteToArrayList();

        adPasar = new AdapterPasar(MainActivity.this, arrId, arrNama, arrKota, arrAlamat);
        rvPasar.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvPasar.setAdapter(adPasar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tampilDestinasi();
    }
}