package com.example.newsapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private ArrayList<ModelClass> modelClassArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_news, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        ModelClass model = modelClassArrayList.get(position);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url", model.getUrl());
                context.startActivity(intent);
            }
        });

        holder.mtime.setText("Published At: " + model.getPublishAt());
        holder.mauthor.setText(model.getAuthor());
        holder.mheading.setText(model.getTitle());
        holder.mcontent.setText(model.getDescription());

        Glide.with(context)
                .load(model.getUrlToImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mheading, mcontent, mauthor, mtime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mheading = itemView.findViewById(R.id.mainHeading);
            mcontent = itemView.findViewById(R.id.content);
            mauthor = itemView.findViewById(R.id.author);
            mtime = itemView.findViewById(R.id.datetime);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.carview);
        }
    }
}
