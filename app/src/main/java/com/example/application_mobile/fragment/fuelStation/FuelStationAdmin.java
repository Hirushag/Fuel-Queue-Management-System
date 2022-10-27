package com.example.application_mobile.fragment.fuelStation;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.application_mobile.R;
import com.example.application_mobile.adapter.FuelStationAdapter;
import com.example.application_mobile.constant.Common;
import com.example.application_mobile.constant.FuelConstant;
import com.example.application_mobile.model.FuelStation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lombok.SneakyThrows;


public class FuelStationAdmin extends Fragment {


    private Button button;
    private List<FuelStation> stationsList = new ArrayList<>();
    private AddFuelStation createOrder = new AddFuelStation();
    private final Common common = new Common();
    private final FuelConstant fuelConstant = new FuelConstant();
    private RecyclerView recyclerView;
    private FuelStationAdapter adapter;
    private RequestQueue requestQueue;
    private JsonArrayRequest jsonArrayRequest;


    public FuelStationAdmin() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //call get oder details method for get oder list
        getFuelStationDetails();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //find the id with relevant component
        View view = inflater.inflate(R.layout.fragment_fuel_station_admin, container, false);
        recyclerView = view.findViewById(R.id.fuel_recycle_view_admin);
        button = view.findViewById(R.id.add_fuel_station);

        adapter = new FuelStationAdapter(stationsList,getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //set adepter to recycle view
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {

            Bundle bundle = new Bundle();

            @Override
            public void onClick(View v) {

                createOrder.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, createOrder).commit();
            }
        });

        return view;
    }

    private void getFuelStationDetails() {
        System.out.println( common.getGET_FUEL_STATIONS());
        //RequestQueue initialized
        requestQueue = Volley.newRequestQueue(getContext());

        jsonArrayRequest = new JsonArrayRequest(

                Request.Method.GET,
                common.getGET_FUEL_STATIONS(),
                null,

                new Response.Listener<JSONArray>() {

                    @SuppressLint("LongLogTag")
                    @SneakyThrows
                    @Override
                    public void onResponse(JSONArray response) {

                        Log.i("Response is {} ", response.toString());

                        stationsList.clear();


                        //read list data
                        for (int i = 0; i < response.length(); i++) {

                            try {

                                com.example.application_mobile.model.FuelStation fuelStations = new com.example.application_mobile.model.FuelStation();
                                JSONObject obj = response.getJSONObject(i);

                                System.out.println(obj);

                                //set date to object
                                fuelStations.setId(obj.getString(fuelConstant.getId()));
                                fuelStations.setName(obj.getString(fuelConstant.getName()));
                                fuelStations.setAddress(obj.getString(fuelConstant.getAddress()));
                                fuelStations.getOpenDateTime();
                                fuelStations.setCloseDateTime(obj.getString(fuelConstant.getCloseDateTime()));
                                fuelStations.setIsOpen(String.valueOf(fuelConstant.getIsOpen()));


                                stationsList.add(fuelStations);

                            } catch (JSONException e) {

                                e.printStackTrace();
                            }

                        }
                        Log.i("filtered fuelStation response {}", stationsList.toString());

                        adapter.notifyDataSetChanged();
                        return;
                    }

                }, (Response.ErrorListener) error -> Log.e("Response {} ", error.toString())

        );
        requestQueue.add(jsonArrayRequest);

    }
}