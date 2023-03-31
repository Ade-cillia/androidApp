package com.example.goodversionlul;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.goodversionlul.popup.PopupHungry;
import com.example.goodversionlul.popup.PopupManga;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityManga extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Button addMangaBtn;
    private PopupManga popupManga;
    private LinearLayout mangaList;
    private  ActivityManga m_activity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        addMangaBtn = findViewById(R.id.add_manga_btn);
        mangaList = findViewById(R.id.manga_list);
        addMangaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open popupManga
                PopupManga popupManga = new PopupManga(m_activity);
                Button positiveBtn = popupManga.getPositiveButton();
                positiveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView newHungryText = new TextView(ActivityManga.this);

                        newHungryText.setText(getResources().getString(R.string.hungry_txt));
                        View mangaCard = getLayoutInflater().inflate(R.layout.fragment_manga_card, null);

                        ImageView mangaImage = mangaCard.findViewById(R.id.manga_image);
                        mangaImage.setImageResource(R.drawable.supergike);

                        // Find the TextInputEditText view for the manga title
                        TextInputEditText mangaTitleInput = popupManga.findViewById(R.id.manga_title_input);
                        // Get the value of the manga title from the TextInputEditText view
                        String mangaTitle = mangaTitleInput.getText().toString();

                        TextView mangaTitleCard = mangaCard.findViewById(R.id.manga_title);
                        mangaTitleCard.setText(mangaTitle);

                        Button mangaDeleteCard = mangaCard.findViewById(R.id.manga_delete_btn);
                        mangaDeleteCard.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mangaList.removeView(mangaCard);
                            }
                        });
                        // Display a Toast message
                        mangaList.addView(mangaCard);
                        Toast.makeText(ActivityManga.this, getResources().getString(R.string.manga_added), Toast.LENGTH_SHORT).show();
                        popupManga.close();
                    }
                });
                Button negativeBtn = popupManga.getNegativeButton();
                negativeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupManga.close();
                    }
                });
                popupManga.build();
            }
        });

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