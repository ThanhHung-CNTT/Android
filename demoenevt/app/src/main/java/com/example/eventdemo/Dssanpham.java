package com.example.eventdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.eventdemo.databinding.ActivityDssanphamBinding;
import com.example.models.Product;

public class Dssanpham extends AppCompatActivity {

    ActivityDssanphamBinding binding;

    ArrayAdapter<Product> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dssanpham);
        binding = ActivityDssanphamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addEvent();
    }

    private void addEvent() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String name = binding.edtName.getText().toString();
                double price = Double.parseDouble(binding.edtPrice.getText().toString());
                Product p = new Product(name, price);
                adapter.add(p);
            }
        });

        binding.LvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product selectedProduct = adapter.getItem(i);
                Toast.makeText(Dssanpham.this, selectedProduct.getProductName()+" - "+ selectedProduct.getProductPrice(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.LvProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product p = adapter.getItem(i);
                adapter.remove(p);
                return true;
            }
        });
    }

    private void loadData() {
        adapter = new ArrayAdapter<Product>(Dssanpham.this, android.R.layout.simple_list_item_1);
        binding.LvProduct.setAdapter(adapter);
    }
}