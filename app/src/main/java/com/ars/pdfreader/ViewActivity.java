package com.ars.pdfreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {
    WebView wv;
    TextView judulView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getSupportActionBar().hide();

        String getIntent = getIntent().getStringExtra("nama");
        judulView = findViewById(R.id.judul_view);
        judulView.setText(getIntent);

        WebView wv = findViewById(R.id.web_view);
        wv.loadUrl("file:///android_asset/"+getIntent+"/index.html");
    }
}