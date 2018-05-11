package com.example.dnl.gaiatrip;


import android.content.Context;
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

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar mainToolBar;


    private LayoutInflater inflater;
    private Realm realm;
    private TextView fragment_name;
    private Fragment fragment = null;
    Place place1 = new Place(R.drawable.clube,"iClube Náutico de Crestuma",
            "The 30-year-old Clube Náutico de Crestuma presents itself with a new direction, formed by athletes of the club, having as one of the objectives the formation of new champions and to make the club in a place where everybody is welcome, and where different generations can fraternize and exchange experiences. Over the last 30 years, the Crestuma Nautical Club has greatly contributed to the evolution of national canoeing, being seen as a motor of development of this sport, forming high level athletes and at the same time contributing to the personal training of these same athletes.",
            "entertainment",
            41.069172, -8.503402);
    Place place2 =new Place(R.drawable.afurada,"Afurada",
            "Afurada, has become fast the main fishing center of Vila Nova de Gaia, with the massive capture of sardines and lamprey. In this zone it is possible to identify the typical personality of the people residing in Vila Nova de Gaia, due to being a place where there is a population density, with all the neighbourhood’s, that grew with the customs of the region\n" +
                    "There is also a shop there where it is possible to rent bicycles and take advantage of the existing bike path that begins in Afurada and goes to Espinho, almost always along the seafront.",
            "entertainment",
            41.144492, -8.643944);
    Place place3 = new Place(R.drawable.parque,"Parque da Lavandeira",
            "This park offers visitors various leisure options, such as pedestrian paths, theme gardens, children's playgrounds and picnic areas. The proposal, in future terms, will be the construction of a city park that includes sports, catering and leisure facilities. It will be done in two phases, the first will be carried out by the Biological Park, where the green area will be rehabilitated, for the construction of maintenance routes, circuits and leisure areas; and the second phase, called the \"Sports Area\", where the area already constructed will be used and improved.",
            "entertainment",
            41.097323, -8.556075);
    Place place4 = new Place(R.drawable.armazem,"Armazém do peixe",
            "Seafood, Mediterranean, European",
            "food",
            41.142710, -8.647187);
    Place place5= new Place(R.drawable.maravista,"Mar à Vista",
            "Seafood, Mediterranean, European",
            "food",
            41.122424, -8.666534);
    Place place6 = new Place(R.drawable.rabelos,"Rabelos",
            "Mediterranean, Portuguese, Internacional",
            "food",
            41.137638, -8.614246);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        realm.copyToRealm(place1);
        realm.copyToRealm(place2);
        realm.copyToRealm(place3);
        realm.copyToRealm(place4);
        realm.copyToRealm(place5);
        realm.copyToRealm(place6);

        realm.commitTransaction();


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

                 fragment= new NewsFragment();
                Log.i("Content "," Main layout ");
                break;

            case R.id.nav_top_places:
                textView.setText(R.string.top_places);
                Log.d("GUI", "User Pressed Top Places Button!");
                fragment = new TopPlacesFragment();
                break;


            case R.id.nav_discover:
                textView.setText(R.string.discover);
                Log.d("GUI", "User Pressed Discover Button!");
                fragment = new DiscoverFragment(); // As dummy Fragment
                break;

            case R.id.nav_places:
                textView.setText(R.string.places);
                Log.d("GUI", "User Pressed Near You Button!");
                fragment = new ListFragment();
                Bundle arguments = new Bundle();
                fragment.setArguments(arguments);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
            realm.close();
    }
}
