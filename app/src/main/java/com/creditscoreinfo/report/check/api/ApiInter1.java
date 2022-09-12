package com.creditscoreinfo.report.check.api;



import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInter1 {


    @Headers({"Content-Type: application/json"})
    @POST("usor.php")
    Call<ResponseBody> getUser(@Body JsonObject jsonObject);

    @POST("update.php")
    @Headers({"Content-Type: application/json; charset=utf-8"})
    Call<String> getUpdates(@Body JsonObject JsonObject);


}