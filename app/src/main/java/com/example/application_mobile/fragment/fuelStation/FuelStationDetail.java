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

    private TextView  station_name, station_address,available_quantity,vehicle_quantity,que_count,can_not_view,join_btn,sl_10,sl_7,sl_8;
    private Button petrol,diesel,exit_before,exit_after;
    private String fuelType = "PETROL";
    private String vehicle_type;
    private final Common common = new Common();
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectRequest;
    private String station_id;
    private String que_id;
    private Boolean status;
//    private List<FuelStationDetail> stationsList = new ArrayList<>();

    public FuelStationDetail() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fuel_station_details, container, false);
        station_name = (TextView) view.findViewById(R.id.station_name);
        station_address = (TextView) view.findViewById(R.id.station_address);
        available_quantity = (TextView) view.findViewById(R.id.available_quantity);
        vehicle_quantity = (TextView) view.findViewById(R.id.vehicle_quantity);
        que_count = (TextView) view.findViewById(R.id.que_count);
        can_not_view = (TextView) view.findViewById(R.id.can_not_view);
        sl_10 = (TextView) view.findViewById(R.id.sl_10);
        sl_7 = (TextView) view.findViewById(R.id.sl_7);
        sl_8 = (TextView) view.findViewById(R.id.sl_8);
        petrol = (Button) view.findViewById(R.id.petrol);
        diesel = (Button) view.findViewById(R.id.diesel);
        exit_before = (Button) view.findViewById(R.id.exit_before);
        exit_after = (Button) view.findViewById(R.id.exit_after);
        join_btn = (Button) view.findViewById(R.id.join_btn);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner_vehicle_type);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.vehicle, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        exit_before.setVisibility(View.GONE);
        exit_after.setVisibility(View.GONE);
        can_not_view.setVisibility(View.GONE);
        join_btn.setVisibility(View.GONE);
        sl_10.setVisibility(View.GONE);
        sl_7.setVisibility(View.GONE);
        sl_8.setVisibility(View.GONE);
        available_quantity.setVisibility(View.GONE);
        vehicle_quantity.setVisibility(View.GONE);
        que_count.setVisibility(View.GONE);




        petrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuelType = "Petrol";
              //  diesel.setEnabled(false);
                getQuantity();

            }
        });

        diesel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuelType = "Diesel";
                getQuantity();
