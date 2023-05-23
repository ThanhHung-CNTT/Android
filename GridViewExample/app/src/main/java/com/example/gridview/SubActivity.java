package com.example.gridview;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gridview.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();

        String subName = intent.getStringExtra("subName");
        int subImage = intent.getIntExtra("subImage", 0);

        TextView subBeerName = findViewById(R.id.subBeerName);
        ImageView subBeerImage = findViewById(R.id.subBeerImage);

        subBeerName.setText(subName);
        subBeerImage.setImageResource(subImage);

        Button back = findViewById(R.id.btnBack);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}