package com.example.quotes.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.Click.quotesClick;
import com.example.quotes.R;

public class Adebpter1 extends RecyclerView.Adapter<Adebpter1.Holder> {

    String[] quotes;
    quotesClick click;


    public Adebpter1(String[] quotes, quotesClick click) {
        this.quotes = quotes;
        this.click = click;

    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotes, parent, false);

        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") int position) {
        holder.txt1.setText(quotes[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.getquotes(quotes[position]);

            }
        });

    }


    @Override
    public int getItemCount() {
        return quotes.length;
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView txt1;

        public Holder(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txt1);
        }
    }

    ;
}
