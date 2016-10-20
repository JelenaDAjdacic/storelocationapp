package com.ajdacicjelena.storelocationapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajdacicjelena.storelocationapp.DetailsActivity;
import com.ajdacicjelena.storelocationapp.R;

public class DescriptionTabFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(R.layout.fragment_description, container, false);
        TextView descriptionTextView = (TextView) view.findViewById(R.id.txtDescription);
        descriptionTextView.setText(((DetailsActivity) getActivity()).getStoreInfo().getDescription());
        return view;
    }
}
