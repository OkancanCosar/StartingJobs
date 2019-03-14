package com.okan.startqueue.datalayer.dbservice.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.okan.startqueue.datalayer.entities.PostModel;

import java.util.List;

@Dao
public interface IPost {

    @Query("SELECT * FROM TBL_POSTS")
    List<PostModel> getPosts();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPosts(List<PostModel> posts);

    @Update
    void updatePosts(PostModel... posts);

    @Delete
    void deletePosts(PostModel... posts);

}


