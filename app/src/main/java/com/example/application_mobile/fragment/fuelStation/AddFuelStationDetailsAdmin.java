package com.example.application_mobile.fragment.fuelStation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.application_mobile.R;
import com.example.application_mobile.constant.Common;


public class AddFuelStationDetailsAdmin extends Fragment {

    private final Common common = new Common();
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectRequest;

    private TextView station_name, petrol_quantity_text,diesel_quantity_text2;
    private EditText fuel_quantity;

    private Button station_update;



    public AddFuelStationDetailsAdmin() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        View view = inflater.inflate(R.layout.fragment_add_fuel_station_details_admin, container, false);

        station_name = (TextView) view.findViewById(R.id.station_name);
        petrol_quantity_text = (TextView) view.findViewById(R.id.petrol_quantity_text);
        diesel_quantity_text2 = (TextView) view.findViewById(R.id.diesel_quantity_text2);
        station_update = (Button) view.findViewById(R.id.station_update);
        fuel_quantity = (EditText) view.findViewById(R.id.fuel_quantity);



        Spinner spinner = (Spinner) view.findViewById(R.id.spinner_fuel);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.fuel, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        return view;
    }
}