package com.example.pahlawanku;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class HeroDetails extends AppCompatActivity {

    private ImageView imageView;
    private TextView nameHeroDetails;
    private TextView detailHeroDetails;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_details);
        imageView = findViewById(R.id.detail_image);
        nameHeroDetails = findViewById(R.id.detail_title);
        detailHeroDetails = findViewById(R.id.detail_desc);
        getIncomingIntent();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int heroesImage = bundle.getInt("img_url");
            Glide.with(getApplicationContext()).load(heroesImage).into(imageView);
            String getDetails = bundle.getString("heroes_details");
            String getTitle = bundle.getString("heroes_name");
            detailHeroDetails.setText(getDetails);
            nameHeroDetails.setText(getTitle);
        }
    }
}
