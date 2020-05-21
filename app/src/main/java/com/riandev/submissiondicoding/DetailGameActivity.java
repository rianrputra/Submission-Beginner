package com.riandev.submissiondicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailGameActivity extends AppCompatActivity {
    private TextView tvGamePlatform;
    private TextView tvGameTitle;
    private TextView tvGameGenre;
    private TextView tvGameRating;
    private TextView tvGameDesc;
    private TextView tvGamePrice;
    private ImageView ivDescPicture;

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_RATING = "rating";
    public static final String EXTRA_DESC = "desc";
    public static final String EXTRA_GENRE = "genre";
    public static final String EXTRA_PIC = "picture";
    public static final String EXTRA_PLATFORM = "platform";
    public static final String EXTRA_PRICE = "price";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ivDescPicture = findViewById(R.id.iv_desc_picture);
        tvGameTitle = findViewById(R.id.tv_game_title);
        tvGameRating = findViewById(R.id.tv_game_rating);
        tvGameDesc = findViewById(R.id.tv_game_desc);
        tvGameGenre = findViewById(R.id.tv_game_genre);
        tvGamePlatform = findViewById(R.id.tv_game_platform);
        tvGamePrice = findViewById(R.id.tv_game_price);

        String title = getIntent().getStringExtra(EXTRA_TITLE);
        String genre = getIntent().getStringExtra(EXTRA_GENRE);
        String desc = getIntent().getStringExtra(EXTRA_DESC);
        String rating = getIntent().getStringExtra(EXTRA_RATING);
        int picture = getIntent().getIntExtra(EXTRA_PIC, 0);
        String platform = getIntent().getStringExtra(EXTRA_PLATFORM);
        String price = getIntent().getStringExtra(EXTRA_PRICE);

        Glide.with(this)
                .load(picture)
                .into(ivDescPicture);

        tvGameTitle.setText(title);
        tvGameGenre.setText(genre);
        tvGameRating.setText(rating);
        tvGameDesc.setText(desc);
        tvGamePlatform.setText(platform);
        tvGamePrice.setText("USD " + price);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
