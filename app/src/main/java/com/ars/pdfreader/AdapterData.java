package com.ars.pdfreader;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderViewSaya>{
    ArrayList<String> id, nama;
    Context ctx;

    public AdapterData(ArrayList<String> id, ArrayList<String> nama, Context ctx) {
        this.id = id;
        this.nama = nama;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public HolderViewSaya onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,parent, false);
        HolderViewSaya holderViewSaya =new HolderViewSaya(layout);
        return holderViewSaya;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderViewSaya holder, int position) {
        holder.id.setText(id.get(position));
        holder.nama.setText(nama.get(position));
        
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(ctx, "Data Clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ctx, ViewActivity.class);

                Log.d("cek Data", "ini : " + nama.get(position));
                i.putExtra("nama", nama.get(position));
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nama.size();
    }

    public class HolderViewSaya extends RecyclerView.ViewHolder{
        TextView id, nama;

        public HolderViewSaya(@NonNull View itemView, TextView id, TextView nama) {
            super(itemView);
            this.id = id;
            this.nama = nama;
        }

        public HolderViewSaya(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.tv_id);
            nama = itemView.findViewById(R.id.dataText);
        }
    }
}
