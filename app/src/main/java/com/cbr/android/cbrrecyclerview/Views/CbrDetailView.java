package com.cbr.android.cbrrecyclerview.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.cbr.android.cbrrecyclerview.R;

public class CbrDetailView extends AppCompatActivity{

    private static final String EXTRA_CBR_NAME = "com.cbr.android.cbrrecyclerview2.extra_cbr_name";
    private static final String EXTRA_CBR_ID = "com.cbr.android.cbrrecyclerview2.extra_cbr_id";
    private static final String EXTRA_CBR_WORKING = "com.cbr.android.cbrrecyclerview2.extra_cbr_working";

    private String Name;
    private TextView ShowName;

    private int Id;
    private TextView ShowId;

    private boolean Working;
    private CheckBox ShowWorking;

    public static Intent newIntent(Context packageContext, String name, int id, boolean working){
        Intent i = new Intent(packageContext,CbrDetailView.class);

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

        Name = getIntent().getStringExtra(EXTRA_CBR_NAME);
        Id = getIntent().getIntExtra(EXTRA_CBR_ID,0);
        Working = getIntent().getBooleanExtra(EXTRA_CBR_WORKING,false);

        ShowName = (TextView) findViewById(R.id.view_cbr_detail_name);
        ShowName.setText(Name);

        ShowId = (TextView) findViewById(R.id.view_cbr_detail_id);
        ShowId.setText(String.valueOf(Id));

        ShowWorking = (CheckBox) findViewById(R.id.view_cbr_detail_checkbox);
        ShowWorking.setChecked(Working);


    }
    
}
