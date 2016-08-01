package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by hs-johnny on 16/5/14.
 */
public class GsonTool<T> {
    public static Gson gson;
    public Gson getArrayGson(){
        return  gson = new GsonBuilder().registerTypeAdapter((new TypeToken<ArrayList<T>>() {
        }).getType(), new MyDeserializerArray<ArrayList<T>>()).create();
    }
    public Gson getObjectGson(){
        return gson = new GsonBuilder().registerTypeAdapter((new TypeToken<T>() {
        }).getType(), new MyDeserializerObject<T>()).create();
    }

}
