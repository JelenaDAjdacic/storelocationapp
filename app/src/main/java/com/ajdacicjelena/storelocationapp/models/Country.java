package com.ajdacicjelena.storelocationapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Country implements Serializable{

    @SerializedName("name")
    @Expose
    private String name;

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    private void setName(String name) {
        this.name = name;
    }

}
