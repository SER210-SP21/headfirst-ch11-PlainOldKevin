package com.example.ls11_countriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements CountryListFragment.CountryListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void setCountryIdOnClick(int position) {

        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            CountryDetail frag = new CountryDetail();
            frag.setCountryId(position);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, frag);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("countryId", position);
            startActivity(intent);
        }
    }
}
