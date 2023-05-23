package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivitySub4Binding;

public class SubActivity4 extends AppCompatActivity {
    ActivitySub4Binding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub4);

        binding = ActivitySub4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();
        addEvents();
    }



    private void getData() {
        intent = getIntent();
        binding.txtNumber.setText(intent.getStringExtra("numb"));
    }
    private void addEvents() {
        binding.btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numb = Integer.parseInt(binding.txtNumber.getText().toString());
                int pow_numb = numb * numb;
                intent.putExtra("returned data", pow_numb);
                setResult(Activity.RESULT_OK, intent);
            }
        });
    }

}