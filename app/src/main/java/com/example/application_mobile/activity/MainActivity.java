package com.example.application_mobile.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.application_mobile.R;
import com.example.application_mobile.fragment.fuelStation.FuelStation;
import com.example.application_mobile.fragment.fuelStation.FuelStationAdmin;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.stations);
    }

    FuelStation fuelStations = new FuelStation();
    FuelStationAdmin fuelStationsAdmin = new FuelStationAdmin();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.stations:

                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,fuelStations).commit();
                return true;


            case R.id.admin_stations:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fuelStationsAdmin).commit();
                return true;

            case R.id.invoice:
//                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, invoices).commit();
                return true;
            case R.id.quotation:
//                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, quotations).commit();
                return true;
        }
        return false;
    }

}