package com.aavartan.aavartan2k19.Event.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "";
    private static Retrofit mRetrofit;

    public static Retrofit getApiClient(){
        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
