package com.okan.startqueue.datalayer.dbservice;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.okan.startqueue.datalayer.dbservice.dao.IAlbum;
import com.okan.startqueue.datalayer.dbservice.dao.IPost;
import com.okan.startqueue.datalayer.entities.AlbumModel;
import com.okan.startqueue.datalayer.entities.PostModel;
import com.okan.startqueue.util.LLog;

@Database(
        entities = {
                PostModel.class,
                AlbumModel.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    private static final String TAG = "üAppDatabase";
    private static final String DB_NAME = "okancan.db";
    private static AppDatabase INSTANCE;


    /* dao abstract'ları */
    public abstract IPost postDao();

    public abstract IAlbum albumDao();


    /* DB instance return fonksiyonu */
    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(
                            context,
                            AppDatabase.class,
                            DB_NAME)
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    LLog.d(TAG, "Veritabanı oluşturuldu");
                                }
                            })
                            .build();
        }
        return INSTANCE;
    }
}

