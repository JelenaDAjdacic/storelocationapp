package com.ajdacicjelena.storelocationapp.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajdacicjelena.storelocationapp.R;
import com.ajdacicjelena.storelocationapp.models.Store;
import com.ajdacicjelena.storelocationapp.network.VolleySingleton;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class RecyclerViewStores extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Store[] stores;
    private Context context;

    private TextView mStoreDescription;
    private TextView mStoreName;
    private NetworkImageView mStoreLogo;

    private final RecyclerViewStores.OnItemClickListener listener;

    private class MyViewHolder extends RecyclerView.ViewHolder {

        MyViewHolder(View view) {
            super(view);

            mStoreName = (TextView) view.findViewById(R.id.storeName);
            mStoreLogo = (NetworkImageView) view.findViewById(R.id.storeLogo);
            mStoreDescription = (TextView) view.findViewById(R.id.short_description_txt);


        }

        void bind(final Store item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.onItemClick(item, itemView);
                }
            });
        }

    }


    public RecyclerViewStores(Context context, Store[] stores, OnItemClickListener listener) {
        this.stores = stores;
        this.context = context;
        this.listener = listener;
        setHasStableIds(true);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_short_description, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        holder.setIsRecyclable(false);

        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).bind(stores[position], listener);
            mStoreName.setText(stores[position].getName());
            mStoreDescription.setText(stores[position].getDescription());
            ImageLoader mImageLoader = VolleySingleton.getsInstance(context).getImageLoader();
            mStoreLogo.setImageUrl(stores[position].getPlaceImgUrl(), mImageLoader);
        }

    }

    @Override
    public int getItemCount() {
        return stores.length;
    }

    public interface OnItemClickListener {
        void onItemClick(Store item, View view);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
