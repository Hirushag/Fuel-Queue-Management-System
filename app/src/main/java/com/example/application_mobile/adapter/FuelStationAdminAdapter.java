package com.example.application_mobile.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application_mobile.R;
import com.example.application_mobile.constant.Common;
import com.example.application_mobile.fragment.fuelStation.AddFuelStationDetailsAdmin;
import com.example.application_mobile.fragment.fuelStation.FuelStationDetail;
import com.example.application_mobile.model.FuelStation;

import java.util.ArrayList;
import java.util.List;


public class FuelStationAdminAdapter extends RecyclerView.Adapter<FuelStationAdminAdapter.StationsAdminViewHolder> {


    private List<FuelStation> listdata;
    private Context context;
    private Common common = new Common();
    AddFuelStationDetailsAdmin addFuelStationDetailsAdmin = new AddFuelStationDetailsAdmin();


    public FuelStationAdminAdapter(List<FuelStation> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public FuelStationAdminAdapter.StationsAdminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.fragment_fuel_station_list_admin, parent, false);
        FuelStationAdminAdapter.StationsAdminViewHolder viewHolder = new FuelStationAdminAdapter.StationsAdminViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FuelStationAdminAdapter.StationsAdminViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final List<FuelStation> fuelStationData = new ArrayList<>();

        holder.textView_1.setText(listdata.get(position).getName());
        holder.textView_2.setText(listdata.get(position).getAddress());
        holder.textView_3.setText(listdata.get(position).getOpenDateTime());
        holder.textView_4.setText(listdata.get(position).getCloseDateTime());
        holder.textView_5.setText(listdata.get(position).getIsAir());
        holder.cardView.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                bundle.putString("Id", listdata.get(position).getId());
                bundle.putString("Name", listdata.get(position).getName());
                bundle.putString("Address", listdata.get(position).getAddress());
                bundle.putString("OpenTime", listdata.get(position).getOpenDateTime());
                bundle.putString("CloseTime", listdata.get(position).getCloseDateTime());
                bundle.putString("Status", listdata.get(position).getIsOpen());

                addFuelStationDetailsAdmin.setArguments(bundle);
                FragmentTransaction mFragmentTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                mFragmentTransaction.replace(R.id.flFragment, addFuelStationDetailsAdmin).commit();

            }
        });

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class StationsAdminViewHolder extends RecyclerView.ViewHolder {

        public TextView textView_1, textView_2, textView_3, textView_4, textView_5, textView_6, textView_7;
        public CardView cardView;

        public StationsAdminViewHolder(View itemView) {

            super(itemView);
            this.textView_1 = (TextView) itemView.findViewById(R.id.station_name);
            this.textView_2 = (TextView) itemView.findViewById(R.id.station_address);
            this.textView_3 = (TextView) itemView.findViewById(R.id.station_open);
            this.textView_4 = (TextView) itemView.findViewById(R.id.station_close);
            this.textView_5 = (TextView) itemView.findViewById(R.id.station_status);
            cardView = itemView.findViewById(R.id.stations_list_all_card_view_admin);

        }


    }
}
