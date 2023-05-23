package com.nguyenphamthanhhung.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nguyenphamthanhhung.test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prePareDB();
    }
    private void prePareDB() {
        db = new DBHelper(MainActivity.this);
        db.createSampleData();
    }
}