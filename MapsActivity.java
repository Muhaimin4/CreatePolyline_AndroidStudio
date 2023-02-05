package com.min.myapplication;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync( this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng myhouse = new LatLng(-0.924360, 119.843341);
        mMap.addMarker(new MarkerOptions().position(myhouse).title("mark myhouse"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myhouse));
        LatLng stimik = new LatLng(-0.8866506,119.8752671);
        mMap.addMarker(new MarkerOptions().position(stimik).title("mark stimik"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(stimik));

        //custom size marker
        int tinggi = 120;
        int lebar = 120;
        BitmapDrawable bitmapstart = (BitmapDrawable) getResources().getDrawable(com.google.android.gms.base.R.drawable.googleg_standard_color_18);
        BitmapDrawable bitmapdes = (BitmapDrawable) getResources().getDrawable(com.google.android.gms.base.R.drawable.googleg_disabled_color_18);
        Bitmap s = bitmapstart.getBitmap();
        Bitmap d = bitmapdes.getBitmap();
        Bitmap markstart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markdes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        //add marker to map
        mMap.addMarker(new MarkerOptions().position(myhouse).title("mark myhouse")
                .snippet("ini rumahku")
                .icon(BitmapDescriptorFactory.fromBitmap(markstart)));
        mMap.addMarker(new MarkerOptions().position(stimik).title("mark kampus")
                .snippet("ini stimik")
                .icon(BitmapDescriptorFactory.fromBitmap(markdes)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stimik, 12));

        mMap.addPolyline(new PolylineOptions().add(
                myhouse,
                new LatLng(-0.924506, 119.843491),
                new LatLng(-0.924682, 119.844105),
                new LatLng(-0.923784, 119.844341),
                new LatLng(-0.921787, 119.844821),
                new LatLng(-0.921787, 119.844821),
                new LatLng(-0.922202, 119.856342),
                new LatLng(-0.914122, 119.856225),
                new LatLng(-0.908232, 119.856275),
                new LatLng(-0.904031, 119.857665),
                new LatLng(-0.901497, 119.858478),
                new LatLng(-0.896700, 119.860059),
                new LatLng(-0.898437, 119.863727),
                new LatLng(-0.897505, 119.867026),
                new LatLng(-0.897269, 119.868579),
                new LatLng(-0.896162, 119.869295),
                new LatLng(-0.896255, 119.871024),
                new LatLng(-0.896429, 119.872746),
                new LatLng(-0.896026, 119.873944),
                new LatLng(-0.893181, 119.874399),
                new LatLng(-0.891662, 119.874688),
                new LatLng(-0.889838, 119.874992),
                new LatLng(-0.887438, 119.875440),
                stimik).width(12).color(Color.RED));

    }
}