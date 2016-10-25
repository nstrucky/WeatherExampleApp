package com.example.android.sunshine.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //PreferenceManager.setDefaultValues(this, R.xml.pref_general, false);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id) {

            case R.id.mainmenu_item_viewlocation:
                openPreferredLocationInMap();
                Toast.makeText(getApplicationContext(), "View on Map", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.mainmenu_item_settings:
                startSettingsActivity();
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_refresh:
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                return true;

            default:
                Toast.makeText(getApplicationContext(), "Default", Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);

    }

    private void startSettingsActivity() {

        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), SettingsActivity.class);
        startActivity(intent);

    }

    private void openPreferredLocationInMap() {

        String zipCode = PreferenceManager.getDefaultSharedPreferences(getApplicationContext())
                .getString(getString(R.string.pref_location_key),  //get the saved preference or...
                        getString(R.string.pref_location_default)); //get the default value

        Uri uri = Uri.parse("geo:0,0?q=" + zipCode);
        //Toast.makeText(getActivity(), "viewonmap", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        if (intent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "No apps available", Toast.LENGTH_SHORT).show();
        }

    }

}
