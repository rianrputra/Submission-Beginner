package com.riandev.submissiondicoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.riandev.submissiondicoding.adapter.CardViewGameAdapter;
import com.riandev.submissiondicoding.db.GamesData;
import com.riandev.submissiondicoding.model.Game;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvGames;
    private ArrayList<Game> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGames = findViewById(R.id.rv_games);
        rvGames.setHasFixedSize(true);

        list.addAll(GamesData.getListData());
        showRecycledCardView();
    }

    /*
    private void showRecyclerList() {
        rvGames.setLayoutManager(new LinearLayoutManager(this));
        ListGameAdapter listGameAdapter = new ListGameAdapter(list);
        rvGames.setAdapter(listGameAdapter);
    }

     */

    private void showRecycledCardView() {
        rvGames.setLayoutManager(new LinearLayoutManager(this));
        CardViewGameAdapter cardViewGameAdapter = new CardViewGameAdapter(list);
        rvGames.setAdapter(cardViewGameAdapter);

    }
}
