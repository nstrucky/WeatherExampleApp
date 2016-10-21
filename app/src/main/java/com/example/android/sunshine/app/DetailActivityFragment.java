package com.example.android.sunshine.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {


    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);


        Intent intent = getActivity().getIntent();
        TextView forecastTextView = (TextView) view.findViewById(R.id.forecast_textview);


        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String forecastString = intent.getExtras().getString(Intent.EXTRA_TEXT);
            forecastTextView.setText(forecastString);

        }



        return view;

    }



}
