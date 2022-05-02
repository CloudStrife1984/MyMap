package com.example.mymap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SibeliusInfo extends AppCompatActivity {
    TextView infoText;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sibelius_info);
        infoText = findViewById(R.id.sibeliusInfo);
        infoText.setText("Sibeliusmoneumentti rakennettiin vuonna 1963(arvaus sinnepäin)");
        infoText.append("\nOn todella hieno monumentti keskellä pääkaupunkia");
    }
}