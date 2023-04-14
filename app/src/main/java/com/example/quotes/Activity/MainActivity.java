package com.example.quotes.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.Adapters.Adebpter1;
import com.example.quotes.Click.quotesClick;
import com.example.quotes.R;
import com.example.quotes.Utils.Utils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler1 = findViewById(R.id.recycler1);

        quotesClick click = new quotesClick() {
            @Override
            public void getquotes(String quote) {
                Intent intent = new Intent(MainActivity.this, imgMainActivity.class);
                intent.putExtra("quote", quote);
                startActivity(intent);
            }
        };

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        Adebpter1 adebpter = new Adebpter1(Utils.quotes,click);
        recycler1.setLayoutManager(manager);
        recycler1.setAdapter(adebpter);
    }
}