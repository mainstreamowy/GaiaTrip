package com.example.dnl.gaiatrip;

import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

public class MapFragment extends Fragment {

    private static final int REQUEST_LOCATION_PERMISSION_CODE = 462;
    private MapView mapView;
    private LocationManager mLocationManager;

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        View mainView = getActivity().findViewById(R.id.fragment_name);
        TextView txt;
        txt= mainView.findViewById(R.id.fragment_name);
        txt.setText(R.string.map);
        mapView = (MapView) v.findViewById(R.id.map);

        mapView.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        final double lat=bundle.getDouble("LAT", -1);
        final double lng=bundle.getDouble("LONG",-1);
        mapView.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng coordinates = new LatLng(lat,lng);
                googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.defaultMarker())
                        .position(coordinates).title("Place"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 15));
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



}