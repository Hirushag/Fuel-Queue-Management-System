package com.example.application_mobile.fragment.fuelStation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.application_mobile.R;
import com.example.application_mobile.constant.Common;
import com.example.application_mobile.model.FuelStation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lombok.SneakyThrows;

public class FuelStationDetail extends Fragment implements AdapterView.OnItemSelectedListener {

    private TextView  station_name, station_address,available_quantity,vehicle_quantity;
    private Button petrol,diesel,exit_before,exit_after;
    private String fuelType = "PETROL";
    private String vehicle_type;
    private final Common common = new Common();
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectRequest;
//    private List<FuelStationDetail> stationsList = new ArrayList<>();

    public FuelStationDetail() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fuel_station_details, container, false);
        station_name = (TextView) view.findViewById(R.id.station_name);
        station_address = (TextView) view.findViewById(R.id.station_address);
        available_quantity = (TextView) view.findViewById(R.id.available_quantity);
        vehicle_quantity = (TextView) view.findViewById(R.id.vehicle_quantity);
        petrol = (Button) view.findViewById(R.id.petrol);
        diesel = (Button) view.findViewById(R.id.diesel);

        petrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuelType = "PETROL";
                diesel.setEnabled(false);

            }
        });

        diesel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuelType = "DIESEL";
                petrol.setEnabled(false);

            }
        });


        System.out.println(fuelType);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.vehicle, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        //set data to data-bundle
        Bundle bundle = getArguments();
        station_name.setText(bundle.getString("Name"));
        station_address.setText(bundle.getString("Address"));


        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            case 1:{
                vehicle_type = "CAR";
                break;
            }
            case 2:{
                vehicle_type = "BIKE";
                break;
            }
            case 3:{
                vehicle_type = "VAN";
                break;
            }
            case 4:{
                vehicle_type = "LORRY";
                break;
            }
            default: {
                vehicle_type = "SELECT A VEHICLE";
                break;
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void getQuantity() {
        System.out.println( common.getGET_FUEL_QUANTITIES());
        //RequestQueue initialized
        requestQueue = Volley.newRequestQueue(getContext());

        jsonObjectRequest = new JsonObjectRequest(

                Request.Method.GET,
                common.getGET_FUEL_QUANTITIES(),
                null,

                new Response.Listener<JSONObject>() {

                    @SuppressLint("LongLogTag")
                    @SneakyThrows
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("Response is {} ", response.toString());


                            try {

                                available_quantity.setText(response.getString("available_quantity"));
                                vehicle_quantity.setText(response.getString("vehicle_quantity"));

                            } catch (JSONException e) {

                                e.printStackTrace();
                            }

                        return;
                    }

                }, (Response.ErrorListener) error -> Log.e("Response {} ", error.toString())

        );
        requestQueue.add(jsonObjectRequest);

    }



}
