






package com.appers.myretrofitapicall.network;

import android.util.Log;

import com.appers.myretrofitapicall.model.RandomResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RandomNetwork {
    private RandomService randomService=createRetrofit().create(RandomService.class);
    private Retrofit createRetrofit(){
        return new Retrofit.Builder().baseUrl("https://randomuser.me").addConverterFactory(GsonConverterFactory.create()).build();
    }
    public Call<RandomResponse> getUsers(int total) {

        Log.d("TAG_X", "SearchQuery..." + Thread.currentThread().getName());
        return randomService.getUsers(total);
    }
   interface RandomService{
    @GET("/api")
    Call<RandomResponse> getUsers(@Query("results") int total);
    }


}
