package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;

public class webView extends AppCompatActivity {


    Toolbar toolbar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.hereWeb);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        Intent intent=getIntent();
        String url= intent.getStringExtra("url");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);



        // Rest of your code here
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}