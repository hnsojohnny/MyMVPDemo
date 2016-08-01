package com.example;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by hs-johnny on 16/5/5.
 */
public class MyDeserializerObject<T> implements JsonDeserializer<T>{
    @Override
    public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement content = jsonElement.getAsJsonObject();
        return new Gson().fromJson(content,type);
    }
}
