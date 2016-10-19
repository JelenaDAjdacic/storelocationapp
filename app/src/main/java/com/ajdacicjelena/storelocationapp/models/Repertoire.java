package com.ajdacicjelena.storelocationapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Repertoire implements Serializable{

    @SerializedName("monday")
    @Expose
    private String monday;
    @SerializedName("tuesday")
    @Expose
    private String tuesday;
    @SerializedName("wednesday")
    @Expose
    private String wednesday;
    @SerializedName("thursday")
    @Expose
    private String thursday;
    @SerializedName("friday")
    @Expose
    private String friday;
    @SerializedName("saturday")
    @Expose
    private String saturday;
    @SerializedName("sunday")
    @Expose
    private String sunday;

    /**
     * @return The monday
     */
    public String getMonday() {
        return monday;
    }

    /**
     * @param monday The monday
     */
    private void setMonday(String monday) {
        this.monday = monday;
    }

    /**
     * @return The tuesday
     */
    public String getTuesday() {
        return tuesday;
    }

    /**
     * @param tuesday The tuesday
     */
    private void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * @return The wednesday
     */
    public String getWednesday() {
        return wednesday;
    }

    /**
     * @param wednesday The wednesday
     */
    private void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * @return The thursday
     */
    public String getThursday() {
        return thursday;
    }

    /**
     * @param thursday The thursday
     */
    private void setThursday(String thursday) {
        this.thursday = thursday;
    }

    /**
     * @return The friday
     */
    public String getFriday() {
        return friday;
    }

    /**
     * @param friday The friday
     */
    private void setFriday(String friday) {
        this.friday = friday;
    }

    /**
     * @return The saturday
     */
    public String getSaturday() {
        return saturday;
    }

    /**
     * @param saturday The saturday
     */
    private void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    /**
     * @return The sunday
     */
    public String getSunday() {
        return sunday;
    }

    /**
     * @param sunday The sunday
     */
    private void setSunday(String sunday) {
        this.sunday = sunday;
    }

}