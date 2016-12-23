package com.keaven.android.base.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.keaven.android.base.BaseActivity;
import com.keaven.android.base.BaseUtils;
import com.keaven.android.base.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a-keaven on 2016/12/23.
 */
public class GridLayoutActivity extends BaseActivity{
    private RecyclerView mGridview;
    private List<String> mDatas=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridlayout);
        mGridview = (RecyclerView) findViewById(R.id.rcl_gridlayout);
        initData(27);
        //3列   方向垂直
        StaggeredGridLayoutManager mgr = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        GridLayoutManager mgr = new GridLayoutManager(this,4)

        mGridview.setAdapter(new GridLayoutAdapter(this,mDatas));
        mGridview.setLayoutManager(new GridLayoutManager(this,4));
//        mGridview.setLayoutManager(mgr);
        mGridview.addItemDecoration(new DividerGridItemDecoration(this));
    }
    private void initData(int len){
        for (int i = 0; i < len; i++) {
            mDatas.add(BaseUtils.getRandomString(6));
        }
    }
}
