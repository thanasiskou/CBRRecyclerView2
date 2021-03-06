package com.cbr.android.cbrrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cbr.android.cbrrecyclerview.Adapters.CbrAdapter;

import java.util.ArrayList;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private static final String EXTRA_CBR_ID = "com.cbr.android.cbrrecyclerview2.cbr_id";

    public static Intent newIntent(Context packageContext, int id){
        Intent intent = new Intent(packageContext,MainActivity.class);
        intent.putExtra(EXTRA_CBR_ID,id);
        return intent;
    }

    private ArrayList<CbrObject> generateCBRs() {
        ArrayList<CbrObject> list = new ArrayList<>();
        list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add(new CbrObject("CBR #"+i,i,(i%2==1)?true:false));
        }
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);

        CbrAdapter cbrAdapter = new CbrAdapter(generateCBRs());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cbrAdapter);
    }

}