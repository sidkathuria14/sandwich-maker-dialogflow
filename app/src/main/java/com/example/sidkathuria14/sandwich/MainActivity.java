package com.example.sidkathuria14.sandwich;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sidkathuria14.sandwich.api.PostApi;
import com.example.sidkathuria14.sandwich.models.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText etInput;
    public static final String TAG = "sandwich";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.dialogflow.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PostApi postApi = retrofit.create(PostApi.class);
        etInput = (EditText) findViewById(R.id.etInput);
        ((Button) findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                postApi.savePost("en",
//                        "I want a sandwich",
//                        "ccb6482ecfb74b06b58f93f782cbd261"
////                        ,"20150910"
//                )
                postApi.savePost(new Data("en","I want a sandwich","ccb6482ecfb74b06b58f93f782cbd261")).enqueue(new Callback<com.example.sidkathuria14.sandwich.models.Response>() {
                            @Override
                            public void onResponse(Call<com.example.sidkathuria14.sandwich.models.Response> call, Response<com.example.sidkathuria14.sandwich.models.Response> response) {
                                Log.d(TAG, "onResponse: " + response.isSuccessful());
                                Log.d(TAG, "onResponse: " + response.message());
                                Log.d(TAG, "onResponse: " + response.headers());
                                Log.d(TAG, "onResponse: " + response.errorBody());
                                Log.d(TAG, "onResponse: " + response.code());
                                Log.d(TAG, "onResponse: " + response.body().getResult().getSpeech());
                            }

                            @Override
                            public void onFailure(Call<com.example.sidkathuria14.sandwich.models.Response> call, Throwable t) {
                                Log.d(TAG, "onFailure: " );
                            }


                        });

            }
        });
    }
}
