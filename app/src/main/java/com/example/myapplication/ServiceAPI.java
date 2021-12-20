package com.example.myapplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceAPI {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ServiceAPI serviceAPI = new Retrofit.Builder()
            .baseUrl("https://61c0623d33f24c00178232c7.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ServiceAPI.class);

    @GET("users")
    Call<List<User>> getListUsers();

    @POST("gmail")
    Call<Gmail> addEmail(@Body Gmail gmail, MainActivity mainActivity);

}
