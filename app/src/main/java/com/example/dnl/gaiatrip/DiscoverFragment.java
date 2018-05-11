package com.example.dnl.gaiatrip;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import static android.content.Context.LOCATION_SERVICE;

public class DiscoverFragment extends Fragment implements View.OnClickListener{



    private static final int REQUEST_LOCATION_PERMISSION_CODE = 462;
    private MapView mapView;
    private LocationManager mLocationManager;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_discover, container, false);

        mapView = (MapView) v.findViewById(R.id.map);

        ImageButton foodButton;
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng coordinates = new LatLng(41.069172, -8.503402);
                googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.defaultMarker())
                        .position(coordinates).title("iClube Náutico de Crestuma"));
                LatLng coordinates2 = new LatLng(41.144492, -8.643944);
                googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.defaultMarker())
                        .position(coordinates2).title("Afurada"));
                LatLng coordinates3 = new LatLng(41.097323, -8.556075);
                googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.defaultMarker())
                        .position(coordinates3).title("Parque da Lavandeira"));
                LatLng coordinates4 = new LatLng(41.142710, -8.647187);
                googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.defaultMarker())
                        .position(coordinates4).title("Armazém do peixe"));
                LatLng coordinates5 = new LatLng(41.122424, -8.666534);
                googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.defaultMarker())
                        .position(coordinates5).title("Mar à Vista"));
                LatLng coordinates6 = new LatLng(41.137638, -8.614246);
                googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.defaultMarker())
                        .position(coordinates6).title("Rabelos"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates4, 15));
                mapView.onResume();

                if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                googleMap.getUiSettings().setMyLocationButtonEnabled(true);
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                MapsInitializer.initialize(getActivity());
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                builder.include(coordinates);
                builder.include(new LatLng(41.124009, -8.614851));
                LatLngBounds bounds = builder.build();
                int padding = 100;
                // Updates the location and zoom of the MapView
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                googleMap.moveCamera(cameraUpdate);
            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.food_button:


        }
    }

}