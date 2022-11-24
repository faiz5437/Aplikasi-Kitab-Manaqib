package com.ars.pdfreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    List<String> listData ;
    LayoutInflater inflater;
    Context context;

    public AdapterData(Context context, List<String> listData) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =inflater.inflate(R.layout.item_data, viewGroup, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holderData, int position) {
        holderData.tv1.setText(listData.get(position));
//        holderData.tv2.setText(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tv1;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.dataText);
//            tv2 = itemView.findViewById(R.id.dataText2);

        }
    }
}
