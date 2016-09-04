package com.cbr.android.cbrrecyclerview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cbr.android.cbrrecyclerview.CbrObject;
import com.cbr.android.cbrrecyclerview.Interfaces.ListListener;
import com.cbr.android.cbrrecyclerview.R;
import com.cbr.android.cbrrecyclerview.views.CbrViewHolder;

import java.util.ArrayList;

public class CbrAdapter extends RecyclerView.Adapter<CbrViewHolder> {

    private ArrayList<CbrObject> items;
    private ListListener mListListener; //me auto o adapter milaei me to activity

    @Override
    public CbrViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_cbrobject,parent,false);
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_cbrobject,parent,false);//view pou dimiougeis kai view parent, epistrefei ti tha emfanistei //false, na min kanei to view attach ston parent
        return new CbrViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CbrViewHolder holder, final int position) {
        holder.bindData(items.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListListener.onItemClicked(items.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if(items != null){
            return items.size();
        }else{
            return 0;
        }
    }

    public CbrAdapter(ArrayList<CbrObject> list,ListListener listListener){//ston adapter yparxei enas listener, gia na parakolouthei an tou pernaei ena activity
        this.items = new ArrayList<CbrObject>(list);
        this.mListListener = listListener;
    }
}
