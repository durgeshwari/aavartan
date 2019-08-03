package com.aavartan.aavartan2k19.Event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.aavartan.aavartan2k19.Event.model.EventData;
import com.aavartan.aavartan2k19.Event.model.Model;
import com.aavartan.aavartan2k19.Event.network.ApiClient;
import com.aavartan.aavartan2k19.R;
import com.aavartan.aavartan2k19.Event.adapter.event_adapter;
import com.aavartan.aavartan2k19.Event.network.Api;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FunDetail extends AppCompatActivity {


    RecyclerView rvEvent;
    private List<Model> funEvents = new ArrayList<>();

    private event_adapter eventAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_detail);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvEvent.setLayoutManager(linearLayoutManager);
        
        LoadJson();


    }

    private void LoadJson() {
        Api api = ApiClient.getApiClient().create(Api.class);

        Call<EventData> call = api.getFunEvents();

        call.enqueue(new Callback<EventData>() {
            @Override
            public void onResponse(Call<EventData> call, Response<EventData> response) {
                funEvents = response.body().getEventList();
                eventAdapter = new event_adapter(funEvents, FunDetail.this);
                rvEvent.setAdapter(eventAdapter);
                eventAdapter.notifyDataSetChanged();

            }


            @Override
            public void onFailure(Call<EventData> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });
    }


}









