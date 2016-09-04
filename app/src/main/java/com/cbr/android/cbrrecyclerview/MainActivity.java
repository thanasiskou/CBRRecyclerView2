package com.cbr.android.cbrrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cbr.android.cbrrecyclerview.Interfaces.ListListener;
import com.cbr.android.cbrrecyclerview.activities.CbrDetailActivity;
import com.cbr.android.cbrrecyclerview.adapters.CbrAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListListener {

	public static final int REQUEST_DETAILS = 10001;
	private RecyclerView mRecyclerView;
	private CbrAdapter mCbrAdapter;

	private static final String EXTRA_CBR_ID = "com.cbr.android.cbrrecyclerview2.cbr_id";

	public static Intent newIntent(Context packageContext, int id) {
		Intent intent = new Intent(packageContext, MainActivity.class);
		intent.putExtra(EXTRA_CBR_ID, id);
		return intent;
	}

	private ArrayList<CbrObject> generateCBRs() {
		ArrayList<CbrObject> list = new ArrayList<>();
		for (int i = 0; i < 40; i++) {
			list.add(new CbrObject("CBR #" + i, i, (i % 2 == 1) ? true : false));
		}
		return list;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);

		mCbrAdapter = new CbrAdapter(generateCBRs(), this);

		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.setAdapter(mCbrAdapter);
	}

	@Override
	public void onItemClicked(CbrObject object) {
		Intent intent = new Intent(this, CbrDetailActivity.class);
		intent.putExtra(CbrDetailActivity.EXTRA_CBR_OBJECT, object);
		startActivityForResult(intent, REQUEST_DETAILS);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK && requestCode == REQUEST_DETAILS) {
			mCbrAdapter.updateData((CbrObject) data.getSerializableExtra(CbrDetailActivity.EXTRA_CBR_OBJECT));
		}
	}
}