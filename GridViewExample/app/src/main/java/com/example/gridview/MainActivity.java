package com.example.gridview;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gridview.adapter.BeerAdapter;
import com.example.gridview.model.BeerModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    BeerAdapter beerAdapter;
    ArrayList<BeerModel> listBeer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gvBeer);

        listBeer.add(new BeerModel("Tiger", R.drawable.tiger));
        listBeer.add(new BeerModel("Bia Viet", R.drawable.biaviet));
        listBeer.add(new BeerModel("Sai Gon", R.drawable.saigon));
        listBeer.add(new BeerModel("Heineken", R.drawable.heineken));
        listBeer.add(new BeerModel("Bia 333", R.drawable.bia333));
        listBeer.add(new BeerModel("Sapporo", R.drawable.sapporo));
        listBeer.add(new BeerModel("Larue", R.drawable.larue));

        beerAdapter = new BeerAdapter(MainActivity.this, R.layout.item_beer, listBeer);
        gridView.setAdapter(beerAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(MainActivity.this, listBeer.get(position).getBeerName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("subName", listBeer.get(position).getBeerName());
                intent.putExtra("subImage", listBeer.get(position).getImgID());
                startActivity(intent);

            }
        });
    }
}