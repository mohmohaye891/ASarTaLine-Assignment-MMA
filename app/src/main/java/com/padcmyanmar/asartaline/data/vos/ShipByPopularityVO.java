package com.padcmyanmar.asartaline.data.vos;

import com.google.gson.annotations.SerializedName;

public class ShipByPopularityVO {

    @SerializedName("shopByPopularity")
    private String shopByPopularity;

    @SerializedName("mealShop")
    private MealShopVO mealShopId;

    public String getShopByPopularity() {
        return shopByPopularity;
    }

    public MealShopVO getMealShopId() {
        return mealShopId;
    }
}
