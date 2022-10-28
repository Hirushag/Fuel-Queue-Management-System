package com.example.application_mobile.fragment.fuelStation;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.application_mobile.R;
import com.example.application_mobile.adapter.FuelStationAdapter;
import com.example.application_mobile.adapter.FuelStationAdminAdapter;
import com.example.application_mobile.constant.Common;
import com.example.application_mobile.constant.FuelConstant;
import com.example.application_mobile.model.FuelStation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lombok.SneakyThrows;


public class FuelStationListAdmin extends Fragment {

    private RecyclerView recyclerView;
    private CardView stations_list_all_card_view_admin;
    private FuelStationAdminAdapter adapter;
    private List<FuelStation> stationsList = new ArrayList<>();
    private final Common common = new Common();
    private RequestQueue requestQueue;
    private JsonArrayRequest jsonArrayRequest;
    private final FuelConstant fuelConstant = new FuelConstant();



    public FuelStationListAdmin() {

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //call get oder details method for get oder list
        getFuelStationDetails();

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //find the id with relevant component
        View view = inflater.inflate(R.layout.fragment_fuel_station_admin, container, false);
        recyclerView = view.findViewById(R.id.fuel_recycle_view_admin);
        stations_list_all_card_view_admin = view.findViewById(R.id.stations_list_all_card_view_admin);
        adapter = new FuelStationAdminAdapter(stationsList,getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //set adepter to recycle view
        recyclerView.setAdapter(adapter);

        return view;

    }

    private void getFuelStationDetails() {

        System.out.println("test test");
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


                        System.out.println("tttttttttttttttttttttttttttttttttttttttttttttttttt");
                        System.out.println(response.toString());

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
                                fuelStations.setOpenDateTime(obj.getString(fuelConstant.getOpenDateTime()));
                                fuelStations.setTotalPetrol(Integer.parseInt(obj.getString(fuelConstant.getTotalPetrol())));
                                fuelStations.setTotalDiesel(Integer.parseInt(obj.getString(fuelConstant.getTotalDiesel())));
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