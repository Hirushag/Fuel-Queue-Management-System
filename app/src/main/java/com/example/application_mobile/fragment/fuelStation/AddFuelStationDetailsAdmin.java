package com.example.application_mobile.fragment.fuelStation;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.application_mobile.R;
import com.example.application_mobile.constant.Common;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.SneakyThrows;


public class AddFuelStationDetailsAdmin extends Fragment implements AdapterView.OnItemSelectedListener {

    private final Common common = new Common();
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectRequest;

    private TextView station_name, petrol_quantity_text,diesel_quantity_text2;
    private EditText fuel_quantity;

    private Button station_update,open_btn,close_btn;

    private String fuelType;
    private String stationId;
    private Double fuelPrice;
    private Boolean status;
    private Boolean IsOpen;




    public AddFuelStationDetailsAdmin() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_fuel_station_details_admin, container, false);
        station_name = (TextView) view.findViewById(R.id.station_name);
        petrol_quantity_text = (TextView) view.findViewById(R.id.petrol_quantity_text);
        diesel_quantity_text2 = (TextView) view.findViewById(R.id.diesel_quantity_text2);
        station_update = (Button) view.findViewById(R.id.station_update);
        open_btn = (Button) view.findViewById(R.id.open_btn);
        close_btn = (Button) view.findViewById(R.id.close_btn);
        fuel_quantity = (EditText) view.findViewById(R.id.fuel_quantity);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner_fuel);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.fuel, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //set data to data-bundle
        Bundle bundle = getArguments();


        System.out.println("HERE2=====================================");
        System.out.println(bundle);

        stationId = bundle.getString("Id");
        station_name.setText(bundle.getString("Name"));
        petrol_quantity_text.setText(bundle.getString("PetrolQuantity"));
        diesel_quantity_text2.setText(bundle.getString("DieselQuantity"));

        getData();



        station_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateFuelDetails();
            }
        });

        open_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                status =true;
                open_btn.setVisibility(View.GONE);
                close_btn.setVisibility(View.VISIBLE);
                UpdateOpenCloseStatus();

            }
        });

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status =false;
                open_btn.setVisibility(View.VISIBLE);
                close_btn.setVisibility(View.GONE);
                UpdateOpenCloseStatus();
            }
        });

        return view;
    }


    private void getData() {
        //RequestQueue initialized
        requestQueue = Volley.newRequestQueue(getContext());

        jsonObjectRequest = new JsonObjectRequest(

                Request.Method.GET,
                common.getGET_FUEL_STATIONS_BY_USER() + stationId,
                null,

                new Response.Listener<JSONObject>() {

                    @SuppressLint("LongLogTag")
                    @SneakyThrows
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("Response is {} ", response.toString());


                        System.out.println("WORKING");
                        System.out.println(response.toString());
                        try {
                            petrol_quantity_text.setText(response.getString("TotalPetrol").concat("L"));
                            diesel_quantity_text2.setText(response.getString("TotalDiesel").concat("L"));
                            IsOpen = response.getBoolean("IsOpen");

                            System.out.println(IsOpen);

                            if(IsOpen == true){
                                open_btn.setVisibility(View.GONE);
                                close_btn.setVisibility(View.VISIBLE);
                            }else{
                                open_btn.setVisibility(View.VISIBLE);
                                close_btn.setVisibility(View.GONE);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        fuelType = (String) parent.getItemAtPosition(position);
        System.out.println(fuelType);
        if(fuelType == "Petrol"){
            fuelPrice = 370.00;
        }else if(fuelType == "Diesel"){
            fuelPrice = 415.00;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void UpdateFuelDetails() {

        Bundle bundle = getArguments();
        requestQueue = Volley.newRequestQueue(getContext());
        JSONObject jsonBody = new JSONObject();

        System.out.println(fuelPrice);

        try {
            jsonBody.put("StationId", stationId);
            jsonBody.put("FuleType", fuelType);
            jsonBody.put("Stock", fuel_quantity.getText().toString());
            jsonBody.put("Price", fuelPrice);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("SENDING DATA");

        System.out.println(jsonBody);
        jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                common.getUPDATE_FUEL_QUANTITY(),
                jsonBody,
                new Response.Listener<JSONObject>() {

                    @SneakyThrows
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("Response {} ", response.toString());

                        System.out.println(response.toString());

                        Toast.makeText(getContext(), "Station Update Successfully", Toast.LENGTH_LONG).show();

                        getData();

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

    public void UpdateOpenCloseStatus() {

        System.out.println(common.getUPDATE_OPEN_CLOSE_STATUS()+stationId+"&status="+status);

        Bundle bundle = getArguments();
        requestQueue = Volley.newRequestQueue(getContext());

        System.out.println(status);

        jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                common.getUPDATE_OPEN_CLOSE_STATUS()+stationId+"&status="+status,
                null,
                new Response.Listener<JSONObject>() {

                    @SneakyThrows
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("Response {} ", response.toString());

                        System.out.println("-===========-=-=-=-=-=-=-==-==-=-=-=-");

                        System.out.println(response.toString());
                        
                        Toast.makeText(getContext(), "Station Status Updated Successfully", Toast.LENGTH_LONG).show();

                        getData();

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