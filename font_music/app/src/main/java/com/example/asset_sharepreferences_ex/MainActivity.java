package com.example.asset_sharepreferences_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.asset_sharepreferences_ex.databinding.ActivityMainBinding;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayAdapter<String> adapter;
    String[] fontList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadFonts();
        addEvents();
    }

    private void addEvents() {
        binding.lvFonts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/"+adapter.getItem(i));
                binding.txtContent.setTypeface(tf);
                playAudio();
            }


        });
    }

    private void playAudio() {
        AssetFileDescriptor descriptor = null;
        try {
            descriptor = getAssets().openFd("musics/that_girl.mp3");
            MediaPlayer player = new MediaPlayer();
            player.setDataSource(descriptor.getFileDescriptor(),descriptor.getStartOffset(),descriptor.getLength());
            descriptor.close();
            player.prepare();
            player.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void loadFonts() {
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1);
        AssetManager manager = getAssets();
        try {
            fontList = manager.list("fonts");
            adapter.addAll(fontList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        binding.lvFonts.setAdapter(adapter);
    }

}