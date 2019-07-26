package com.soleeklab.crashfree.connection;

import com.soleeklab.crashfree.crashHandler.HandleAppCrash;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public class RestClient {
    private static ApiInterface apiInterface;


    public static ApiInterface getClient() {
        if (apiInterface == null) {

            HttpLoggingInterceptor.Logger fileLogger = new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String s) {
                    if(s.contains("--> GET") || s.contains("--> POST")) HandleAppCrash.network.setLength(0);
                    HandleAppCrash.network.append(s).append('\n');

                }
            };
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(fileLogger);
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.sendgrid.com/v3/mail/send/")
                    .client(okHttpClient)
                    .build();

            apiInterface = retrofit.create(ApiInterface.class);
        }

        return apiInterface;
    }



}
