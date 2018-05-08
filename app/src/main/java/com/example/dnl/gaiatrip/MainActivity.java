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
    private Fragment fragment = null;
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

        fragment=new NewsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       fragment = null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        TextView textView = findViewById(R.id.fragment_name);

        switch(id)
        {
            case R.id.nav_news:
                textView.setText(R.string.news);
                Log.d("GUI", "User Pressed News Button!");
                /*
                Intent detailsIntent = new Intent(MainActivity.this, MainActivity.class);
                detailsIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(detailsIntent);
                //
                Intent intentMain = new Intent(getApplicationContext() ,
                        MainActivity.class);
                if(fragment!=null){
                    fragment.getActivity().startActivity(intentMain);
                }
                else{
                    this.startActivity(intentMain);
                }
*/              fragment= new NewsFragment();
                Log.i("Content "," Main layout ");
                break;

            case R.id.nav_top_places:
                textView.setText(R.string.top_places);
                Log.d("GUI", "User Pressed Top Places Button!");
                fragment = new TopPlacesFragment();
                break;

            case R.id.nav_map:
                textView.setText(R.string.map);
                Log.d("GUI", "User Pressed Map Button!");
                fragment = new MapFragment();
                break;

            case R.id.nav_discover:
                textView.setText(R.string.discover);
                Log.d("GUI", "User Pressed Discover Button!");
                fragment = new DiscoverFragment(); // As dummy Fragment
                break;

            case R.id.nav_near_you:
                textView.setText(R.string.near_you);
                Log.d("GUI", "User Pressed Near You Button!");
                fragment = new NearYouFragment();
                break;

            case R.id.nav_settings:
                textView.setText(R.string.settings);
                Log.d("GUI", "User Pressed Settings Button!");
                fragment = new SettingsFragment();
                break;

            default: break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
