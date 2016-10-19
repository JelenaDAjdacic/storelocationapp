package com.ajdacicjelena.storelocationapp.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajdacicjelena.storelocationapp.DetailsActivity;
import com.ajdacicjelena.storelocationapp.MainActivity;
import com.ajdacicjelena.storelocationapp.R;
import com.ajdacicjelena.storelocationapp.adapters.RecyclerViewStores;
import com.ajdacicjelena.storelocationapp.models.Store;

public class ListTabFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);


        Activity activity = getActivity();

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        mRecyclerView.setNestedScrollingEnabled(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerViewStores mAdapter = new RecyclerViewStores(activity, ((MainActivity) activity).getLocationsList(), new RecyclerViewStores.OnItemClickListener() {
            @Override
            public void onItemClick(Store item, View view) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("STORE", item);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }
}
