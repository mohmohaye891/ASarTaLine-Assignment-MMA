package com.padcmyanmar.asartaline.network;

import com.padcmyanmar.asartaline.events.ApiErrorEvent;
import com.padcmyanmar.asartaline.events.SuccessGetWarDeeEvent;
import com.padcmyanmar.asartaline.network.responses.GetWarDeeResponse;
import com.padcmyanmar.asartaline.utils.WarDeeConstants;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements WarDeeDataAgent {

    private static RetrofitDataAgentImpl sObjInstance;

    private WarDeeApi mTheApi;

    RetrofitDataAgentImpl(){

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WarDeeConstants.API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mTheApi = retrofit.create(WarDeeApi.class);
    }

    public static RetrofitDataAgentImpl getInstance(){
        if (sObjInstance == null) {
            sObjInstance = new RetrofitDataAgentImpl();
        }
        return sObjInstance;
    }

    @Override
    public void loadWarDeeList(String accessToken) {
        Call<GetWarDeeResponse> loadWarDeeCall = mTheApi.loadWarDeeList(accessToken);
        loadWarDeeCall.enqueue(new Callback<GetWarDeeResponse>() {
            @Override
            public void onResponse(Call<GetWarDeeResponse> call, Response<GetWarDeeResponse> response) {
                GetWarDeeResponse warDeeResponse = response.body();
                if (warDeeResponse != null && warDeeResponse.isResponseOK()){
                    SuccessGetWarDeeEvent event = new SuccessGetWarDeeEvent(warDeeResponse.getAstlWarDee() );
                    EventBus.getDefault().post(event);
                }else {
                    if (warDeeResponse == null){
                        ApiErrorEvent event = new ApiErrorEvent("Empty response in network call");
                        EventBus.getDefault().post(event);
                    }else {
                        ApiErrorEvent event = new ApiErrorEvent(warDeeResponse.getMessage());
                        EventBus.getDefault().post(event);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetWarDeeResponse> call, Throwable t) {
                ApiErrorEvent event = new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(event);
            }
        });
    }
}
