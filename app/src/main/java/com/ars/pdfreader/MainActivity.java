package com.ars.pdfreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    ImageView btnIfno;
    RecyclerView recyclerView;
    ArrayList<String> arId = new ArrayList<>();
    ArrayList<String> arNama = new ArrayList<>();
    LinearLayout btnTahlil, btnHusainiyah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getSupportActionBar().hide();
        btnIfno = findViewById(R.id.infoBtn);
        btnTahlil = findViewById(R.id.btn_tahlil);
        btnHusainiyah = findViewById(R.id.btn_husainiyah);
        
        btnTahlil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "tahlil Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(view.getContext(), TahlilActivity.class));

            }
        });
        btnHusainiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "husainiyah Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(view.getContext(), HusainiyahActivity.class));

            }
        });



        btnIfno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), AboutActivity.class));
            }
        });

        recyclerView = findViewById(R.id.rv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        try {
            JSONObject obj = new JSONObject(JsonDariAsset());
            JSONObject objObject = obj.getJSONObject("data");
            JSONArray userArray = objObject.getJSONArray("manaqib");
//            int a =0;
            for(int i = 0; i<userArray.length();i++){
//                a++;
                JSONObject userDetail = userArray.getJSONObject(i);
//                arId.add(String.valueOf(a));
                arId.add(userDetail.getString("id"));
                arNama.add(userDetail.getString("nama bacaan"));
                Log.d("JSON OBJECT : ", "jeson 3: "+ userArray.length());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
//        Log.d("JSON OBJECT : ", "jeson : "+ nama);
        AdapterData adapterData = new AdapterData( arId, arNama, this);
        recyclerView.setAdapter(adapterData);

//        listview = findViewById(R.id.list_view);
//        ArrayAdapter<String>  arrAdapter = new ArrayAdapter<>(this, R.layout.item_data, R.id.dataText,namaKitab);
//        listview.setAdapter(arrAdapter);
//
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
//
//                String clickCek = namaKitab.toString();
//                Log.d("arg", "cek "+ arg2);
//                Intent i = new Intent(getApplicationContext(), ViewActivity.class);
//                i.putExtra("nama",namaKitab[arg2]);
//                startActivity(i);
//            }
//        });
    }

    private String JsonDariAsset() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("data.json");

            int sizeOfFile = inputStream.available();
            byte[] bufferData = new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json = new String(bufferData, "UTF-8");
            Log.d("JSON OBJECT : ", "jeson 2 : "+ json.toString());



        } catch (IOException e) {
            e.printStackTrace();

        }
        return json;
    }
}
