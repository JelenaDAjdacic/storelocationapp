package com.ajdacicjelena.storelocationapp.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.ajdacicjelena.storelocationapp.models.Store;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SharedPreferencesUtils {

    public static SharedPreferences.Editor getEditor(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return prefs.edit();
    }

    public static void clearSharedPreferences(Context context, String key) {

        SharedPreferences.Editor editor = getEditor(context, key);
        editor.remove(key);
        editor.apply();
    }
    public static void putArrayListStore(Context context, String key, Store[] mList) {

        SharedPreferences.Editor editor = getEditor(context, key);

        Gson gson = new Gson();
        String json = gson.toJson(mList);
        editor.putString(key, json);
        editor.commit();
    }

    public static Store[] getArrayListStore(Context context, String key) {

        SharedPreferences prefs = context.getSharedPreferences(key, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = prefs.getString(key, "");
        Type type = new TypeToken<Store[]>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
