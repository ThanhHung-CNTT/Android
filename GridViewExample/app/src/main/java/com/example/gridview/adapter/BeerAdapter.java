package com.example.gridview.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.gridview.R;
import com.example.gridview.model.BeerModel;

import java.util.ArrayList;
import java.util.List;

public class BeerAdapter extends ArrayAdapter<BeerModel> {
    Activity context;
    int resource;
    @NonNull
    List<BeerModel> objects;

    public BeerAdapter(@NonNull Activity context, int resource, @NonNull List<BeerModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        convertView = layoutInflater.inflate(this.resource, null);

        TextView beerName = convertView.findViewById(R.id.beerName);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        BeerModel beerModel = this.objects.get(position);
        beerName.setText(beerModel.getBeerName());
        imageView.setImageResource(beerModel.getImgID());

        return convertView;
    }
}
