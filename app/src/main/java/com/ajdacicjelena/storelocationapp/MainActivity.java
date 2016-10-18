package com.ajdacicjelena.storelocationapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.ajdacicjelena.storelocationapp.adapters.RecyclerViewStores;
import com.ajdacicjelena.storelocationapp.common.config.AppConfig;
import com.ajdacicjelena.storelocationapp.common.utils.SharedPreferencesUtils;
import com.ajdacicjelena.storelocationapp.dialogs.ProgressDialogCustom;
import com.ajdacicjelena.storelocationapp.models.Store;
import com.ajdacicjelena.storelocationapp.network.PullWebContent;
import com.ajdacicjelena.storelocationapp.network.UrlEndpoints;
import com.ajdacicjelena.storelocationapp.network.VolleySingleton;
import com.ajdacicjelena.storelocationapp.network.WebRequestCallbackInterface;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private VolleySingleton mVolleySingleton;
    private String TAG = "MainActivity";
    private Store[] mStores;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVolleySingleton = VolleySingleton.getsInstance(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager;
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mLayoutManager.setAutoMeasureEnabled(true);
        if (mRecyclerView != null) mRecyclerView.setLayoutManager(mLayoutManager);

        getAllStoresLocation();

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
                    setStoresLocationList(getLocationsList());
                    Log.d(TAG, "INTERNET " + getLocationsList().length);

                }
            }

            @Override
            public void webRequestError(String error) {
                Log.d(TAG, "Error");
                //load data from Shared Preferences
                if (SharedPreferencesUtils.getArrayListStore(getApplicationContext(), AppConfig.LIST_STORAGE_KEY) != null) {
                    setLocationsList(SharedPreferencesUtils.getArrayListStore(getApplicationContext(), AppConfig.LIST_STORAGE_KEY));
                    Log.d(TAG, "NO_INTERNET " + getLocationsList().length);
                    setStoresLocationList(getLocationsList());
                } else {
                    setLocationsList(new Store[]{});
                    Log.d(TAG, "NO_INTERNET_EMPTY_SHARED_PREFERENCES " + getLocationsList().length);
                    setStoresLocationList(getLocationsList());

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

    private void setStoresLocationList(Store[] stores) {
        RecyclerViewStores mAdapter = new RecyclerViewStores(this, stores, new RecyclerViewStores.OnItemClickListener() {

            @Override
            public void onItemClick(Store item, View view) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
