package com.keaven.android.base.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.keaven.android.base.BaseActivity;
import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/11/9.
 */
public class FeedListActivity extends BaseActivity{
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedlist);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    }
}
