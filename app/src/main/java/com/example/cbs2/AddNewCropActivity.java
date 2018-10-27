package com.example.cbs2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AddNewCropActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Crop[] availableCrops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        availableCrops = Utils.getAvailableCrops(AddNewCropActivity.this);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                availableCrops = Utils.getAvailableCrops(AddNewCropActivity.this);
//            }
//        });
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Inside add new activity");
        setContentView(R.layout.activity_add_new_crop);

        recyclerView = (RecyclerView) findViewById(R.id.add_new_crop_recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CropRecyclerViewAdapter(availableCrops, AddNewCropActivity.this);
        recyclerView.setAdapter(adapter);

    }
}
