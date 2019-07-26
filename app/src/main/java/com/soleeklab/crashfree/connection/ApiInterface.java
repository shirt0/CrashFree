package com.soleeklab.crashfree.connection;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {



    @Headers({"Content-Type: application/json",
              "Authorization: Bearer SENDGRID_API"})
    @POST("https://api.sendgrid.com/v3/mail/send")
    Call<ResponseBody> sendGridApi(@Body RequestBody body);

}

