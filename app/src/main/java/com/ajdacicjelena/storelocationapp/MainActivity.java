package com.ajdacicjelena.storelocationapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ajdacicjelena.storelocationapp.dialogs.ProgressDialogCustom;
import com.ajdacicjelena.storelocationapp.models.Store;
import com.ajdacicjelena.storelocationapp.network.PullWebContent;
import com.ajdacicjelena.storelocationapp.network.UrlEndpoints;
import com.ajdacicjelena.storelocationapp.network.VolleySingleton;
import com.ajdacicjelena.storelocationapp.network.WebRequestCallbackInterface;

public class MainActivity extends AppCompatActivity {
    private VolleySingleton mVolleySingleton;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVolleySingleton = VolleySingleton.getsInstance(this);
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
                    progressDialog.hideDialog();

                }
            }

            @Override
            public void webRequestError(String error) {
                Log.d(TAG, "Error");
                //load data from Shared Preferences
                progressDialog.hideDialog();
            }
        });
        content.pullList();
    }

}
