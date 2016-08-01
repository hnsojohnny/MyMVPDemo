package com.example;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by hs-johnny on 16/8/1.
 */
public class BasePresenter<V,T> implements Presenter<V> {
    public V mainView;
    private CompositeSubscription compositeSubscription;
    public Api api = MyHttpClient.getIntance().getRetrofit(new GsonTool<T>().getArrayGson()).create(Api.class);
    @Override
    public void attchView(V view) {
        this.mainView = view;
    }

    @Override
    public void detachView() {
        this.mainView = null;
        onUnSubscribe();
    }

    public void onUnSubscribe() {
        if (compositeSubscription != null && compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
        }
    }

    public void addSubscribe(Observable observable, Subscriber subscriber) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

}
