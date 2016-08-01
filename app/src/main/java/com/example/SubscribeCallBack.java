package com.example;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by hs-johnny on 16/8/1.
 */
public class SubscribeCallBack<T> extends Subscriber<T>{
    private ApiCallBack<T> apiCallBack;
    public SubscribeCallBack(ApiCallBack<T> apiCallBack){
        this.apiCallBack = apiCallBack;
    }
    @Override
    public void onCompleted() {
        apiCallBack.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof HttpException){
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String msg = httpException.message();
            if(code == 504){
                msg = "网络不给力";
            }
            apiCallBack.onFail(code,msg);
        }else{
            apiCallBack.onFail(0,e.getMessage());
        }
        apiCallBack.onCompleted();
    }

    @Override
    public void onNext(T t) {
         apiCallBack.onSuccess(t);
    }
}
