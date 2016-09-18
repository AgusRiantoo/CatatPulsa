package com.ipan.pencatattransaksipulsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class UbahHarga extends AppCompatActivity {

    private SQLiteHandler db;
    private String op,nom;
    private EditText etJenisPulsa,etHargaJual,etHarga;
    private String kode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_harga);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db = new SQLiteHandler(getApplicationContext());

        etJenisPulsa = (EditText) findViewById(R.id.jenispulsa);
        etHarga = (EditText) findViewById(R.id.harga);
        etHargaJual = (EditText) findViewById(R.id.hargajual);

        Spinner operator = (Spinner) findViewById(R.id.operator);
        op = operator.getSelectedItem().toString();
        operator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                op = (String) parent.getSelectedItem();
                String jenis = op +" "+ nom;
                HashMap<String, String> user = db.showHarga(jenis);
                etJenisPulsa.setText(jenis);
                etHarga.setText(user.get("harga"));
                etHargaJual.setText(user.get("hargajual"));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.nominal);
        nom = spinner.getSelectedItem().toString();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nom = (String) parent.getSelectedItem();
                String jenis = op +" "+ nom;
                HashMap<String, String> user = db.showHarga(jenis);
                etJenisPulsa.setText(jenis);
                etHarga.setText(user.get("harga"));
                etHargaJual.setText(user.get("hargajual"));
                kode = user.get("kode");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String harga = etHarga.getText().toString().trim();
                String hargajual = etHargaJual.getText().toString().trim();

                if (!harga.isEmpty() && !hargajual.isEmpty()) {
                    try {
                        db.updatePulsa(kode,harga,hargajual);
                        Toast.makeText(getApplicationContext(),"Berhasil merubah pulsa",Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Gagal merubah pulsa",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Lengkapi data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return false;
    }
}
