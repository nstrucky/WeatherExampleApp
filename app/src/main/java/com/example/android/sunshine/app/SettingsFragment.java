package com.example.android.sunshine.app;


import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;

import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.v4.app.Fragment;

import android.support.v7.preference.PreferenceManager;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragment {


    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //PreferenceManager.setDefaultValues(getActivity(), R.xml.pref_general, false);
        addPreferencesFromResource(R.xml.pref_general);
    }


    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {

        if (preference.getKey().equals("viewlocation")) {

            String zipCode = PreferenceManager.getDefaultSharedPreferences(getActivity())
                    .getString(getString(R.string.pref_location_key),  //get the saved preference or...
                            getString(R.string.pref_location_default)); //get the default value

            Uri uri = Uri.parse("geo:0,0?q=" + zipCode);
            //Toast.makeText(getActivity(), "viewonmap", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivity(intent);
            } else {

                Toast.makeText(getActivity(), "No apps available", Toast.LENGTH_SHORT).show();
            }

        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

}
