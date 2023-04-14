package com.example.quotes.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quotes.Click.imgclick;
import com.example.quotes.R;

public class Adapters2 extends RecyclerView.Adapter<Adapters2.vHolder> {

    int[] imglist;
    imgclick imgclick;
    Context context;

    public Adapters2(int[] imglist, imgclick imgclick) {
        this.imgclick = imgclick;
        this.imglist = imglist;
    }

    @NonNull
    @Override
    public vHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img, parent, false);
        return new vHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull vHolder holder, @SuppressLint("RecyclerView") int position) {

        //Glide
        Glide.with(context).load(imglist[position]).into(holder.img3);

        holder.img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgclick.getimg(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return imglist.length;
    }

    class vHolder extends RecyclerView.ViewHolder {

        ImageView img3;

        public vHolder(@NonNull View itemView) {
            super(itemView);
            img3 = itemView.findViewById(R.id.img3);
        }
    }

}
