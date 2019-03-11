package com.okan.startqueue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.okan.startqueue.Jobs.FirstJob;
import com.okan.startqueue.Jobs.SecondJob;
import com.okan.startqueue.retrofitArge.APIClient;
import com.okan.startqueue.retrofitArge.APIInterface;
import com.okan.startqueue.retrofitArge.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "üMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Chef()).start();

//        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
//        User user = new User("morpheus", "leader");
//        Call<User> call1 = apiInterface.createUser(user);
//        call1.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                call.cancel();
//            }
//        });
    }

    public void addSomeJobs(View view) {
        Chef.mQueue.add(new FirstJob());
        Chef.mQueue.add(new SecondJob());
    }
}
