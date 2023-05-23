package com.example.eventdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.eventdemo.databinding.ActivityFoodBinding;
import com.example.eventdemo.databinding.ActivityMainBinding;

public class FoodActivity extends AppCompatActivity {

    ActivityFoodBinding binding;
    String[] foods;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_food);
        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }

    private void loadData() {
        foods = getResources().getStringArray(R.array.foodList);
        adapter = new ArrayAdapter<String>(FoodActivity.this, android.R.layout.simple_list_item_1,foods);
        binding.LvFoods.setAdapter(adapter);
    }


}