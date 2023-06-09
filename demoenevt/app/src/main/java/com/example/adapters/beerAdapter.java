package com.example.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eventdemo.R;
import com.example.models.Beer;

import java.util.ArrayList;

public class beerAdapter extends BaseAdapter {

    Activity context;
    int item_layout;
    ArrayList<Beer> beers;

    public beerAdapter(Activity context, int item_layout, ArrayList<Beer> beers) {
        this.context = context;
        this.item_layout = item_layout;
        this.beers = beers;
    }

    @Override
    public int getCount() {
        return beers.size();
    }

    @Override
    public Object getItem(int i) {
        return beers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Link views
        ViewHolder viewHolder;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout,null);
            viewHolder.invThumb = view.findViewById(R.id.imvThumb);
            viewHolder.txtName = view.findViewById(R.id.txtName);
            viewHolder.txtPrice = view.findViewById(R.id.txtPrice);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }


        //Binding data
        Beer b = beers.get(i);
        viewHolder.invThumb.setImageResource(b.getBeerThumb());
        viewHolder.txtName.setText(b.getBeerName());
        viewHolder.txtPrice.setText(String.valueOf(b.getBeerPrice()));
        return view;
    }

    public static class ViewHolder{
        ImageView invThumb;
        TextView txtName, txtPrice;
    }
}







