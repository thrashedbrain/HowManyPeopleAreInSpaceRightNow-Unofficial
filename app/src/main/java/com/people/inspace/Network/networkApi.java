package com.people.inspace.Network;

import com.people.inspace.Models.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface networkApi {
    @GET("peopleinspace.json")
    Call<ResponseModel> response();
}
