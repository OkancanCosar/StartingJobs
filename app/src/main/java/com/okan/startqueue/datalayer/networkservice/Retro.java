package com.okan.startqueue.datalayer.networkservice;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro {

    public enum RetroClient {
        JSONPLACEHOLDER("https://jsonplaceholder.typicode.com"),
        REQRES("https://reqres.in/");

        private final String _val;

        RetroClient(String val) {
            this._val = val;
        }

        public String getVal() {
            return _val;
        }
    }

    public static Retrofit getClient(RetroClient clientEnum) {

        return new Retrofit.Builder()
                .baseUrl(clientEnum.getVal())
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

