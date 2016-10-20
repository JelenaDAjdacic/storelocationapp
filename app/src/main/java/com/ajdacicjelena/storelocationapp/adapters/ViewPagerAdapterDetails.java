package com.ajdacicjelena.storelocationapp.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ajdacicjelena.storelocationapp.fragments.DescriptionTabFragment;
import com.ajdacicjelena.storelocationapp.fragments.InformationTabFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ViewPagerAdapterDetails extends FragmentStatePagerAdapter implements OnMapReadyCallback {

    private int mNumOfTabs;
    private LatLng latLng;
    private String name;

    public ViewPagerAdapterDetails(FragmentManager fm, int NumOfTabs, LatLng latLng, String name) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.latLng = latLng;
        this.name = name;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new InformationTabFragment();
            case 1:
                return new DescriptionTabFragment();
            case 2:
                SupportMapFragment mapFragment = new SupportMapFragment();
                mapFragment.getMapAsync(this);
                return mapFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        googleMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(name)).showInfoWindow();


    }
}
