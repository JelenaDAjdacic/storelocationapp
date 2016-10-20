package com.ajdacicjelena.storelocationapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ajdacicjelena.storelocationapp.adapters.ViewPagerAdapterDetails;
import com.ajdacicjelena.storelocationapp.common.config.AppConfig;
import com.ajdacicjelena.storelocationapp.models.Store;
import com.ajdacicjelena.storelocationapp.network.VolleySingleton;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.google.android.gms.maps.model.LatLng;


public class DetailsActivity extends AppCompatActivity {
    private Store mStore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        mStore = (Store) intent.getSerializableExtra(AppConfig.INTENT_STORE_EXTRA_KEY);


        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTextViewTitle = (TextView) findViewById(R.id.title);
        TextView mTextViewLocation = (TextView) findViewById(R.id.textView_name_address_city);
        TextView mTextViewWebAddress = (TextView) findViewById(R.id.textView_web_site);
        TextView mTextViewReviewNumber = (TextView) findViewById(R.id.textView_review);
        TextView mTextViewOpen = (TextView) findViewById(R.id.textView_open);
        TextView mTextViewDistance = (TextView) findViewById(R.id.textView_distance);
        TextView mTextViewPromotion = (TextView) findViewById(R.id.textView_promotion);
        TextView mTextViewId = (TextView) findViewById(R.id.textView_id);


        RatingBar mRatingBar;

        NetworkImageView mStoreLogo = (NetworkImageView) findViewById(R.id.storeLogoDetail);
        ImageLoader mImageLoader = VolleySingleton.getsInstance(this).getImageLoader();
        mStoreLogo.setImageUrl(mStore.getPlaceImgUrl(), mImageLoader);

        TabLayout mTabLayout = (TabLayout) findViewById(R.id.location_details_tab);
        if (mTabLayout != null) {
            mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.txt_information)), true);
            mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.txt_description)));
            mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.txt_map)));
            mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

            final ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager_one_article);
            final ViewPagerAdapterDetails adapter = new ViewPagerAdapterDetails(getSupportFragmentManager(), 3,
                    new LatLng(getStoreInfo().getLatitude(), getStoreInfo().getLongitude()), getStoreInfo().getName());
            mViewPager.setAdapter(adapter);
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
                    mViewPager.setCurrentItem(tab.getPosition());

                }
            });
            mViewPager.setOffscreenPageLimit(2);

            if (mTextViewTitle != null) mTextViewTitle.setText(mStore.getName());
            if (mTextViewLocation != null)
                mTextViewLocation.setText(getString(R.string.txt_name_address_city, mStore.getName(), mStore.getAddress(), mStore.getCity()));

            if (mTextViewWebAddress != null) {
                if (mStore.getWebSite().length() > 0) {
                    mTextViewWebAddress.setText(mStore.getWebSite());
                    mTextViewWebAddress.setMovementMethod(LinkMovementMethod.getInstance());
                } else mTextViewWebAddress.setVisibility(View.GONE);
            }
            if (mTextViewReviewNumber != null) {
                mTextViewReviewNumber.setText(getString(R.string.txt_review_number, mStore.getReviewNum().toString()));
            }
            if (mTextViewOpen != null) {
                if (mStore.getWorking()) {
                    mTextViewOpen.setText(getString(R.string.txt_open));
                    mTextViewOpen.setTextColor(Color.GREEN);
                } else {
                    mTextViewOpen.setText(getString(R.string.txt_close));
                    mTextViewOpen.setTextColor(Color.RED);
                }
            }
            if (mTextViewDistance != null) {

                mTextViewDistance.setText(getString(R.string.txt_distance, mStore.getDistance()));

            }
            if (mTextViewPromotion != null && mStore.getPromotion().length() > 0) {

                mTextViewPromotion.setText(getString(R.string.txt_promotion, mStore.getPromotion()));

            }
            if (mTextViewId != null) {

                mTextViewId.setText(getString(R.string.txt_id, mStore.getId()));

            }

            mRatingBar = (RatingBar) findViewById(R.id.ratingBar_stars);
            if (mRatingBar != null) mRatingBar.setRating(mStore.getScore());

            setSupportActionBar(mToolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("");
            }

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
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


    public Store getStoreInfo() {
        return mStore;
    }
}
