package com.padcmyanmar.asartaline.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResultsVO {

    @SerializedName("warDeeId")
    private String warDeeId;

    @SerializedName("name")
    private String name;

    @SerializedName("images")
    private List<String> images;


}
