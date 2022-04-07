package com.example.ls11_countriesapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity{

    private int countryId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        countryId = getIntent().getExtras().getInt("countryId");

        CountryDetail frag = (CountryDetail) getSupportFragmentManager().findFragmentById(R.id.fragment_country_detail);

        frag.setCountryId(countryId);
    }
}

