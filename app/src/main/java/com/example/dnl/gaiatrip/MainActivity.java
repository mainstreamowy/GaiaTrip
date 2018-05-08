package com.example.dnl.gaiatrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar mainToolBar;

    private LayoutInflater inflater;

    private TextView fragment_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        // Main Toolbar
        mainToolBar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


        // Adding Rear Panel
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mainToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View mainBarView = navigationView.getHeaderView(0);




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        TextView textView = findViewById(R.id.fragment_name);

        switch(id)
        {
            case R.id.nav_news:
                textView.setText("NEWS");
                Log.d("GUI", "User Pressed Add Songs Button!");
           //     fragment = new AddSongsFragment();
                break;

            case R.id.nav_top_places:
                textView.setText("TOP PLACES");
                Log.d("GUI", "User Pressed My library Button!");
                fragment = new TopPlacesFragment();
                break;

            case R.id.nav_map:
                textView.setText("MAP");
                Log.d("GUI", "User Pressed Explore Button!");
                fragment = new MapFragment();
                break;

            case R.id.nav_discover:
                textView.setText("DISCOVER");
                Log.d("GUI", "User Pressed My Songs Button!");
                fragment = new DiscoverFragment(); // As dummy Fragment
                break;

            case R.id.nav_near_you:
                textView.setText("NEAR YOU");
                fragment = new NearYouFragment();
                break;

            case R.id.nav_settings:
                textView.setText("SETTINGS");
                fragment = new SettingsFragment();
                break;

            default: break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
