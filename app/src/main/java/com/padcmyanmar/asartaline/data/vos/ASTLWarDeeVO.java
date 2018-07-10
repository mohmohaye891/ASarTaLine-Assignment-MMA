package com.padcmyanmar.asartaline.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ASTLWarDeeVO {

    @SerializedName("warDeeId")
    private String warDeeId;

    @SerializedName("name")
    private String name;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("generalTaste")
    private List<GeneralTasteVO> generalTaste;

    @SerializedName("suitedFor")
    private List<SuitedForVO> suitedFor;

    @SerializedName("priceRangeMin")
    private String priceRangeMin;

    @SerializedName("priceRangeMax")
    private String priceRangeMax;

    @SerializedName("matchWarDeeList")
    private List<MatchWarDeeListVO> matchWarDeeList;

    @SerializedName("shopByDistance")
    private List<ShopByDistanceVO> shopByDistance;

    @SerializedName("shopByPopularity")
    private List<ShipByPopularityVO> shipByPopularity;

    public String getWarDeeId() {
        return warDeeId;
    }

    public String getName() {
        return name;
    }

    public List<String> getImages() {
        return images;
    }

    public List<GeneralTasteVO> getGeneralTaste() {
        return generalTaste;
    }

    public List<SuitedForVO> getSuitedFor() {
        return suitedFor;
    }

    public String getPriceRangeMin() {
        return priceRangeMin;
    }

    public String getPriceRangeMax() {
        return priceRangeMax;
    }

    public List<MatchWarDeeListVO> getMatchWarDeeList() {
        return matchWarDeeList;
    }

    public List<ShopByDistanceVO> getShopByDistance() {
        return shopByDistance;
    }

    public List<ShipByPopularityVO> getShipByPopularity() {
        return shipByPopularity;
    }
}
