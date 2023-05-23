package com.example.eventdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.adapters.beerAdapter;
import com.example.eventdemo.databinding.ActivityBeerBinding;
import com.example.models.Beer;

import java.util.ArrayList;
import java.util.List;

public class beerActivity extends AppCompatActivity {

    ActivityBeerBinding binding;
    beerAdapter adapter;
    ArrayList<Beer> beers;
    //ArrayAdapter<beerActivity> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_beer);
        binding = ActivityBeerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initAdapter();
    }

    private void initAdapter() {
        initData();
        adapter = new beerAdapter(beerActivity.this, R.layout.beer_item, beers);
        binding.LvBeers.setAdapter(adapter);
    }

    private void initData() {
        beers = new ArrayList<>();
        beers.add(new Beer(R.drawable.heineken,"Heniken",19990));
        beers.add(new Beer(R.drawable.heineken,"333",199099));
        beers.add(new Beer(R.drawable.heineken,"Hanoi",12290));
        beers.add(new Beer(R.drawable.heineken,"Tiger",22222));
        beers.add(new Beer(R.drawable.heineken,"Sapappro",33333));
    }


}