package com.cbr.android.cbrrecyclerview.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cbr.android.cbrrecyclerview.CbrObject;
import com.cbr.android.cbrrecyclerview.R;
import com.cbr.android.cbrrecyclerview.Views.CbrViewHolder;

import java.util.ArrayList;

public class CbrAdapter extends RecyclerView.Adapter<CbrViewHolder> {

    private ArrayList<CbrObject> items;

    @Override
    public CbrViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_cbrobject,parent,false);
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_cbrobject,parent,false);//view pou dimiougeis kai view parent, epistrefei ti tha emfanistei //false, na min kanei to view attach ston parent
        return new CbrViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CbrViewHolder holder, int position) {
        holder.bindData(items.get(position));
    }

    @Override
    public int getItemCount() {
        if(items != null){
            return items.size();
        }else{
            return 0;
        }
    }

    public CbrAdapter(ArrayList<CbrObject> list){
        this.items = new ArrayList<CbrObject>(list);
    }
}
