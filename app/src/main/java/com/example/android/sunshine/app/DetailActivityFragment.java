package com.example.android.sunshine.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {


    private String forecastString;
    private String hashTagForecastString;
    public DetailActivityFragment() {
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_detail, menu);

        MenuItem shareItem = menu.findItem(R.id.menu_item_action_provider);

        ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        if (shareActionProvider != null) {
            shareActionProvider.setShareIntent(createIntent());

        } else {
            Toast.makeText(getActivity(), "Share Action Provider is Null", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Intent intent = getActivity().getIntent();
        TextView forecastTextView = (TextView) view.findViewById(R.id.forecast_textview);

        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            forecastString = intent.getExtras().getString(Intent.EXTRA_TEXT);
            forecastTextView.setText(forecastString);

        }

        return view;

    }


    private Intent createIntent() {

        hashTagForecastString = forecastString + " #ShareActionProvider";

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, hashTagForecastString);
        shareIntent.setType("text/plain");

        return shareIntent;
    }

}
