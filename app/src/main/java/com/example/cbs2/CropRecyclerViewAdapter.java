package com.example.cbs2;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CropRecyclerViewAdapter extends RecyclerView.Adapter<CropRecyclerViewAdapter.MyViewHolder> {

        CardView cardView;
        Context context;
    private Crop[] presentCrops;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView cropPhotoImageView;
        TextView cropNameTextView;
        public MyViewHolder(CardView v) {
            super(v);
            cardView = v;
            this.cropPhotoImageView = (ImageView)v.findViewById(R.id.crop_photo);
            this.cropNameTextView = (TextView)v.findViewById(R.id.crop_name);
        }
    }

    public CropRecyclerViewAdapter(Crop[] presentCrops, Context context) {
        this.presentCrops = presentCrops;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        CardView cropCardView = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.crop_cardview, viewGroup, false);
        cropCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CropStatusActivity.class);
                intent.putExtra("Crop Name", presentCrops[i].getName());
                context.startActivity(intent);
            }
        });
        MyViewHolder vh = new MyViewHolder(cropCardView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int index){
//        TODO correct this image
        if(presentCrops[index].getPhotoID() != -1)
            myViewHolder.cropPhotoImageView.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.wheat));
        myViewHolder.cropNameTextView.setText(presentCrops[index].getName());
    }

    @Override
    public int getItemCount() {
        if(presentCrops == null)
                return 0;
        return presentCrops.length;
    }

}
