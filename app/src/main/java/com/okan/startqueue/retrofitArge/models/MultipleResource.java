package com.okan.startqueue.retrofitArge.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MultipleResource {

    @SerializedName("page")
    public Integer page;
    @SerializedName("per_page")
    public Integer perPage;
    @SerializedName("total")
    public Integer total;
    @SerializedName("total_pages")
    public Integer totalPages;
    @SerializedName("data")
    public List<Datum> data = null;

    public class Datum {

        @SerializedName("id")
        public Integer id;
        @SerializedName("name")
        public String name;
        @SerializedName("year")
        public Integer year;
        @SerializedName("pantone_value")
        public String pantoneValue;

        @Override
        public String toString() {
            return "Datum{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", year=" + year +
                    ", pantoneValue='" + pantoneValue + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MultipleResource{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", total=" + total +
                ", totalPages=" + totalPages +
                ", data=" + data +
                '}';
    }
}

