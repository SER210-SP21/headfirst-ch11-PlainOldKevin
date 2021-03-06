package com.example.ls11_countriesapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CountryListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CountryListFragment extends ListFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private CountryListListener mActivity;

    public interface CountryListListener {
        void setCountryIdOnClick(int countryId);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (CountryListListener) context;

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mActivity.setCountryIdOnClick(position);
    }

    public CountryListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CountryListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CountryListFragment newInstance(String param1, String param2) {
        CountryListFragment fragment = new CountryListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] from = {"flag","text","cur"};

        // IDs of views
        int[] to = {R.id.flag,R.id.txt,R.id.cur};

        // instantiate adapter to store items
        // R.layout.listview defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), new Country().getAdaptorList(), R.layout.listview_layout, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}