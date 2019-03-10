package com.okan.startqueue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.okan.startqueue.Jobs.FirstJob;
import com.okan.startqueue.Jobs.SecondJob;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "üMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Chef()).start();

    }

    public void addSomeJobs(View view) {
        Chef.mQueue.add(new FirstJob());
        Chef.mQueue.add(new SecondJob());
    }
}
