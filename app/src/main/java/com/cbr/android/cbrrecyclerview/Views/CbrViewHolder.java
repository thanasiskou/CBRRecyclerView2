package com.cbr.android.cbrrecyclerview.Views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cbr.android.cbrrecyclerview.CbrObject;
import com.cbr.android.cbrrecyclerview.MainActivity;
import com.cbr.android.cbrrecyclerview.R;

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


    public void bindData(CbrObject object){
        final CbrObject CbrObject = object;
        NameTextView.setText(object.getName());
        IdTextView.setText(String.valueOf(object.getId()));
        WorkingCheckBox.setChecked(object.isWorking());
        WorkingCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CbrObject.setWorking(isChecked);
                Toast.makeText(itemView.getContext(),CbrObject.getName() + " working: " + CbrObject.isWorking(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*
    @Override
    public void onClick(View itemView){
        Toast.makeText(itemView.getContext(),"Name " + NameTextView.getText(),Toast.LENGTH_SHORT).show();
    }*/

}
