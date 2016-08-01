package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;



import java.util.ArrayList;

/**
 * Created by hs-johnny on 16/8/1.
 */
public class MainActivity extends Activity implements MainView{
    private RecyclerView recyclerView;
    private BaseAdapter adapter;
    private MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainPresenter = new MainPresenter(new CarBean(),this);
        mainPresenter.loadData();
    }

    @Override
    public void showData(ArrayList<CarBean> carBeanArrayList) {
        adapter = new BaseAdapter(carBeanArrayList,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showFail(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mainPresenter != null){
            mainPresenter.detachView();
        }
    }
}
