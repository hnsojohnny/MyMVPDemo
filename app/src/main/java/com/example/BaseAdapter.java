package com.example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by hs-johnny on 16/8/1.
 */
public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.ViewHolder>{
    private ArrayList<CarBean> carBeanArrayList;
    private Context context;
    public BaseAdapter(ArrayList<CarBean> carBeanArrayList,Context context) {
        this.carBeanArrayList = carBeanArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context).load("http://101.201.44.172:9001/smallPic/"+carBeanArrayList.get(position).getC_Cars_Parameters_url()).error(R.mipmap.ic_launcher).into(holder.item_image);
        holder.item_text.setText(carBeanArrayList.get(position).getC_Cars_Parameters_name());
    }

    @Override
    public int getItemCount() {
        if(carBeanArrayList == null){
            return 0;
        }
        return carBeanArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView item_image;
        private TextView item_text;
        public ViewHolder(View itemView) {
            super(itemView);
            item_image = (ImageView) itemView.findViewById(R.id.item_image);
            item_text = (TextView) itemView.findViewById(R.id.item_text);
        }
    }
}
