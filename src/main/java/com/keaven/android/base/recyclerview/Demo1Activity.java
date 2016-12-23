package com.keaven.android.base.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.keaven.android.base.BaseActivity;
import com.keaven.android.base.BaseUtils;
import com.keaven.android.base.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a-keaven on 2016/12/23.
 */
public class Demo1Activity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas =new ArrayList<>();
    private RclAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedlist);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter =new RclAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
    }
    private void initData(){
        for (int i = 0; i < 10; i++) {
            mDatas.add(BaseUtils.getRandomString(6));
        }
    }
    class RclAdapter extends RecyclerView.Adapter<RclAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(Demo1Activity.this).inflate(R.layout.item_feed, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv_content);
            }
        }
    }
}
