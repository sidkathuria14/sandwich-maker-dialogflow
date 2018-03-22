package com.example.sidkathuria14.sandwich.api;

import com.example.sidkathuria14.sandwich.models.Data;
import com.example.sidkathuria14.sandwich.models.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by sidkathuria14 on 22/3/18.
 */

public interface PostApi {


    @Headers({"Authorization: Bearer ccb6482ecfb74b06b58f93f782cbd261",
            "Content-Type: application/json"})
    @POST("query")
//    @FormUrlEncoded
    Call<Response> savePost(
//                            @Field("lang") String lang ,
//                            @Field("query") String query ,
//                            @Field("sessionId") String sessionId
//                            ,@Query("v")String v

            @Body Data data
    );

}
