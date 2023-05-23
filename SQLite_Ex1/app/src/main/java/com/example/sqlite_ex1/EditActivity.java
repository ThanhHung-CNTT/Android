package com.example.sqlite_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.model.Product;
import com.example.sqlite_ex1.databinding.ActivityEditBinding;
import com.example.sqlite_ex1.databinding.ActivityMainBinding;

public class EditActivity extends AppCompatActivity {
    ActivityEditBinding binding;
    Product p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_edit);
        binding = ActivityEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();
        addEvent();
    }

    private void getData() {
        Intent intent = getIntent();
        Product p = (Product) intent.getSerializableExtra("productInfo");
        binding.edtProductName.setText(p.getProductName());
        binding.edtProductPrice.setText(String.valueOf(p.getProductPrice()));
    }

    private void addEvent() {
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("ProductName",binding.edtProductName.getText().toString());
                values.put("ProductPrice",Double.parseDouble(binding.edtProductPrice.getText().toString()));
                int numbOfRows = MainActivity.db.update(MainActivity.TBL_NAME,values,"ProductID=?",new String[]{String.valueOf(p.getProductID())});
                if(numbOfRows >0)
                    Toast.makeText(EditActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EditActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        binding.btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}