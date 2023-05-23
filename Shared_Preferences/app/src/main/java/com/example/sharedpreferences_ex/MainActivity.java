package com.example.sharedpreferences_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.sharedpreferences_ex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static  final String PREFENCES_NAME = "Song";
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences(PREFENCES_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putInt("numb",89);
                editor.putFloat("grades",8.9f);
                editor.putBoolean("checked",true);
                editor.putString("say","Hello");
                editor.apply();
            }
        });
        binding.btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences(PREFENCES_NAME,MODE_PRIVATE);

                int numb = preferences.getInt("numb",0);
                float grades = preferences.getFloat("grades", 0.0f);
                boolean checked = preferences.getBoolean("checked",false);
                String say = preferences.getString("say","");

                binding.txtContent.setText("");
                binding.txtContent.append("Numb" + numb + "\n");
                binding.txtContent.append("grades" + grades + "\n");
                binding.txtContent.append("Checked" + checked + "\n");
                binding.txtContent.append("say" + say + "\n");

            }
        });
    }
}