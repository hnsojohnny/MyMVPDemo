package com.example;

import java.util.ArrayList;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hs-johnny on 16/8/1.
 */
public interface Api {
    public static String BASEURL = "http://101.201.44.172:9001";
    @GET("/C_Cars/GetCarsHotBrand")
    Observable<ArrayList<CarBean>> getData();

}
