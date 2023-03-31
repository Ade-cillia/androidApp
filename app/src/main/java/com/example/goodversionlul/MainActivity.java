package com.example.goodversionlul;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.goodversionlul.popup.PopupHungry;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Button hungryBtn;
    private Button popupBtn;
    private TextView hungryText;
    private LinearLayout mainLayout;
    private  LinearLayout hungryList;
    private  PopupHungry popupHungry;

    private  MainActivity m_activity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main_layout);
        hungryBtn = findViewById(R.id.add_manga_btn);
        hungryText = findViewById(R.id.hungry_text);

        hungryList = findViewById(R.id.hungry_list);

        hungryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView newHungryText = new TextView(MainActivity.this);
                hungryText.setText(getResources().getString(R.string.hungry_txt));
                newHungryText.setText(getResources().getString(R.string.hungry_txt));
                hungryList.addView(newHungryText);
            }
        });



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
        Button popupBtn = findViewById(R.id.popup_btn);
        popupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open popupHungry
                popupHungry = new PopupHungry(m_activity);
                Button positiveBtn = popupHungry.getPositiveButton();
                positiveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int childCount = hungryList.getChildCount();
                        if (childCount > 0) {
                            View lastChild = hungryList.getChildAt(childCount - 1);
                            hungryList.removeView(lastChild);

                            // Display a Toast message
                            Toast.makeText(MainActivity.this, getResources().getString(R.string.hungry_deleted), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, getResources().getString(R.string.hungry_deleted_error), Toast.LENGTH_SHORT).show();
                        }
                        popupHungry.close();
                    }
                });
                Button negativeBtn = popupHungry.getNegativeButton();
                negativeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupHungry.close();
                    }
                });
                popupHungry.build();
            }
        });

    }
}