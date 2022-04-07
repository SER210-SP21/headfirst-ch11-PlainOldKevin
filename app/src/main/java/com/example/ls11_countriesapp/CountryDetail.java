package com.example.ls11_countriesapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountryDetail extends Fragment {


    private int countryId;
    public CountryDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_detail, container, false);
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();

        if (view != null && countryId != -1) {
            TextView countryFact = (TextView) view.findViewById(R.id.textView);
            countryFact.setText(Country.countries[countryId].getFact());

            ImageView countryMap = (ImageView) view.findViewById(R.id.imageView);
            countryMap.setImageResource(Country.countries[countryId].getMap());
        }
    }
}

