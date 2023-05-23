package com.example.multithread_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.multithread_ex.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Random random = new Random();
    int percent, randNumb;
    Handler handler = new Handler();
    Runnable foregroundThread = new Runnable() {
        @Override
        public void run() {
            ImageView imv = new ImageView(MainActivity.this);
            if(randNumb %2 == 0)
                imv.setImageResource(R.drawable.ic_android_black_24dp);
            else
                imv.setImageResource(R.drawable.baseline_sports_volleyball_24);

            imv.setLayoutParams(params);

            binding.containerLayout.addView(imv);
            binding.txtPercent.setText(percent + " %");
            if(percent == 100)
                binding.txtPercent.setText("DONE!");
            binding.pbPercent.setProgress(percent);
        }
    };
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200,LinearLayout.LayoutParams.WRAP_CONTENT);


//    Handler handler = new Handler(new Handler.Callback() {
//        @Override
//        public boolean handleMessage(@NonNull Message message) {
//            int randNumb = (int)message.obj;
//            ImageView imv = new ImageView(MainActivity.this);
//            if(randNumb % 2 ==0){
//                imv.setImageResource(R.drawable.baseline_sports_volleyball_24);
//            }
//            else{
//                imv.setImageResource(R.drawable.ic_android_black_24dp);
//            }
//            imv.setLayoutParams(params);
//            binding.containerLayout.addView(imv);
//            binding.txtPercent.setText(message.arg1+" %");
//            if(message.arg1 == 100){
//                binding.txtPercent.setText("DONE!");
//            }
//            binding.pbPercent.setProgress(message.arg2);
//            return true;
//        }
//    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();
    }

    private void addEvent() {
        binding.btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawUI();
            }
        });
    }

    private void drawUI() {
//        int numb = Integer.parseInt(binding.edtNumbOfViews.getText().toString());
//        binding.containerLayout.removeAllViews();
//        Thread backgroundThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 1; i<= numb; i++){
//                    Message message = handler.obtainMessage();
//                    message.arg1 = i*100/numb;
//                    message.obj=random.nextInt(100);
//                    handler.sendMessage(message);
//                    SystemClock.sleep(100);
//                }
//            }
//        });
//        backgroundThread.start();
        int num = Integer.parseInt(binding.edtNumbOfViews.getText().toString());
        binding.containerLayout.removeAllViews();
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1 ; i <= num; i++) {

                    // Complex task
                    percent = i * 100 / num; // percent
                    randNumb = random.nextInt(100);

                    handler.post(foregroundThread);

                    SystemClock.sleep(100);
                }
            }
        });
        backgroundThread.start();
    }
}