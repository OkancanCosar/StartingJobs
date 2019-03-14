package com.okan.startqueue.datalayer.dbservice.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.okan.startqueue.datalayer.entities.AlbumModel;

import java.util.List;

@Dao
public interface IAlbum {

    @Query("SELECT * FROM Tbl_Albums")
    List<AlbumModel> getAlbums();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAlbum(List<AlbumModel> albums);

    @Update
    void updateAlbum(AlbumModel... albums);

    @Delete
    void deleteAlbum(AlbumModel... albums);
}

