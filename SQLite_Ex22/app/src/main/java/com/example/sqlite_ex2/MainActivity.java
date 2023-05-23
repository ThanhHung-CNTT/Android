package com.example.sqlite_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sqlite_ex2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MyDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        prePareDB();
    }

    private void prePareDB() {
        db = new MyDBHelper(MainActivity.this);
        db.createSampleData();
    }
}