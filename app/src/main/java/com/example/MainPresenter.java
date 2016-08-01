package com.example;


import java.util.ArrayList;

/**
 * Created by hs-johnny on 16/7/29.
 */
public class MainPresenter extends BasePresenter<MainView,CarBean>{
    public MainPresenter(CarBean carBean,MainView mainView){
        attchView(mainView);
    }
    public void loadData(){
         addSubscribe(api.getData(),new SubscribeCallBack(new ApiCallBack<ArrayList<CarBean>>() {

             @Override
             public void onSuccess(ArrayList<CarBean> carBeen) {
                 mainView.showData(carBeen);
             }

             @Override
             public void onFail(int code, String msg) {
                 mainView.showFail(msg);
             }

             @Override
             public void onCompleted() {
                 mainView.showComplete();
             }
         }));
    }

}
