package com.okan.startqueue.datalayer.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/*
 * @SerializedName: json'dan parse ederken kullanılacak key:::
 * @ColumnInfo: veritabanında olmasını istediğin isim
 */
@Entity(tableName = "Tbl_Albums")
public class AlbumModel implements Serializable {

    @ColumnInfo(name = "column_user_id")
    @SerializedName("userId")
    @Expose
    private Integer _user_id;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "column_id")
    @SerializedName("id")
    @Expose
    private Integer _id;

    @ColumnInfo(name = "column_title")
    @SerializedName("title")
    @Expose
    private String _title;


    public Integer get_user_id() {
        return _user_id;
    }

    public void set_user_id(Integer _user_id) {
        this._user_id = _user_id;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    @Override
    public String toString() {
        return "AlbumModel{" +
                ", _user_id=" + _user_id +
                ", _id=" + _id +
                ", _title='" + _title + '\'' +
                '}';
    }
}
