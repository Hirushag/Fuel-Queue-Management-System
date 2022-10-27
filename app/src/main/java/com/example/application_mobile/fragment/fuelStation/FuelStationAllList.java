package com.example.application_mobile.fragment.fuelStation;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.application_mobile.R;


public class FuelStationAllList extends Fragment {

    private RecyclerView recyclerView;


    public FuelStationAllList() {
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
        View view = inflater.inflate(R.layout.fragment_fuel_station_all_list, container, false);
        recyclerView = view.findViewById(R.id.fuel_recycle_view);
        return view;
    }
}