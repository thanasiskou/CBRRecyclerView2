package com.cbr.android.cbrrecyclerview.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.TextView;

import com.cbr.android.cbrrecyclerview.R;

public class CbrDetailActivity extends AppCompatActivity{

    private static final String EXTRA_CBR_NAME = "com.cbr.android.cbrrecyclerview2.extra_cbr_name";
    private static final String EXTRA_CBR_ID = "com.cbr.android.cbrrecyclerview2.extra_cbr_id";
    private static final String EXTRA_CBR_WORKING = "com.cbr.android.cbrrecyclerview2.extra_cbr_working";

    private String name;
    private TextView showNameTextView;

    private int id;
    private TextView showIdTextView;

    private boolean isWorking;
    private CheckBox showIsWorking;

    public static Intent newIntent(Context packageContext, String name, int id, boolean working){
        Intent i = new Intent(packageContext,CbrDetailActivity.class);

        /*
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_CBR_NAME,name);
        bundle.putInt(EXTRA_CBR_ID,id);
        bundle.putBoolean(EXTRA_CBR_WORKING,working);
        i.putExtras(bundle);*/

        i.putExtra(EXTRA_CBR_NAME,name);
        i.putExtra(EXTRA_CBR_ID,id);
        i.putExtra(EXTRA_CBR_WORKING,working);
        return i;
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.cbr_detail);

        name = getIntent().getStringExtra(EXTRA_CBR_NAME);
        id = getIntent().getIntExtra(EXTRA_CBR_ID,0);
        isWorking = getIntent().getBooleanExtra(EXTRA_CBR_WORKING,false);

        showNameTextView = (TextView) findViewById(R.id.view_cbr_detail_name);
        showNameTextView.setText(name);

        showIdTextView = (TextView) findViewById(R.id.view_cbr_detail_id);
        showIdTextView.setText(String.valueOf(id));

        showIsWorking = (CheckBox) findViewById(R.id.view_cbr_detail_checkbox);
        showIsWorking.setChecked(isWorking);


    }
    
}
