package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.model.Product;

public class MainActivity extends AppCompatActivity {
    //private static final int REQUEST_CODE = 1 ;
    ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.i("MainActivity", "OnCreate");

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == RESULT_OK && result.getData() != null){
                        binding.txtResult.setText(String.valueOf(result.getData().getIntExtra("returned_data", 0)));
                    }
                });

        addEvents();
    }

    private void addEvents() {
        binding.btnOpenSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open sub activity 1
                Intent intent = new Intent(MainActivity.this, SubActivity1.class);
                startActivity(intent);
            }
        });
        binding.btnOpenSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity2.class);
                startActivity(intent);
            }
        });
        binding.btnOpenSub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open sub 3
                Intent intent = new Intent(MainActivity.this, SubActivity3.class);
                //Attach data using putExtra
//                intent.putExtra("numb", 89);
//                intent.putExtra("grade", 8.9f);
//                intent.putExtra("checked", true);
//                intent.putExtra("say", "Hello");

                //Attach data using Bundle
                Bundle bundle = new Bundle();
                bundle.putInt("numb",68);
                bundle.putFloat("grade", 8.6f);
                bundle.putBoolean("checked", false);
                bundle.putString("say", "Hi");

                //Attach obj
                Product p = new Product("P01", "Heineken", 19000);bundle.putSerializable("product_info ", p);


                intent.putExtra("myBundle", bundle);

                startActivity(intent);

            }
        });
        binding.btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity4.class);

                //Attach data
                intent.putExtra("numb", binding.edtNumber.getText().toString());

                // startActivity(intent);



//                startActivityForResult(intent, REQUEST_CODE);

                launcher.launch(intent);

            }
        });
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
//            int numb = data.getIntExtra("returned_data", 0);
//            binding.txtResult.setText(String.valueOf(numb));
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity", "OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "OnDestroy");
    }

    private class REQUEST_CODE {
    }
}