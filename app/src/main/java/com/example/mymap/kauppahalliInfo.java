package com.example.mymap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class kauppahalliInfo extends AppCompatActivity {
    TextView infoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kauppahalli_info);

        infoText = findViewById(R.id.kauppahalliInfo);
        infoText.setText("Vanha kauppahalli on vuonna 1889 avattu helsinkiläinen kauppahalli, joka sijaitsee Etelärannassa lähellä Kauppatoria. ");
        infoText.append("\nSe on kaupungin kauppahalleista vanhin. Rakennuksen on suunnitellut Gustaf Nyström.");


    }
}