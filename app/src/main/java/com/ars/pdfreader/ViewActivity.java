package com.ars.pdfreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        String getIntent = getIntent().getStringExtra("nama");
        Toast.makeText(this, "ini "+getIntent, Toast.LENGTH_SHORT).show();

        WebView wv = findViewById(R.id.web_view);
        wv.loadUrl("file:///android_asset/"+getIntent+"/index.html");
    }
}