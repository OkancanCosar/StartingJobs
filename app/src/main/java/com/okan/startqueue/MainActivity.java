package com.okan.startqueue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.okan.startqueue.contentmanager.ContentManager;
import com.okan.startqueue.util.LLog;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "üMainActivity";

    private ContentManager contentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            contentManager = new ContentManager(MainActivity.this);
            contentManager.initiationForStartingJobs();

        }
    }

    public void addSomeJobs(View view) {

        if (contentManager.addSomeJobs()) {
            LLog.i(TAG, "Başlangıç işleri listeye eklendi.");
        } else {
            LLog.i(TAG, "Listeye eklenme başarısı.");
        }
    }
}
