package com.ajdacicjelena.storelocationapp.common.utils;


import com.ajdacicjelena.storelocationapp.models.Store;

public class ArrayUtils {

    public static Store getElementByName(Store[] stores, String name) {

        for (Store store : stores) {
            if (store.getName().equalsIgnoreCase(name)) return store;
        }

        return new Store();
    }
}
