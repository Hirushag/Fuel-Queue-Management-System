package com.example.application_mobile.fragment.fuelStation;

import static android.content.Context.MODE_PRIVATE;
import static android.os.ParcelFileDescriptor.MODE_APPEND;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.application_mobile.R;
import com.example.application_mobile.constant.Common;
import com.example.application_mobile.constant.FuelConstant;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.SneakyThrows;

public class AddFuelStation extends Fragment {

    private EditText station_name, station_address, open_time, town, close_time,license_number;
    private Button button;
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectRequest;
    private Common common = new Common();
    private FuelConstant fuelConstant = new FuelConstant();





    public AddFuelStation() {
        //create default constructor
    }

    @SneakyThrows
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_fuel_station, container, false);
        station_name = view.findViewById(R.id.station_name);
        station_address = view.findViewById(R.id.station_address);
        open_time = view.findViewById(R.id.station_open_hours);
        close_time = view.findViewById(R.id.station_close);
        town = view.findViewById(R.id.station_town);
        license_number = view.findViewById(R.id.license_number);
        button = view.findViewById(R.id.add_fuel_station_btn);

        FuelStation fuelStation = new FuelStation();


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AddFuelStations();
            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {

            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fuelStation).commit();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

        return view;
    }

    public void AddFuelStations() {

        Bundle bundle = getArguments();
        requestQueue = Volley.newRequestQueue(getContext());
        JSONObject jsonBody = new JSONObject();

        try {
            jsonBody.put("Name", station_name.getText().toString());
            jsonBody.put("Address", station_address.getText().toString());
            jsonBody.put("City", town.getText().toString());
            jsonBody.put("'OpenDateTime'", open_time.getText().toString());
            jsonBody.put("CloseDateTime", close_time.getText().toString());
            jsonBody.put("LicenceNumber", license_number.getText().toString());
            jsonBody.put("OwnerId", "Owner12");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(jsonBody);
        jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                common.getADD_FUEL_STATION(),
                jsonBody,
                new Response.Listener<JSONObject>() {

                    @SneakyThrows
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("Response {} ", response.toString());

                        System.out.println(response.toString());

                        Toast.makeText(getContext(), "Station Created Successfully", Toast.LENGTH_LONG).show();
                        FragmentManager fm = getFragmentManager();
                        getFragmentManager().popBackStack();

                    }

                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("Response", error.toString());

            }
        }

        );

        requestQueue.add(jsonObjectRequest);

    }


}
