package com.okan.startqueue.retrofitArge.models;

import com.google.gson.annotations.SerializedName;

public class CreateUserResponse {

    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;

    @Override
    public String toString() {
        return "CreateUserResponse{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}

