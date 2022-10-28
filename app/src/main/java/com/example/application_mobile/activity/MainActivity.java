package com.example.application_mobile.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.application_mobile.DbHelper.DbHelper;
import com.example.application_mobile.R;
import com.example.application_mobile.fragment.fuelStation.FuelStation;
import com.example.application_mobile.fragment.fuelStation.FuelStationAdmin;
import com.example.application_mobile.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

   private String currentUser;
   private String currentUserRole;
   private String currenId;

   private String user;
   private MenuItem stations;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle extra = getIntent().getExtras();

        currentUser = extra.getString("email");
        currenId = extra.getString("id");
        currentUserRole = extra.getString("role");





//        if(currentUserRole == "CUSTOMER"){
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);        }



        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.stations);
        bottomNavigationView.setSelectedItemId(R.id.admin_stations);

        if(currentUserRole =="CUSTOMER"){
            findViewById(R.id.admin_stations).setVisibility(View.GONE);

        }else if(currentUserRole == "ADMIN"){
            findViewById(R.id.stations).setVisibility(View.GONE);

        }
    }

    FuelStation fuelStations = new FuelStation();
    FuelStationAdmin fuelStationsAdmin = new FuelStationAdmin();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        System.out.println("MENU");
        System.out.println(item.getItemId());


        switch (item.getItemId()) {

            case R.id.stations:

                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,fuelStations).commit();
                return true;


            case R.id.admin_stations:

                findViewById(R.id.stations).setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fuelStationsAdmin).commit();
                return true;

        }
        return false;
    }

}