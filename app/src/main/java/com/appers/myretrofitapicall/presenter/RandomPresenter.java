package com.appers.myretrofitapicall.presenter;

import android.util.Log;

import com.appers.myretrofitapicall.model.RandomResponse;
import com.appers.myretrofitapicall.network.RandomNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomPresenter implements Contract.Presenter{
    public Contract.View view;
    private RandomNetwork randomNetwork=new RandomNetwork();

    public RandomPresenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void getUsers(int total) {
        view.setStatus(Status.LOADING);
randomNetwork.getUsers(total).enqueue(new Callback<RandomResponse>() {
    @Override
    public void onResponse(Call<RandomResponse> call, Response<RandomResponse> response) {
        if (response.body() != null && response.body().getResults() != null) {
            Log.d("TAG_X","NEED TO LOOK");
        view.displayUsers(response.body().getResults());
        view.setStatus(Status.COMPLETE);}
        else{

            view.setStatus(Status.ERROR);
        }

    }
    @Override
    public void onFailure(Call<RandomResponse> call, Throwable t) {
        Log.d("TAG_X","SOMETHING FISHY");
view.setStatus(Status.ERROR);
    }
});
    }
    public enum Status{
        LOADING,
        COMPLETE,
        ERROR
    }
}
