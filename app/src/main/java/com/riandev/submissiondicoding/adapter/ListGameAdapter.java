package com.riandev.submissiondicoding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.riandev.submissiondicoding.R;
import com.riandev.submissiondicoding.model.Game;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListGameAdapter extends RecyclerView.Adapter<ListGameAdapter.ListViewHolder> {
    private ArrayList<Game> listGame;

    public ListGameAdapter(ArrayList<Game> listGame) {
        this.listGame = listGame;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_game,
                viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Game game = listGame.get(position);
        Glide.with(holder.itemView.getContext())
                .load(game.getPicture())
                .apply(new RequestOptions().override(70, 70))
                .into(holder.imgPicture);
        holder.tvName.setText(game.getName());
        holder.tvDetail.setText(game.getDetail());
        holder.tvRating.setText(String.valueOf(game.getRating()));
    }

    @Override
    public int getItemCount() {
        return listGame.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPicture;
        TextView tvName, tvDetail, tvRating;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPicture = itemView.findViewById(R.id.img_item_picture);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            tvRating = itemView.findViewById(R.id.tv_item_rating);
        }
    }
}
