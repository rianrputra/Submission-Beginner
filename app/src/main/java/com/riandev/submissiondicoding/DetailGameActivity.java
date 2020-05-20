package com.riandev.submissiondicoding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.riandev.submissiondicoding.R;

import java.util.Objects;

public class DetailGameActivity extends AppCompatActivity {
    private TextView tvPicSource;
    private TextView tvGameTitle;
    private TextView tvGameGenre;
    private TextView tvGameRating;
    private TextView tvGameDesc;
    private ImageView ivDescPicture;
    private Button backButton;

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_RATING = "rating";
    public static final String EXTRA_DESC = "desc";
    public static final String EXTRA_GENRE = "genre";
    public static final String EXTRA_PIC = "picture";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ivDescPicture = findViewById(R.id.iv_desc_picture);
        tvGameTitle = findViewById(R.id.tv_game_title);
        tvGameRating = findViewById(R.id.tv_game_rating);
        tvGameDesc = findViewById(R.id.tv_game_desc);
        tvGameGenre = findViewById(R.id.tv_game_genre);

        String title = getIntent().getStringExtra(EXTRA_TITLE);
        String genre = getIntent().getStringExtra(EXTRA_GENRE);
        String desc = getIntent().getStringExtra(EXTRA_DESC);
        String rating = getIntent().getStringExtra(EXTRA_RATING);
        int picture = getIntent().getIntExtra(EXTRA_PIC, 0);

        Glide.with(this)
                .load(picture)
                .into(ivDescPicture);

        tvGameTitle.setText(title);
        tvGameGenre.setText(genre);
        tvGameRating.setText(rating);
        tvGameDesc.setText(desc);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
