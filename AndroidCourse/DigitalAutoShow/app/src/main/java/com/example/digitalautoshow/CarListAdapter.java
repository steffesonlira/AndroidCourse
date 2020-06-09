package com.example.digitalautoshow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarViewHolder> {

    List<Car> cars;

    public CarListAdapter(List<Car> cars) {
        this.cars = cars;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_item, parent, false);

        return new CarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        holder.imageView.setImageResource(cars.get(position).getImage());
        holder.textViewName.setText(cars.get(position).getName());
        holder.textViewHP.setText(cars.get(position).getHp());
        holder.textViewManufacturing.setText(String.valueOf(cars.get(position).getManufacturing()));

    }

    @Override
    public int getItemCount() {

        return cars.size();
    }

    static class CarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textViewName;
        TextView textViewHP;
        TextView textViewManufacturing;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.car_image);
            textViewName = itemView.findViewById(R.id.car_name);
            textViewHP = itemView.findViewById(R.id.car_hp);
            textViewManufacturing = itemView.findViewById(R.id.car_manufacturing);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(itemView.getContext(), textViewName.getText(), Toast.LENGTH_SHORT).show();

        }
    }
}
