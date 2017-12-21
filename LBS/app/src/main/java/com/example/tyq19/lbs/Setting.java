package com.example.tyq19.lbs;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by tyq19 on 2017/2/17.
 */

public class Setting extends AppCompatActivity {
    private boolean GPS_ONLY;
    private boolean DOOR_LOC;
    private boolean RADIUS_MODE;
    private boolean COMPASS_MODE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        GPS_ONLY = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("gps_only", false);
        RADIUS_MODE = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("radius_mode", false);
        DOOR_LOC = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("door_loc",false);
        COMPASS_MODE = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("compass_mode",false);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        PrefFragment prefFragment = new PrefFragment();
        getFragmentManager().beginTransaction().add(R.id.frag_container, prefFragment).commit();
    }

    @Override
    public void onBackPressed() {
        if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean("gps_only", false) != GPS_ONLY
                ||PreferenceManager.getDefaultSharedPreferences(this).getBoolean("door_loc", false) != DOOR_LOC
                ||PreferenceManager.getDefaultSharedPreferences(this).getBoolean("radius_mode", false) != RADIUS_MODE
                || PreferenceManager.getDefaultSharedPreferences(this).getBoolean("compass_mode",false) != COMPASS_MODE) {
            setResult(1);
        }
        super.onBackPressed();
        overridePendingTransition(R.anim.layout_in_move2,R.anim.layout_out_move2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public static class PrefFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.setting);
        }

    }
}
