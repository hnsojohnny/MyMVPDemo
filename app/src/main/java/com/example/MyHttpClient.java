package com.example;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hs-johnny on 16/8/1.
 */
public class MyHttpClient {
    public static MyHttpClient myHttpClient;
    private Retrofit retrofit;
    public static MyHttpClient getIntance(){
        if(myHttpClient == null){
            myHttpClient = new MyHttpClient();
        }
        return myHttpClient;
    }
    public Retrofit getRetrofit(Gson gson){
        if(retrofit == null){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if(BuildConfig.DEBUG){
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(httpLoggingInterceptor);
            }
            OkHttpClient client = builder.build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}
