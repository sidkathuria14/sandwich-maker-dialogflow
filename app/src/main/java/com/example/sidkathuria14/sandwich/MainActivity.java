package com.example.sidkathuria14.sandwich;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sidkathuria14.sandwich.api.PostApi;
import com.example.sidkathuria14.sandwich.models.Data;
import com.example.sidkathuria14.sandwich.models.StringWithBinary;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText etInput;String input;
    public static final String TAG = "sandwich";
    ArrayList<StringWithBinary> arrayList;
    MyAdapter adapter;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();
        rv = (RecyclerView)findViewById(R.id.rv);
        adapter = new MyAdapter(arrayList,this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

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
               input =  etInput.getText().toString();
               arrayList.add(new StringWithBinary(0,input));
               adapter.notifyDataSetChanged();

                postApi.savePost(new Data("en",input,"ccb6482ecfb74b06b58f93f782cbd261")).enqueue(new Callback<com.example.sidkathuria14.sandwich.models.Response>() {
                            @Override
                            public void onResponse(Call<com.example.sidkathuria14.sandwich.models.Response> call, Response<com.example.sidkathuria14.sandwich.models.Response> response) {
                                Log.d(TAG, "onResponse: " + response.isSuccessful());
                                Log.d(TAG, "onResponse: " + response.message());
                                Log.d(TAG, "onResponse: " + response.headers());
                                Log.d(TAG, "onResponse: " + response.errorBody());
                                Log.d(TAG, "onResponse: " + response.code());
                                Log.d(TAG, "onResponse: " + response.body().getResult().getSpeech());
                                arrayList.add(new StringWithBinary(1,response.body().getResult().getSpeech()));
                            adapter.notifyDataSetChanged();
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
