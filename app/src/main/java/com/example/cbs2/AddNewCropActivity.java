package com.example.cbs2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AddNewCropActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_crop);

        recyclerView = (RecyclerView) findViewById(R.id.add_new_crop_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Crop[] availableCrops;
        availableCrops = Utils.getAvailableCrops(this);
        adapter = new CropRecyclerViewAdapter(availableCrops, AddNewCropActivity.this);
        recyclerView.setAdapter(adapter);

    }
}
