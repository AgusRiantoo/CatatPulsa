package com.ipan.pencatattransaksipulsa;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,TambahTransaksi.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        db = new SQLiteHandler(getApplicationContext());
        HashMap<String, String> user = db.showSaldo();
        String totalsaldo = user.get("totalsaldo");
        String keutungan = user.get("keuntungan");
        TextView txtSaldo = (TextView) findViewById(R.id.saldo);
        txtSaldo.setText("Rp. "+totalsaldo);

        TextView txtKeuntungan = (TextView) findViewById(R.id.keuntungan);
        txtKeuntungan.setText("Rp. "+keutungan);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder exit = new AlertDialog.Builder(this);
            exit.setMessage
                    ("Apakah anda ingin keluar?")
                    .setCancelable(false)
                    .setPositiveButton("Ya",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent exit = new Intent(Intent.ACTION_MAIN);
                                    exit.addCategory(Intent.CATEGORY_HOME);
                                    exit.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                                    startActivity(exit);
                                    finish();
                                }
                            })
                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog dialog = exit.create();
            dialog.setTitle("Exit");
            dialog.show();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.TambahSaldo) {
            Intent i = new Intent(MainActivity.this,TambahSaldo.class);
            startActivity(i);
        } else if (id == R.id.TambahTransaksi) {
            Intent i = new Intent(MainActivity.this,TambahTransaksi.class);
            startActivity(i);

        } else if (id == R.id.RincianPenjualan) {
            Intent i = new Intent(MainActivity.this,RincianPenjualan.class);
            startActivity(i);

        } else if (id == R.id.DaftarHarga) {
            Intent i = new Intent(MainActivity.this,DaftarHarga.class);
            startActivity(i);
        } else if (id == R.id.UbahHarga) {
            Intent i = new Intent(MainActivity.this,UbahHarga.class);
            startActivity(i);
        } else if (id == R.id.Bantuan) {
            Intent i = new Intent(MainActivity.this,Bantuan.class);
            startActivity(i);
        } else if (id == R.id.Tentang) {
            Intent i = new Intent(MainActivity.this,Tentang.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
