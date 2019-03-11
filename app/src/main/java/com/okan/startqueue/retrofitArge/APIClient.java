package com.okan.startqueue.retrofitArge;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static Retrofit getClient() {

        return new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient
                        .Builder()
                        .addInterceptor(new HttpLoggingInterceptor()
                                .setLevel(HttpLoggingInterceptor.Level.BODY)
                        )
                        .build()
                ).build();
    }
}
