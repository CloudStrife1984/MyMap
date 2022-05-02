package com.example.mymap;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mymap.databinding.ActivityMapsBinding;

import java.util.HashMap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

    private Marker sibeliusMonumenttiMarker;
    private Marker kauppaHalliMarker;
    private Marker temppelinaukionKirkkoMarker;


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        HashMap<String, String> markerMap  = new HashMap<String, String>();
        LatLng sibeliusMonu = new LatLng(60.18220387443046, 24.913411269701818);
        LatLng kauppaHalli = new LatLng(60.16636695115807, 24.952894547324437);
        LatLng temppeliKirkko = new LatLng(60.17293203738135, 24.925407906087493);
        LatLng alkuPosition = new LatLng(60.16859030562949, 24.93955258248535);

        sibeliusMonumenttiMarker = googleMap.addMarker(new MarkerOptions()
                .position(sibeliusMonu)
                .title("Sibelius monumentti")
                .snippet("Monumentti suomalaissäveltäjän kunniaksi")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        sibeliusMonumenttiMarker.setTag(0);
        String idOne = sibeliusMonumenttiMarker.getId();
        markerMap.put(idOne, "action_one");

        kauppaHalliMarker = googleMap.addMarker(new MarkerOptions()
                .position(kauppaHalli)
                .title("Vanha kauppahalli")
                .snippet("Muinaisten aikojen kauppapaikka")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        kauppaHalliMarker.setTag(0);
        String idtwo = kauppaHalliMarker.getId();
        markerMap.put(idtwo, "action_two");

        temppelinaukionKirkkoMarker = googleMap.addMarker(new MarkerOptions()
                .position(temppeliKirkko)
                .title("Temppelinaukion kirkko")
                .snippet("Hieno ja ikivanha kirkko")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
        );

        float zoom = 13.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(alkuPosition, zoom));
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setCompassEnabled(false);
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(false);
        uiSettings.setMapToolbarEnabled(true);
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {

                String actionId = markerMap.get(marker.getId());
                if(actionId.equals("action_one")){
                    Intent i = new Intent(MapsActivity.this, SibeliusInfo.class);
                    startActivity(i);
                }else if(actionId.equals("action_two")){
                    Intent i = new Intent(MapsActivity.this, kauppahalliInfo.class);
                    startActivity(i);

                }

                return false;
            }
        });





    }
}