package com.riandev.submissiondicoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

    private void showRecycledCardView() {
        rvGames.setLayoutManager(new LinearLayoutManager(this));
        CardViewGameAdapter cardViewGameAdapter = new CardViewGameAdapter(list);
        rvGames.setAdapter(cardViewGameAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.right_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_about_me:
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