//                petrol.setEnabled(false);

            }

        });


        System.out.println(fuelType);


        //set data to data-bundle
        Bundle bundle = getArguments();
        station_id = bundle.getString("Id");
        station_name.setText(bundle.getString("Name"));
        station_address.setText(bundle.getString("Address"));


        return view;
    }

    private void getQuantityAfter(){

        System.out.println( common.getGET_FUEL_QUANTITIES()+station_id+"&type="+fuelType+"&vehicleType="+vehicle_type);
        //RequestQueue initialized
        requestQueue = Volley.newRequestQueue(getContext());

        jsonObjectRequest  = new JsonObjectRequest(

                Request.Method.GET,
                common.getGET_FUEL_QUANTITIES()+station_id+"&type="+fuelType+"&vehicleType="+vehicle_type,
                null,

                new Response.Listener<JSONObject>() {

                    @SuppressLint("LongLogTag")
                    @SneakyThrows
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("Response is {} ", response.toString());

                        try {

                            available_quantity.setText(response.getString("Quantity").concat("L"));
                            vehicle_quantity.setText(response.getString("VehicaleCount"));
                            que_count.setText(response.getString("Quecount"));


                        } catch (JSONException e) {

                            e.printStackTrace();
                        }

                        return;
                    }

                }, (Response.ErrorListener) error -> Log.e("Response {} ", error.toString())

        );
        requestQueue.add(jsonObjectRequest);

    }


    private void getQuantity() {
        System.out.println( common.getGET_FUEL_QUANTITIES()+station_id+"&type="+fuelType+"&vehicleType="+vehicle_type);
        //RequestQueue initialized
        requestQueue = Volley.newRequestQueue(getContext());

        jsonObjectRequest  = new JsonObjectRequest(

                Request.Method.GET,
                common.getGET_FUEL_QUANTITIES()+station_id+"&type="+fuelType+"&vehicleType="+vehicle_type,
                null,

                new Response.Listener<JSONObject>() {

                    @SuppressLint("LongLogTag")
                    @SneakyThrows
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("Response is {} ", response.toString());

                        System.out.println("DETAIL LIST====================");
                        System.out.println(response.toString());



                        try {

                                sl_10.setVisibility(View.VISIBLE);
                                sl_7.setVisibility(View.VISIBLE);
                                sl_8.setVisibility(View.VISIBLE);

                                available_quantity.setText(response.getString("Quantity").concat("L"));
                                vehicle_quantity.setText(response.getString("VehicaleCount"));
                                que_count.setText(response.getString("Quecount"));

                                available_quantity.setVisibility(View.VISIBLE);
                                vehicle_quantity.setVisibility(View.VISIBLE);
                                que_count.setVisibility(View.VISIBLE);


                                if(response.getInt("VehicaleCount") == 0){

                                    exit_after.setVisibility(View.GONE);
                                    join_btn.setVisibility(View.GONE);
                                    exit_before.setVisibility(View.GONE);
                                    can_not_view.setVisibility(View.VISIBLE);

                                }else{
                                    join_btn.setVisibility(View.VISIBLE);

                                    join_btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            ChangeButtonStatusToJoin();
                                            join_btn.setVisibility(View.GONE);
                                            exit_after.setVisibility(View.VISIBLE);
                                            exit_before.setVisibility(View.VISIBLE);

                                            exit_before.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {

                                                    status = false;

                                                    ExitFromTheQue();
                                                    join_btn.setVisibility(View.VISIBLE);
                                                    exit_after.setVisibility(View.GONE);
                                                    exit_before.setVisibility(View.GONE);
                                                }
                                            });

                                            exit_after.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    status = true;

                                                    ExitFromTheQue();
//                                                    exit_before.setVisibility(View.GONE);

                                                }
                                            });

                                        }
                                    });


                                }

                            } catch (JSONException e) {

                                e.printStackTrace();
                            }

                        return;
                    }

                }, (Response.ErrorListener) error -> Log.e("Response {} ", error.toString())

        );
        requestQueue.add(jsonObjectRequest);

    }

    private void ChangeButtonStatusToJoin(){

        System.out.println( common.getJOIN_TO_QUE());
        //RequestQueue initialized
        requestQueue = Volley.newRequestQueue(getContext());
        JSONObject jsonBody = new JSONObject();

        try {
            jsonBody.put("VehicleType", vehicle_type);
            jsonBody.put("StationId", station_id);
            jsonBody.put("UserId", "Gagana123");
            jsonBody.put("'FuleType'", fuelType);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("JBODY===============");
        System.out.println(jsonBody);

        jsonObjectRequest   = new JsonObjectRequest(

                Request.Method.POST,
                common.getJOIN_TO_QUE(),
                jsonBody,

                new Response.Listener<JSONObject>() {

                    @SuppressLint("LongLogTag")
                    @SneakyThrows
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("Response is {} ", response.toString());

                        System.out.println("DETAIL LIST====================");
                        System.out.println(response.toString());
                        getQuantityAfter();

                        try {
                            que_id = response.getString("Id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return;
                    }

                }, (Response.ErrorListener) error -> Log.e("Response {} ", error.toString())

        );
        requestQueue.add(jsonObjectRequest);



    }

    private void ExitFromTheQue(){

        System.out.println( common.getEXIT_FROM_THE_QUE());
        //RequestQueue initialized
        requestQueue = Volley.newRequestQueue(getContext());


        System.out.println("JBODY22222222222===============");


        jsonObjectRequest   = new JsonObjectRequest(

                Request.Method.POST,
                common.getEXIT_FROM_THE_QUE()+que_id+"&type="+fuelType+"&status="+status,
                null,

                new Response.Listener<JSONObject>() {

                    @SuppressLint("LongLogTag")
                    @SneakyThrows
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("Response is {} ", response.toString());

                        System.out.println("DETAIL LIST2222222222222222====================");
                        System.out.println(response.toString());
                        getQuantityAfter();

                        try {
                            que_id = response.getString("Id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return;
                    }

                }, (Response.ErrorListener) error -> Log.e("Response {} ", error.toString())

        );
        requestQueue.add(jsonObjectRequest);



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        vehicle_type = (String) parent.getItemAtPosition(position);
        System.out.println(vehicle_type);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
