package com.ipan.pencatattransaksipulsa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class TambahSaldo extends AppCompatActivity {
    private SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_saldo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db = new SQLiteHandler(getApplicationContext());
        HashMap<String, String> user = db.showSaldo();
        final String totalsaldo = user.get("totalsaldo");
        final TextView txtSaldo = (TextView) findViewById(R.id.saldo);
        txtSaldo.setText("Saldo saat ini : "+totalsaldo);

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtTambahan = (EditText) findViewById(R.id.tambahan);
                String tambahan = txtTambahan.getText().toString().trim();
                try {
                    int saldo = Integer.parseInt(totalsaldo) + Integer.parseInt(tambahan);
                    db.updateSaldo(String.valueOf(saldo));
                    finish();
                    Toast.makeText(TambahSaldo.this,"Berhasil menambah saldo",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(TambahSaldo.this,MainActivity.class);
                    startActivity(i);
                }catch (Exception e){
                    Toast.makeText(TambahSaldo.this,"pastikan anda menginput angka!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return false;
    }
}
