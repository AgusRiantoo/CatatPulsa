package com.ipan.pencatattransaksipulsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class DaftarHarga extends AppCompatActivity {

    private SQLiteHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_harga);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TableLayout tableLayout = (TableLayout) findViewById(R.id.table_data);
        try {
            db = new SQLiteHandler(getApplicationContext());

            ArrayList<ArrayList<Object>> data = db.showPulsa();
            for (int posisi = 0; posisi < data.size(); posisi++) {
                TableRow tabelBaris = new TableRow(this);
                ArrayList<Object> baris = data.get(posisi);

                TextView idTxt = new TextView(this);
                idTxt.setText(baris.get(0).toString());
                tabelBaris.addView(idTxt);

                TextView kodeTxt = new TextView(this);
                kodeTxt.setText(baris.get(1).toString());
                tabelBaris.addView(kodeTxt);

                TextView jenisTxt = new TextView(this);
                jenisTxt.setText(baris.get(2).toString());
                tabelBaris.addView(jenisTxt);

                TextView hargaTxt = new TextView(this);
                hargaTxt.setText(baris.get(3).toString());
                tabelBaris.addView(hargaTxt);

                TextView hargajualTxt = new TextView(this);
                hargajualTxt.setText(baris.get(4).toString());
                tabelBaris.addView(hargajualTxt);

                tableLayout.addView(tabelBaris);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return false;
    }
}
