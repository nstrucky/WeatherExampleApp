package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        getFragmentManager()
                .beginTransaction()
                .add(R.id.content_settings, new SettingsFragment()) //the layout id specified tells us where to add the fragment
                .commit();                                      //HAHAHAHAHA so if you use the activity as the container (first argument of add()), screws up your layout. Either do it programatically here
                                                                //using the content layout as the container, or just insert a fragment into the content layout itself.
*/                                                              //either way, you need to "include" the content_settings layout in the activity_settings layout.



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }




}
