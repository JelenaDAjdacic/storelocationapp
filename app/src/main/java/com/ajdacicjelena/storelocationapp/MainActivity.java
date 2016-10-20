package com.ajdacicjelena.storelocationapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.ajdacicjelena.storelocationapp.adapters.ViewPagerAdapterMain;
import com.ajdacicjelena.storelocationapp.common.config.AppConfig;
import com.ajdacicjelena.storelocationapp.common.utils.SharedPreferencesUtils;
import com.ajdacicjelena.storelocationapp.dialogs.ProgressDialogCustom;
import com.ajdacicjelena.storelocationapp.models.Store;
import com.ajdacicjelena.storelocationapp.network.PullWebContent;
import com.ajdacicjelena.storelocationapp.network.UrlEndpoints;
import com.ajdacicjelena.storelocationapp.network.VolleySingleton;
import com.ajdacicjelena.storelocationapp.network.WebRequestCallbackInterface;

public class MainActivity extends AppCompatActivity {
    private VolleySingleton mVolleySingleton;
    private String TAG = "MainActivity";
    private Store[] mStores;
    private TabLayout mTabLayout;
    private LinearLayout layout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.activity_main);

        mVolleySingleton = VolleySingleton.getsInstance(this);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


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
                    Snackbar.make(layout, getString(R.string.txt_no_connection), Snackbar.LENGTH_LONG)
                            .show();

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

        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.txt_list)), true);
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.txt_map)));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPagerAdapterMain adapter = new ViewPagerAdapterMain(getSupportFragmentManager(), 2,
                getLocationsList(), this);

        mViewPager.setAdapter(adapter);
    }


}
