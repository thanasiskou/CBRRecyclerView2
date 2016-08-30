package com.cbr.android.cbrrecyclerview.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cbr.android.cbrrecyclerview.Adapters.CbrAdapter;
import com.cbr.android.cbrrecyclerview.CbrObject;
import com.cbr.android.cbrrecyclerview.MainActivity;
import com.cbr.android.cbrrecyclerview.R;

import static android.support.v4.app.ActivityCompat.startActivity;
import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class CbrViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/{

    private TextView NameTextView;
    private TextView IdTextView;
    private CheckBox WorkingCheckBox;

    public CbrViewHolder(View itemView) {
        super(itemView);

        //itemView.setOnClickListener(this);

        NameTextView = (TextView) itemView.findViewById(R.id.view_cbrobject_name);
        IdTextView = (TextView) itemView.findViewById(R.id.view_cbrobject_id);
        WorkingCheckBox = (CheckBox) itemView.findViewById(R.id.view_cbrobject_checkbox);

    }


    public void bindData(final CbrObject object){
        final CbrObject CbrObject = object;
        NameTextView.setText(CbrObject.getName());
        IdTextView.setText(String.valueOf(CbrObject.getId()));
        WorkingCheckBox.setChecked(CbrObject.isWorking());
        WorkingCheckBox.setEnabled(true);
        WorkingCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CbrObject.setWorking(isChecked);
                Toast.makeText(itemView.getContext(),CbrObject.getName() + " working: " + CbrObject.isWorking(),Toast.LENGTH_SHORT).show();
            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(),"Clicked " + CbrObject.getName(),Toast.LENGTH_SHORT).show();
                String name = CbrObject.getName();
                int id = CbrObject.getId();
                boolean working = CbrObject.isWorking();
                Intent i = CbrDetailView.newIntent(v.getContext(),name,id,working);
                v.getContext().startActivity(i);//?????????????
                //startActivity(i);
            }
        });
    }

}
