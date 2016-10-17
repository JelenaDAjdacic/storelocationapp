package com.ajdacicjelena.storelocationapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Stores {
    @SerializedName("")
    @Expose
    private List<Store> stores = new ArrayList<Store>();

    /**
     * @return The success
     */
    public List<Store> getStores() {
        return stores;
    }
}
