package com.example.cbs2;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class AddNewCropActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Inside add new activity");
        setContentView(R.layout.activity_add_new_crop);
        context = AddNewCropActivity.this;

        (new GetDataAsyncTask()).execute();
        System.out.println("Crossed Async task");

    }

    @Override
    protected void onResume() {
        super.onResume();
        (new GetDataAsyncTask()).execute();
    }

    public class GetDataAsyncTask extends AsyncTask<Void,Void,Crop[]> implements getCrops{

        ArrayList<Crop> arr = new ArrayList<Crop>();

        @Override
        protected Crop[] doInBackground(Void... voids) {

            recyclerView = (RecyclerView) findViewById(R.id.add_new_crop_recycler_view);

            layoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(layoutManager);

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference().child("available crops");
            ref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    System.out.println("Class : " + dataSnapshot.getValue().getClass());
                    System.out.println("Name : " + dataSnapshot.getValue(Crop.class).getName());
                    arr.add(dataSnapshot.getValue(Crop.class));
                    Crop crops[] = new Crop[arr.size()];
                    for(int i = 0; i < arr.size(); i++)
                        crops[i] = arr.get(i);
                    adapter = new CropRecyclerViewAdapter(crops, AddNewCropActivity.this);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
//            try {
//                semaphore.acquire();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            Crop crops[] = new Crop[arr.size()];
            for(int i = 0; i < arr.size(); i++)
                crops[i] = arr.get(i);
            return crops;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
//            TODO implement this method
        }

        @Override
        protected void onPostExecute(Crop[] crops) {
            adapter = new CropRecyclerViewAdapter(crops, AddNewCropActivity.this);
            recyclerView.setAdapter(adapter);
        }

        @Override
        public void Crops() {

        }
    }

    public interface getCrops{
        public void Crops();
    }

}
