package com.ajdacicjelena.storelocationapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ajdacicjelena.storelocationapp.common.config.AppConfig;
import com.ajdacicjelena.storelocationapp.common.utils.SharedPreferencesUtils;
import com.ajdacicjelena.storelocationapp.dialogs.ProgressDialogCustom;
import com.ajdacicjelena.storelocationapp.fragments.ListTabFragment;
import com.ajdacicjelena.storelocationapp.models.Store;
import com.ajdacicjelena.storelocationapp.network.PullWebContent;
import com.ajdacicjelena.storelocationapp.network.UrlEndpoints;
import com.ajdacicjelena.storelocationapp.network.VolleySingleton;
import com.ajdacicjelena.storelocationapp.network.WebRequestCallbackInterface;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private VolleySingleton mVolleySingleton;
    private String TAG = "MainActivity";
    private Store[] mStores;
    MapFragment mapTabFragment;
    ListTabFragment listTabFragment;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVolleySingleton = VolleySingleton.getsInstance(this);


        getAllStoresLocation();
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setCurrentTabFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    //get json with list of store locations
    private void getAllStoresLocation() {

        //progress dialog initialization
        final ProgressDialogCustom progressDialog = new ProgressDialogCustom(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.showDialog(getString(R.string.txt_loading));

        //get request
        PullWebContent<Store[]> content = new PullWebContent<>(Store[].class, UrlEndpoints.getRequestAll(), mVolleySingleton);
        content.setCallbackListener(new WebRequestCallbackInterface<Store[]>() {
            @Override
            public void webRequestSuccess(boolean success, Store[] allStores) {
                if (success) {
                    Log.d(TAG, "" + allStores.length);
                    SharedPreferencesUtils.putArrayListStore(getApplicationContext(), AppConfig.LIST_STORAGE_KEY, allStores);
                    setLocationsList(allStores);
                    progressDialog.hideDialog();
                    Log.d(TAG, "INTERNET " + getLocationsList().length);
                    setupTabLayout();
                }
            }

            @Override
            public void webRequestError(String error) {
                Log.d(TAG, "Error");
                //load data from Shared Preferences
                if (SharedPreferencesUtils.getArrayListStore(getApplicationContext(), AppConfig.LIST_STORAGE_KEY) != null) {
                    setLocationsList(SharedPreferencesUtils.getArrayListStore(getApplicationContext(), AppConfig.LIST_STORAGE_KEY));
                    Log.d(TAG, "NO_INTERNET " + getLocationsList().length);
                    setupTabLayout();

                } else {
                    setLocationsList(new Store[]{});
                    setupTabLayout();
                    Log.d(TAG, "NO_INTERNET_EMPTY_SHARED_PREFERENCES " + getLocationsList().length);

                }
                progressDialog.hideDialog();
            }
        });
        content.pullList();
    }

    private void setLocationsList(Store[] allStores) {
        mStores = allStores;
    }

    public Store[] getLocationsList() {
        return mStores;
    }

    private void setupTabLayout() {
        mapTabFragment = new MapFragment();
        mapTabFragment.getMapAsync(this);
        listTabFragment = new ListTabFragment();
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.txt_list)), true);
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.txt_map)));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void setCurrentTabFragment(int tabPosition) {
        switch (tabPosition) {
            case 0:
                replaceFragment(listTabFragment);
                break;
            case 1:
                mapTabFragment.getMapAsync(this);
                replaceFragment(mapTabFragment);
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (getLocationsList().length > 0) {
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(getLocationsList()[0].getLatitude(), getLocationsList()[0].getLongitude()), 12));
            googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    marker.showInfoWindow();
                    Log.d("CLICKED MARKER", marker.getTitle());
                    return true;
                }
            });

            for (int i = 0; i < getLocationsList().length; i++) {
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(getLocationsList()[i].getLatitude(), getLocationsList()[i].getLongitude()))
                        .title(getLocationsList()[i].getName()));
            }
        }
    }
}
