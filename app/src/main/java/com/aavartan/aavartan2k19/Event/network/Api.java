package com.aavartan.aavartan2k19.Event.network;

import com.aavartan.aavartan2k19.Event.model.EventData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {


    @GET("base url ke bad wala part yahan aayega")
    Call<EventData> getFunEvents();

    @GET("base url ke bad wala part yahan aayega")
    Call<EventData> getManagerialEvents();

    @GET("base url ke bad wala part yahan aayega")
    Call<EventData> getTechnicalEvents();

    @GET("base url ke bad wala part yahan aayega")
    Call<EventData> getRoboticsEvents();


}
