package com.example.planetasapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] planetNames;
    private Integer[] planetImages = {
            R.drawable.mercurio, R.drawable.venus, R.drawable.tierra,
            R.drawable.marte, R.drawable.jupiter, R.drawable.saturno,
            R.drawable.urano, R.drawable.neptuno
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.List);
        planetNames = getResources().getStringArray(R.array.planet_names);

        AdapterList adapter = new AdapterList(this, planetNames, planetImages);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("planet_name", planetNames[position]);
                intent.putExtra("planet_image", planetImages[position]);
                startActivity(intent);
            }
        });
    }
}