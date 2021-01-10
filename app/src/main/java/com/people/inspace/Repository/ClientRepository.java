package com.people.inspace.Repository;

import androidx.lifecycle.MutableLiveData;

import com.people.inspace.Models.ResponseModel;
import com.people.inspace.Network.RetrofitBuilder;
import com.people.inspace.Network.networkApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientRepository {
    private static ClientRepository INSTANCE;
    private MutableLiveData<ResponseModel> responseLiveData;
    private networkApi networkApi;

    public static ClientRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new ClientRepository();
        }
        return INSTANCE;
    }

    private ClientRepository(){
        responseLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<ResponseModel> getResponseLiveData(){
        networkApi = RetrofitBuilder.createService(networkApi.class);
        networkApi.response().enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful()){
                    responseLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
        return responseLiveData;
    }

}
