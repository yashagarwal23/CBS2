package com.example.cbs2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;

public class Utils {

    private static ArrayList<Crop> result = new ArrayList<Crop>();

    public static Crop[] getAvailableCrops(Context context) {

        Crop[] sr = new Crop[2];
        sr[0] = new Crop("tomato");
        sr[1] = new Crop("maize");
        return sr;

//        SharedPreferences prefs = context.getSharedPreferences("general_settings", Context.MODE_PRIVATE);
//        if(prefs.contains("available crops")) {
//            try {
////                TODO add the arraylist to shared prefrences also
//                result = (ArrayList<Crop>) ObjectSerialiser.deserialize(prefs.getString("available crops", ObjectSerialiser.serialize(new ArrayList<Crop>())));
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        } else {
//            final FirebaseDatabase database = FirebaseDatabase.getInstance();
//            DatabaseReference ref = database.getReference("available crops");
//            ref.addChildEventListener(new ChildEventListener() {
//                @Override
//                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                    String temp = dataSnapshot.getValue(String.class);
//                    result.add(new Crop(temp));
//                }
//
//                @Override
//                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                }
//
//                @Override
//                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//                }
//
//                @Override
//                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//                    System.out.println("The read failed: " + databaseError.getCode());
//                }
//            });
//        }
//        Crop[] ans = new Crop[result.size()];
//        for(int i = 0; i < result.size(); i++)
//            ans[i] = result.get(i);
//        return ans;
    }
}
