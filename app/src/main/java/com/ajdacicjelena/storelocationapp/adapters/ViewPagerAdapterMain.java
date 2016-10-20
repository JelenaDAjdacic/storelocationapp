package com.ajdacicjelena.storelocationapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.ajdacicjelena.storelocationapp.DetailsActivity;
import com.ajdacicjelena.storelocationapp.MainActivity;
import com.ajdacicjelena.storelocationapp.common.utils.ArrayUtils;
import com.ajdacicjelena.storelocationapp.fragments.ListTabFragment;
import com.ajdacicjelena.storelocationapp.models.Store;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class ViewPagerAdapterMain extends FragmentStatePagerAdapter implements OnMapReadyCallback {
    private int mNumOfTabs;
    private Store[] stores;
    private Context context;

    public ViewPagerAdapterMain(FragmentManager fm, int NumOfTabs, Store[] stores, Context context) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.stores = stores;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new ListTabFragment();
            case 1:
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
        if (stores.length > 0) {
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(stores[0].getLatitude(), stores[0].getLongitude()), 12));
            googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    marker.showInfoWindow();
                    Log.d("CLICKED MARKER", marker.getTitle());
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("STORE", ArrayUtils.getElementByName(stores, marker.getTitle()));
                    ((MainActivity) context).startActivity(intent);
                    return true;
                }
            });

            for (Store store : stores) {
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(store.getLatitude(), store.getLongitude()))
                        .title(store.getName()));
            }
        }

    }
}
