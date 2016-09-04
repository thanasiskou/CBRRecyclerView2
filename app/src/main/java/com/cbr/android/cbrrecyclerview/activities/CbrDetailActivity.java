package com.cbr.android.cbrrecyclerview.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.TextView;

import com.cbr.android.cbrrecyclerview.CbrObject;
import com.cbr.android.cbrrecyclerview.R;

public class CbrDetailActivity extends AppCompatActivity{

    public static final String EXTRA_CBR_OBJECT = "com.cbr.android.cbrrecyclerview2.extra_cbr_extra_object";

    /*
    public static Intent newIntent(Context packageContext, String name, int id, boolean working){
        Intent i = new Intent(packageContext,CbrDetailActivity.class);

        /*
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_CBR_NAME,name);
        bundle.putInt(EXTRA_CBR_ID,id);
        bundle.putBoolean(EXTRA_CBR_WORKING,working);
        i.putExtras(bundle);

        i.putExtra(EXTRA_CBR_NAME,name);
        i.putExtra(EXTRA_CBR_ID,id);
        i.putExtra(EXTRA_CBR_WORKING,working);
        return i;
    }
    */


    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.cbr_detail);

        bindViews(getObjectFromIntent());

    }

    private void bindViews(CbrObject object){
        TextView showNameTextView = (TextView) findViewById(R.id.view_cbr_detail_name);
        showNameTextView.setText(object.getName());

        TextView showIdTextView = (TextView) findViewById(R.id.view_cbr_detail_id);
        showIdTextView.setText(String.valueOf(object.getId()));

        CheckBox showIsWorking = (CheckBox) findViewById(R.id.view_cbr_detail_checkbox);
        showIsWorking.setChecked(object.isWorking());
    }

    private CbrObject getObjectFromIntent() {
        return (CbrObject) getIntent().getSerializableExtra(EXTRA_CBR_OBJECT);
    }

}
