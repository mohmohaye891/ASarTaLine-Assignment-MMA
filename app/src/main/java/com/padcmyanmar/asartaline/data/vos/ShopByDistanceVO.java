package com.padcmyanmar.asartaline.data.vos;

import com.google.gson.annotations.SerializedName;

public class ShopByDistanceVO {

    @SerializedName("shopByDistanceId")
    private String shopByDistanceId;

    @SerializedName("mealShop")
    private MealShopVO mealShopId;

    @SerializedName("distanceInFeet")
    private String distanceInFeet;

    public String getShopByDistanceId() {
        return shopByDistanceId;
    }

    public MealShopVO getMealShopId() {
        return mealShopId;
    }

    public String getDistanceInFeet() {
        return distanceInFeet;
    }
}
