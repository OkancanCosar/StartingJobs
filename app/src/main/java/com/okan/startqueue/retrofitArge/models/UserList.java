package com.okan.startqueue.retrofitArge.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserList {

    @SerializedName("page")
    public Integer page;
    @SerializedName("per_page")
    public Integer perPage;
    @SerializedName("total")
    public Integer total;
    @SerializedName("total_pages")
    public Integer totalPages;
    @SerializedName("data")
    public List<Datum> data;

    public class Datum {

        @SerializedName("id")
        public Integer id;
        @SerializedName("first_name")
        public String first_name;
        @SerializedName("last_name")
        public String last_name;
        @SerializedName("avatar")
        public String avatar;

        @Override
        public String toString() {
            return "Datum{" +
                    "id=" + id +
                    ", first_name='" + first_name + '\'' +
                    ", last_name='" + last_name + '\'' +
                    ", avatar='" + avatar + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UserList{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", total=" + total +
                ", totalPages=" + totalPages +
                ", data=" + data +
                '}';
    }
}
