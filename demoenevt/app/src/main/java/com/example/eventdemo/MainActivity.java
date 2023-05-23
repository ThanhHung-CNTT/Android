package com.example.eventdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.eventdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    String[] drinks = {"Tiger","Heniken","Saporro","Cocacola","O-Long","Redbul","Pepsi","Lavie","7Up","Wakeup247","Vinamilk","Coffe","C2"};
    ArrayAdapter<String> adapder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        loadData();
    }

    private void loadData() {
        adapder=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,drinks);
        binding.LvDrinks.setAdapter(adapder);
    }
}