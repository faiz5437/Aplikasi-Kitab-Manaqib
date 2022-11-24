package com.ars.pdfreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    RecyclerView recyclerView;
//    LinearLayoutManager linearLayoutManager;
//    AdapterData adapterData;
//    List<String> listData;
    ListView listview;
    ImageView btnIfno;
//    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] namaKitab = {"1. Istighosah", "2. Surah Yasiin", "3. Do'a Surah Yasiin", "4. Surah - Surah"
                , "5. Manaqib", "6. Manaqib Bab 1", "7. Manaqib Bab 2", "8. Manaqib Bab 3", "9. Manaqib Bab 4"
                , "10. Manaqib Bab 5", "11. Manaqib Bab 6", "12. Manaqib Bab 7", "13. Wahaisuntaha", "14. 'Ibadallah & Do'a 'Ibadallah"
                , "15. Ya Arhamar Rohimin", "16. Do'a", "17. Nasyid Lailaha ila Allah","18. Nasyid Al Munajah", "19. Maulid Diba'",
                "20. Do'a Maulid", "21. Shalawat Fi Hubbi", "22. Do'a Al Fatihah"
    };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getSupportActionBar().hide();
        btnIfno = findViewById(R.id.infoBtn);
        btnIfno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), AboutActivity.class));
            }
        });

//        recyclerView = findViewById(R.id.rvData);
//        listData = new ArrayList<>();
//
//        for (int a = 0; a<10;a++){
//            listData.add("Data Ke - "+ String.valueOf(a));
//
//        }
//        Log.d("arrcobaan", listData.get(1));
//
//        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);

//        adapterData = new AdapterData(this, listData);
//        recyclerView.setAdapter(adapterData);
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        adapterData.notifyDataSetChanged();
//        int i = 1;
//        for (i = 0; i<merekSmartphone.length;i++){
//
//        }
        listview = findViewById(R.id.list_view);
        ArrayAdapter<String>  arrAdapter = new ArrayAdapter<>(this, R.layout.item_data, R.id.dataText,namaKitab);
            listview.setAdapter(arrAdapter);
//        WebView wv = findViewById(R.id.web_view);
//        wv.loadUrl("file:///android_asset/Custompage615294/index.html");


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {

                String clickCek = namaKitab.toString();
//                String getArgId = getString(arg2);
                Log.d("arg", "cek "+ arg2);
                Intent i = new Intent(getApplicationContext(), ViewActivity.class);
                i.putExtra("nama",namaKitab[arg2]);
                startActivity(i);
//                Toast.makeText(MainActivity.this, namaKitab[arg2], Toast.LENGTH_SHORT).show();
            }
        });
    }
}