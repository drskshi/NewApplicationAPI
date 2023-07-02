package com.example.newsapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InternationalFragment extends Fragment {
    String api= "0cf67e07f24345539ba31cd914d3bbc3";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="us";
    private String category="health";
    private RecyclerView recyclerViewofIN;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.internationalfragment, null);

        recyclerViewofIN = v.findViewById(R.id.internationalrecyclerview);
        modelClassArrayList = new ArrayList<>();
        recyclerViewofIN.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerViewofIN.setAdapter(adapter);

        findNews();

        return v;
    }
    private void findNews() {

        ApiUtilies.getApiInterface().getNews(country, 100, api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {

                if (response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {
            }
        });
            }
}
