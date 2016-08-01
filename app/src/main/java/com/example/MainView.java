package com.example;

import java.util.ArrayList;

/**
 * Created by hs-johnny on 16/7/29.
 */
public interface MainView {
    void showData(ArrayList<CarBean> carBeanArrayList);
    void showFail(String msg);
    void showComplete();
}
