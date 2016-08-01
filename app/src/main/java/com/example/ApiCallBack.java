package com.example;

/**
 * Created by hs-johnny on 16/8/1.
 */
public interface ApiCallBack<T> {
    void onSuccess(T t);
    void onFail(int code,String msg);
    void onCompleted();
}
