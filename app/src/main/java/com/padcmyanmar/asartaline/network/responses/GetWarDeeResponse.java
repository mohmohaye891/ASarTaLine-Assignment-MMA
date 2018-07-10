package com.padcmyanmar.asartaline.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.asartaline.data.vos.ASTLWarDeeVO;

import java.util.List;

public class GetWarDeeResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("astlWarDee")
    private List<ASTLWarDeeVO> astlWarDee;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<ASTLWarDeeVO> getAstlWarDee() {
        return astlWarDee;
    }

    public boolean isResponseOK(){
        return (code == 200 && astlWarDee != null);
    }
}
