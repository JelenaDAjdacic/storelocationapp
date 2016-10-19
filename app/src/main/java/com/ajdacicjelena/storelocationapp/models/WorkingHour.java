package com.ajdacicjelena.storelocationapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class WorkingHour implements Serializable{

    @SerializedName("mon")
    @Expose
    private String mon;
    @SerializedName("tue")
    @Expose
    private String tue;
    @SerializedName("wed")
    @Expose
    private String wed;
    @SerializedName("thu")
    @Expose
    private String thu;
    @SerializedName("fri")
    @Expose
    private String fri;
    @SerializedName("sat")
    @Expose
    private String sat;
    @SerializedName("sun")
    @Expose
    private String sun;

    /**
     * @return The mon
     */
    public String getMon() {
        return mon;
    }

    /**
     * @param mon The mon
     */
    private void setMon(String mon) {
        this.mon = mon;
    }

    /**
     * @return The tue
     */
    public String getTue() {
        return tue;
    }

    /**
     * @param tue The tue
     */
    private void setTue(String tue) {
        this.tue = tue;
    }

    /**
     * @return The wed
     */
    public String getWed() {
        return wed;
    }

    /**
     * @param wed The wed
     */
    private void setWed(String wed) {
        this.wed = wed;
    }

    /**
     * @return The thu
     */
    public String getThu() {
        return thu;
    }

    /**
     * @param thu The thu
     */
    private void setThu(String thu) {
        this.thu = thu;
    }

    /**
     * @return The fri
     */
    public String getFri() {
        return fri;
    }

    /**
     * @param fri The fri
     */
    private void setFri(String fri) {
        this.fri = fri;
    }

    /**
     * @return The sat
     */
    public String getSat() {
        return sat;
    }

    /**
     * @param sat The sat
     */
    private void setSat(String sat) {
        this.sat = sat;
    }

    /**
     * @return The sun
     */
    public String getSun() {
        return sun;
    }

    /**
     * @param sun The sun
     */
    private void setSun(String sun) {
        this.sun = sun;
    }

}

