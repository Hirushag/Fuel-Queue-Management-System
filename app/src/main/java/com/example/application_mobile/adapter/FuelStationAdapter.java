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
import com.example.application_mobile.fragment.fuelStation.FuelStationDetail;
import com.example.application_mobile.model.FuelStation;

import java.util.ArrayList;
import java.util.List;


public class FuelStationAdapter extends RecyclerView.Adapter<FuelStationAdapter.OrderViewHolder> {

    private List<FuelStation> listdata;
    private Context context;
    private Common common = new Common();
    FuelStationDetail fuelStationDetail = new FuelStationDetail();


    public FuelStationAdapter(List<FuelStation> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public FuelStationAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.fragment_fuel_station_all_list, parent, false);
        OrderViewHolder viewHolder = new OrderViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FuelStationAdapter.OrderViewHolder holder, @SuppressLint("RecyclerView") int position) {

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
                bundle.putString("Town", listdata.get(position).getCity());
                bundle.putString("OpenTime", listdata.get(position).getOpenDateTime());
                bundle.putString("CloseTime", listdata.get(position).getCloseDateTime());
                bundle.putString("Status", listdata.get(position).getIsOpen());

                fuelStationDetail.setArguments(bundle);
                FragmentTransaction mFragmentTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                mFragmentTransaction.replace(R.id.flFragment, fuelStationDetail).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {

        public TextView textView_1, textView_2, textView_3, textView_4, textView_5, textView_6, textView_7;
        public CardView cardView;

        public OrderViewHolder(View itemView) {

            super(itemView);
            this.textView_1 = (TextView) itemView.findViewById(R.id.station_name);
            this.textView_2 = (TextView) itemView.findViewById(R.id.station_address);
            this.textView_3 = (TextView) itemView.findViewById(R.id.station_open);
            this.textView_4 = (TextView) itemView.findViewById(R.id.station_close);
            this.textView_5 = (TextView) itemView.findViewById(R.id.station_status);
            cardView = itemView.findViewById(R.id.stations_list_all_card_view);

        }
    }
}