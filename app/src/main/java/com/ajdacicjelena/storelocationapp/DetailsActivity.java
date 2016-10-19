package com.ajdacicjelena.storelocationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.ajdacicjelena.storelocationapp.models.Store;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class DetailsActivity extends AppCompatActivity implements OnMapReadyCallback{
    private Store mStore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTextViewTitle = (TextView) findViewById(R.id.title);
        TextView mTextViewLocation = (TextView) findViewById(R.id.txtNameAddressCity);

        ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);

        Intent intent = getIntent();
        mStore = (Store) intent.getSerializableExtra("STORE");

        if (mTextViewTitle != null) mTextViewTitle.setText(mStore.getName());
        if (mTextViewLocation != null)
            mTextViewLocation.setText(getString(R.string.txt_name_address_city, mStore.getName(), mStore.getAddress(), mStore.getCity()));

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mStore.getLatitude(), mStore.getLongitude()), 15));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(mStore.getLatitude(), mStore.getLongitude()))
                .title(mStore.getName())).showInfoWindow();
    }
}
