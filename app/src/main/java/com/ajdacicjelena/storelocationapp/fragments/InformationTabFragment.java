package com.ajdacicjelena.storelocationapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajdacicjelena.storelocationapp.DetailsActivity;
import com.ajdacicjelena.storelocationapp.R;


public class InformationTabFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(R.layout.fragment_information, container, false);

        TextView mTextViewMondayWorkingHours = (TextView) view.findViewById(R.id.textView_working_hours_monday);
        TextView mTextViewTuesdayWorkingHours = (TextView) view.findViewById(R.id.textView_working_hours_tuesday);
        TextView mTextViewWednesdayWorkingHours = (TextView) view.findViewById(R.id.textView_working_hours_wednesday);
        TextView mTextViewThursdayWorkingHours = (TextView) view.findViewById(R.id.textView_working_hours_thursday);
        TextView mTextViewFridayWorkingHours = (TextView) view.findViewById(R.id.textView_working_hours_friday);
        TextView mTextViewSaturdayWorkingHours = (TextView) view.findViewById(R.id.textView_working_hours_saturday);
        TextView mTextViewSundayWorkingHours = (TextView) view.findViewById(R.id.textView_working_hours_sunday);

        TextView mTextViewMondayRepertoire = (TextView) view.findViewById(R.id.textView_repertoire_monday);
        TextView mTextViewTuesdayRepertoire = (TextView) view.findViewById(R.id.textView_repertoire_tuesday);
        TextView mTextViewWednesdayRepertoire = (TextView) view.findViewById(R.id.textView_repertoire_wednesday);
        TextView mTextViewThursdayRepertoire = (TextView) view.findViewById(R.id.textView_repertoire_thursday);
        TextView mTextViewFridayRepertoire = (TextView) view.findViewById(R.id.textView_repertoire_friday);
        TextView mTextViewSaturdayRepertoire = (TextView) view.findViewById(R.id.textView_repertoire_saturday);
        TextView mTextViewSundayRepertoire = (TextView) view.findViewById(R.id.textView_repertoire_sunday);

        if (mTextViewMondayWorkingHours != null) {

            mTextViewMondayWorkingHours.setText(((DetailsActivity) getActivity()).getStoreInfo().getWorkingHour().getMon());

        }
        if (mTextViewTuesdayWorkingHours != null) {

            mTextViewTuesdayWorkingHours.setText(((DetailsActivity) getActivity()).getStoreInfo().getWorkingHour().getTue());

        }
        if (mTextViewWednesdayWorkingHours != null) {

            mTextViewWednesdayWorkingHours.setText(((DetailsActivity) getActivity()).getStoreInfo().getWorkingHour().getWed());

        }
        if (mTextViewThursdayWorkingHours != null) {

            mTextViewThursdayWorkingHours.setText(((DetailsActivity) getActivity()).getStoreInfo().getWorkingHour().getThu());

        }
        if (mTextViewFridayWorkingHours != null) {

            mTextViewFridayWorkingHours.setText(((DetailsActivity) getActivity()).getStoreInfo().getWorkingHour().getFri());

        }
        if (mTextViewSaturdayWorkingHours != null) {

            mTextViewSaturdayWorkingHours.setText(((DetailsActivity) getActivity()).getStoreInfo().getWorkingHour().getSat());

        }
        if (mTextViewSundayWorkingHours != null) {

            mTextViewSundayWorkingHours.setText(((DetailsActivity) getActivity()).getStoreInfo().getWorkingHour().getSun());

        }
        if (mTextViewMondayRepertoire != null && ((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getMonday().length() > 0) {

            mTextViewMondayRepertoire.setText(((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getMonday());

        }
        if (mTextViewTuesdayRepertoire != null && ((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getTuesday().length() > 0l) {

            mTextViewTuesdayRepertoire.setText(((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getTuesday());

        }
        if (mTextViewWednesdayRepertoire != null && ((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getWednesday().length() > 0) {

            mTextViewWednesdayRepertoire.setText(((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getWednesday());

        }
        if (mTextViewThursdayRepertoire != null && ((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getThursday().length() > 0) {

            mTextViewThursdayRepertoire.setText(((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getThursday());

        }
        if (mTextViewFridayRepertoire != null && ((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getFriday().length() > 0) {

            mTextViewFridayRepertoire.setText(((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getFriday());

        }
        if (mTextViewSaturdayRepertoire != null && ((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getSaturday().length() > 0) {

            mTextViewSaturdayRepertoire.setText(((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getSaturday());

        }
        if (mTextViewSundayRepertoire != null && ((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getSunday().length() > 0) {

            mTextViewSundayRepertoire.setText(((DetailsActivity) getActivity()).getStoreInfo().getRepertoire().getSunday());

        }
        return view;
    }
}
