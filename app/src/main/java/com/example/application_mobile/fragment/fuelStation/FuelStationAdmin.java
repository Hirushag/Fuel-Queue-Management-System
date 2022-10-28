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
import com.android.volley.toolbox.JsonObjectRequest;
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


public class FuelStationAdmin extends Fragment {


    private Button button;
    private List<FuelStation> stationsList = new ArrayList<>();
    private AddFuelStation createOrder = new AddFuelStation();
    private final Common common = new Common();
    private final FuelConstant fuelConstant = new FuelConstant();
    private RecyclerView recyclerView;
    private FuelStationAdminAdapter adapter;
    private RequestQueue requestQueue;
    private JsonArrayRequest jsonArrayRequest;
    private JsonObjectRequest jsonObjectRequest;


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

        adapter = new FuelStationAdminAdapter(stationsList,getContext());

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

//    pass user ID below

    private void getFuelStationDetails() {

        System.out.println("GAGANA");
        System.out.println( common.getGET_FUEL_STATIONS());
        //RequestQueue initialized
        requestQueue = Volley.newRequestQueue(getContext());

        jsonObjectRequest = new JsonObjectRequest(

                Request.Method.GET,
                common.getGET_FUEL_STATIONS_BY_ADMINID()+"Ok3456789",
                null,

                new Response.Listener<JSONObject>() {

                    @SuppressLint("LongLogTag")
                    @SneakyThrows
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("Response is {} ", response.toString());

                        stationsList.clear();

                        System.out.println("HIRUSHA");
                        System.out.println(response.toString());


                        //read list data

                        FuelStation fuelStations = new FuelStation();
//                                JSONObject obj = response.toString();

//                                System.out.println(obj);

                        //set date to object
                        try {
                            fuelStations.setId(response.getString("Id"));
                            fuelStations.setName(response.getString("Name"));
                            fuelStations.setAddress(response.getString("Address").concat(response.getString("City")));
                            fuelStations.setIsOpen(String.valueOf(fuelConstant.getIsOpen()));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        stationsList.add(fuelStations);


                        Log.i("filtered fuelStation response {}", stationsList.toString());

                        adapter.notifyDataSetChanged();
                        return;
                    }

                }, (Response.ErrorListener) error -> Log.e("Response {} ", error.toString())

        );
        requestQueue.add(jsonObjectRequest);

    }
}