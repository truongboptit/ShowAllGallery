package com.example.truongle.showallgallery;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by TruongLe on 28/08/2017.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolderPhoto> {
    Activity activity;
    ArrayList<Photo> list;

    public PhotoAdapter(Activity activity, ArrayList<Photo> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public ViewHolderPhoto onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.device_photos_item,parent,false);
        return new ViewHolderPhoto(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolderPhoto holder, final int position) {
        Glide.with(activity).load(list.get(position).getImagePath()).into(holder.imageView);
        holder.txtDate.setText(list.get(position).getDate());
        holder.txtNum.setText(list.get(position).getNumberPhoto()+" photo");
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,Main2Activity.class);
                intent.putExtra("imagePath",list.get(position).getImagePath());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderPhoto extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txtDate, txtNum;
        View view;
        public ViewHolderPhoto(View itemView) {
            super(itemView);
            view = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.imageViewPhotos);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            txtDate = (TextView) itemView.findViewById(R.id.textViewDate);
            txtNum = (TextView) itemView.findViewById(R.id.textViewNum);
        }
    }
}
