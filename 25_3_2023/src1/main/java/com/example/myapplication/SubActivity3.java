package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.model.Product;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.ActivitySub3Binding;

public class SubActivity3 extends AppCompatActivity {

    ActivitySub3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sub3);
        binding = ActivitySub3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
//      int numb = intent.getIntExtra("numb",0);
//      float grade = intent.getFloatExtra("grade", 0.0f);
//      boolean checked = intent.getBooleanExtra("checked",false);
//      String say = intent.getStringExtra("say");

        //Get data via Bundle
        Bundle bundle = intent.getBundleExtra("MyBundle");
        int numb = bundle.getInt("numb",0);
        float grade =  bundle.getFloat("grade",0.0f);
        boolean checked = bundle.getBoolean("checked",false);
        String say = bundle.getString("say");
        Product p = (Product) bundle.getSerializable("product_info");

        //Show data

        binding.txtContent.setText("Numb: "+ numb + "\n" + "Grade: " + grade + "\n" + "Checked: "+ checked + "\n" + "Say: "+ say+ "Product Info" + p.getProductCode()+"-"+p.getProductName()+"-"+p.getProductPrice());

    }
}