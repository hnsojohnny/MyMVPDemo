package com.example;

import android.view.View;

/**
 * Created by hs-johnny on 16/7/29.
 */
public interface Presenter<V> {
    void attchView(V view);
    void detachView();
}
