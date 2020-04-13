package com.example.bismillah2020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Cars> cars;
    private Context context;

    public Adapter(List<Cars> cars, Context context) {
        this.cars = cars;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.kategori.setText(cars.get(position).getKategori());
        holder.jumlah.setText(cars.get(position).getJumlah());

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView kategori, jumlah;

        public MyViewHolder(View itemView) {
            super(itemView);
            kategori = itemView.findViewById(R.id.kategori);
            jumlah = itemView.findViewById(R.id.jumlah);

        }
    }
}
