package com.example.goodversionlul.popup;

import android.app.Dialog;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goodversionlul.R;

public class PopupHungry extends Dialog {
    private String title;
    private Button positiveButton;
    private Button negativeButton;

    // Constructor
    public PopupHungry(AppCompatActivity p_act){
        super(p_act,
                androidx.constraintlayout.widget.R.style.Theme_AppCompat_DayNight_Dialog);
        setContentView(R.layout.popup_del_hungry);
        this.title="Supprimer un j\'ai faim";
        this.positiveButton = findViewById(R.id.popup_add_manga_positive_btn);
        this.negativeButton = findViewById(R.id.popup_add_manga_negative_btn);
    }
    public void build(){
        show();
    }
    public void close(){
        dismiss();
    }
    public void setTitle(String p_title){
        this.title = p_title;
    }
    public Button getPositiveButton(){
        return this.positiveButton;
    }

    public Button getNegativeButton(){
        return this.negativeButton;
    }
}