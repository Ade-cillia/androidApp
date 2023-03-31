package com.example.goodversionlul;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityAnime extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main_btn:
                        Intent activityGeneral = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(activityGeneral);
                        return true;
                    case R.id.anime_btn:
                        Intent activityAnime = new Intent(getApplicationContext(), ActivityAnime.class);
                        startActivity(activityAnime);
                        return true;
                    case R.id.manga_btn:
                        Intent activityManga = new Intent(getApplicationContext(), ActivityManga.class);
                        startActivity(activityManga);
                        return true;
                }
                return false;
            }
        });
    }
}