package com.example.planetasapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView planetImage = findViewById(R.id.planet_image);
        TextView planetName = findViewById(R.id.planet_name);
        TextView planetInfo = findViewById(R.id.planet_info);
        ImageView planetImage1 = findViewById(R.id.planet_image1);
        ImageView planetImage2 = findViewById(R.id.planet_image2);
        Button backButton = findViewById(R.id.back_button);

        String name = getIntent().getStringExtra("planet_name");
        int image = getIntent().getIntExtra("planet_image", R.drawable.ic_launcher_background);

        planetName.setText(name);
        planetImage.setImageResource(image);
        planetInfo.setText(getPlanetInfo(name));
        planetImage1.setImageResource(image);  // You should use different images here
        planetImage2.setImageResource(image);  // You should use different images here

        // Set up the back button to start the MainActivity and return to the previous one
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // This will close the current activity
            }
        });
    }

    private String getPlanetInfo(String name) {
        switch (name) {
            case "Mercurio":
                return getString(R.string.mercurio_info);
            case "Venus":
                return getString(R.string.venus_info);
            case "Tierra":
                return getString(R.string.tierra_info);
            case "Marte":
                return getString(R.string.marte_info);
            case "Júpiter":
                return getString(R.string.jupiter_info);
            case "Saturno":
                return getString(R.string.saturno_info);
            case "Urano":
                return getString(R.string.urano_info);
            case "Neptuno":
                return getString(R.string.neptuno_info);
            default:
                return "";
        }
    }
}
