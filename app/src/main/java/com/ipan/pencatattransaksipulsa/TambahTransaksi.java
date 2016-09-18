package com.ipan.pencatattransaksipulsa;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;

public class TambahTransaksi extends AppCompatActivity {

    private Calendar calendar;
    private int year, month, day;

    private SQLiteHandler db;
    private String op,nom;
    private EditText etTanggal,etJenisPulsa,etHargaJual;
    private int saldoakhir,keuntungan,saldo,untung,untungawal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_transaksi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db = new SQLiteHandler(getApplicationContext());

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);

        etTanggal = (EditText) findViewById(R.id.tgl);
        etJenisPulsa = (EditText) findViewById(R.id.jenispulsa);
        etHargaJual = (EditText) findViewById(R.id.hargajual);

        HashMap<String, String> getsaldo = db.showSaldo();
        saldo = Integer.parseInt(getsaldo.get("totalsaldo"));
        keuntungan = Integer.parseInt(getsaldo.get("keuntungan"));
        untungawal = Integer.parseInt(getsaldo.get("keuntungan"));

        Spinner operator = (Spinner) findViewById(R.id.operator);
        op = operator.getSelectedItem().toString();
        operator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                op = (String) parent.getSelectedItem();
                String jenis = op +" "+ nom;
                HashMap<String, String> user = db.showHarga(jenis);
                etJenisPulsa.setText(jenis);
                etHargaJual.setText(user.get("hargajual"));
                saldoakhir = saldo - Integer.parseInt(user.get("harga"));
                untung = Integer.parseInt(user.get("hargajual")) - Integer.parseInt(user.get("harga"));
                keuntungan = untungawal + untung;
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
                etHargaJual.setText(user.get("hargajual"));
                saldoakhir = saldo - Integer.parseInt(user.get("harga"));
                untung = Integer.parseInt(user.get("hargajual")) - Integer.parseInt(user.get("harga"));
                keuntungan = untungawal + untung;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tanggal = etTanggal.getText().toString().trim();
                String jenis = etJenisPulsa.getText().toString().trim();
                String harga = etHargaJual.getText().toString().trim();

                if (!tanggal.isEmpty() && !jenis.isEmpty() && !harga.isEmpty()) {
                    try {
                        db.addTransaksi(tanggal, jenis, harga,saldoakhir,keuntungan);
                        Toast.makeText(getApplicationContext(),"Berhasil menambah transaksi",Toast.LENGTH_SHORT).show();

                        finish();
                        Intent i = new Intent(TambahTransaksi.this,MainActivity.class);
                        startActivity(i);

                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Gagal menambah transaksi",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Lengkapi data", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void setDate(View view) {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // here argument values...
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        etTanggal = (EditText) findViewById(R.id.tgl);
        etTanggal.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return false;
    }
}

