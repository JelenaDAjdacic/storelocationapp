package com.ajdacicjelena.storelocationapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Store {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("countryId")
    @Expose
    private Integer countryId;
    @SerializedName("webSite")
    @Expose
    private String webSite;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("accountType")
    @Expose
    private Integer accountType;
    @SerializedName("addDate")
    @Expose
    private String addDate;
    @SerializedName("placeGroupId")
    @Expose
    private Integer placeGroupId;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("working")
    @Expose
    private Boolean working;
    @SerializedName("promotion")
    @Expose
    private String promotion;
    @SerializedName("repertoire")
    @Expose
    private Repertoire repertoire;
    @SerializedName("workingHour")
    @Expose
    private WorkingHour workingHour;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("reviewNum")
    @Expose
    private Integer reviewNum;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("placeImgUrl")
    @Expose
    private String placeImgUrl;

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    private void setId(Integer id) {
        this.id = id;
    }

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

    /**
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    private void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return The city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city The city
     */
    private void setCity(String city) {
        this.city = city;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    private void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The countryId
     */
    public Integer getCountryId() {
        return countryId;
    }

    /**
     * @param countryId The countryId
     */
    private void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    /**
     * @return The webSite
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * @param webSite The webSite
     */
    private void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    /**
     * @return The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    private void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return The accountType
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * @param accountType The accountType
     */
    private void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * @return The addDate
     */
    public String getAddDate() {
        return addDate;
    }

    /**
     * @param addDate The addDate
     */
    private void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    /**
     * @return The placeGroupId
     */
    public Integer getPlaceGroupId() {
        return placeGroupId;
    }

    /**
     * @param placeGroupId The placeGroupId
     */
    private void setPlaceGroupId(Integer placeGroupId) {
        this.placeGroupId = placeGroupId;
    }

    /**
     * @return The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude The longitude
     */
    private void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude The latitude
     */
    private void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return The distance
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * @param distance The distance
     */
    private void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * @return The working
     */
    public Boolean getWorking() {
        return working;
    }

    /**
     * @param working The working
     */
    private void setWorking(Boolean working) {
        this.working = working;
    }

    /**
     * @return The promotion
     */
    public String getPromotion() {
        return promotion;
    }

    /**
     * @param promotion The promotion
     */
    private void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    /**
     * @return The repertoire
     */
    public Repertoire getRepertoire() {
        return repertoire;
    }

    /**
     * @param repertoire The repertoire
     */
    private void setRepertoire(Repertoire repertoire) {
        this.repertoire = repertoire;
    }

    /**
     * @return The workingHour
     */
    public WorkingHour getWorkingHour() {
        return workingHour;
    }

    /**
     * @param workingHour The workingHour
     */
    private void setWorkingHour(WorkingHour workingHour) {
        this.workingHour = workingHour;
    }

    /**
     * @return The country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    private void setCountry(Country country) {
        this.country = country;
    }

    /**
     * @return The reviewNum
     */
    public Integer getReviewNum() {
        return reviewNum;
    }

    /**
     * @param reviewNum The reviewNum
     */
    private void setReviewNum(Integer reviewNum) {
        this.reviewNum = reviewNum;
    }

    /**
     * @return The score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score The score
     */
    private void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return The placeImgUrl
     */
    public String getPlaceImgUrl() {
        return placeImgUrl;
    }

    /**
     * @param placeImgUrl The placeImgUrl
     */
    private void setPlaceImgUrl(String placeImgUrl) {
        this.placeImgUrl = placeImgUrl;
    }

}