package com.example.quotes.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quotes.Adapters.Adapters2;
import com.example.quotes.R;
import com.example.quotes.Click.imgclick;
import com.example.quotes.Utils.Utils;

public class imgMainActivity extends AppCompatActivity {

    TextView txt2;
    ImageView imgset;
    RecyclerView rcv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_main);
        txt2 = findViewById(R.id.txt2);
        rcv = findViewById(R.id.rcv);
        imgset = findViewById(R.id.imgset);

        imgclick imgclick = new imgclick() {
            @Override
            public void getimg(int pos) {
                Glide.with(imgMainActivity.this).load(Utils.imglist[pos]).into(imgset);
            }
        };


        RecyclerView.LayoutManager manager = new GridLayoutManager(this,2,RecyclerView.VERTICAL,false);
        Adapters2 adapters = new Adapters2(Utils.imglist,imgclick);
        rcv.setLayoutManager(manager);
        rcv.setAdapter(adapters);

        String textqu = getIntent().getStringExtra("quote");
        txt2.setText(textqu);

    }
}