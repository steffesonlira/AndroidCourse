package com.example.playwithroom.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playwithroom.R;
import com.example.playwithroom.model.PlayKidding;

import java.util.List;

public class PlayKiddingAdapter extends RecyclerView.Adapter<PlayKiddingAdapter.ViewHolder> {

    private List<PlayKidding> playKiddings;

    public PlayKiddingAdapter(List<PlayKidding> playKiddings){
        this.playKiddings = playKiddings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.playkidding_itens,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.id.setText(String.valueOf(playKiddings.get(position).getId()));
        holder.name.setText(playKiddings.get(position).getName());
        holder.description.setText(playKiddings.get(position).getDescription());
        holder.player.setText(String.valueOf(playKiddings.get(position).getPlayers()));
    }

    @Override
    public int getItemCount() {
        return playKiddings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView id, name, description, player;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView_id);
            name = itemView.findViewById(R.id.textView_name);
            description = itemView.findViewById(R.id.textView_description);
            player = itemView.findViewById(R.id.textView_players);

        }
    }
}
