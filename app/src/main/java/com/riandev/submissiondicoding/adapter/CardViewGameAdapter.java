package com.riandev.submissiondicoding.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.riandev.submissiondicoding.R;
import com.riandev.submissiondicoding.DetailGameActivity;
import com.riandev.submissiondicoding.model.Game;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardViewGameAdapter extends RecyclerView.Adapter<CardViewGameAdapter.CardViewViewHolder> {
    private ArrayList<Game> listGame;

    public CardViewGameAdapter(ArrayList<Game> listGame) {
        this.listGame = listGame;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_game, viewGroup,false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, final int position) {
        Game game = listGame.get(position);

        Glide.with(holder.itemView.getContext())
                .load(game.getPicture())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPicture);

        holder.tvTitle.setText(game.getTitle());
        holder.tvDesc.setText(game.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailGameActivity.class);
                intent.putExtra("title", listGame.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("desc", listGame.get(holder.getAdapterPosition()).getDesc());
                intent.putExtra("rating", String.valueOf(listGame.get(holder.getAdapterPosition()).getRating()));
                intent.putExtra("genre", listGame.get(holder.getAdapterPosition()).getGenres());
                intent.putExtra("picture", listGame.get(holder.getAdapterPosition()).getPicture());
                intent.putExtra("platform", listGame.get(holder.getAdapterPosition()).getPlatform());
                intent.putExtra("price", String.valueOf(listGame.get(holder.getAdapterPosition()).getPrice()));
                v.getContext().startActivity(intent);
            }
        });

        holder.layoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shareText = listGame.get(holder.getAdapterPosition()).getTitle() + " - " + listGame.get(holder.getAdapterPosition()).getDesc();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                sendIntent.setType("text/plain");
                v.getContext().startActivity(sendIntent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listGame.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPicture;
        TextView tvTitle, tvDesc;
        ImageButton btnShareFb;
        LinearLayout layoutButton;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPicture = itemView.findViewById(R.id.img_item_picture);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDesc = itemView.findViewById(R.id.tv_item_desc);
            btnShareFb = itemView.findViewById(R.id.btn_share_fb);
            layoutButton = itemView.findViewById(R.id.layout_button);
        }
    }
}
