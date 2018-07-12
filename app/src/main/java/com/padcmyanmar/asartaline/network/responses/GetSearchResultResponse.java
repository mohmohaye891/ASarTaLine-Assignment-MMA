package com.padcmyanmar.asartaline.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.asartaline.data.vos.SearchResultsVO;

import java.util.List;

public class GetSearchResultResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("tasteType")
    private String tasteType;

    @SerializedName("suited")
    private String suited;

    @SerializedName("minPrice")
    private String minPrice;

    @SerializedName("maxPrice")
    private String maxPrice;

    @SerializedName("isNearBy")
    private Boolean isNearBy;

    @SerializedName("currentTownship")
    private String currentTownship;

    @SerializedName("currentTLat")
    private Integer currentTLat;

    @SerializedName("currentLng")
    private Integer currentLng;

    @SerializedName("searchResults")
    private List<SearchResultsVO> searchResults;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getTasteType() {
        return tasteType;
    }

    public String getSuited() {
        return suited;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public Boolean getNearBy() {
        return isNearBy;
    }

    public String getCurrentTownship() {
        return currentTownship;
    }

    public Integer getCurrentTLat() {
        return currentTLat;
    }

    public Integer getCurrentLng() {
        return currentLng;
    }

    public List<SearchResultsVO> getSearchResults() {
        return searchResults;
    }
}
