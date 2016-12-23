package com.keaven.android.base.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.keaven.android.base.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a-keaven on 2016/12/23.
 */
public class GridLayoutAdapter extends RecyclerView.Adapter<GridItemViewHolder>{
    private final LayoutInflater mLayoutInflater;
    private List<String> mDatas=new ArrayList<>();
    public GridLayoutAdapter(Context context) {
        this.mLayoutInflater = LayoutInflater.from(context);
    }
    public GridLayoutAdapter(Context context, List<String> mDatas) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
    }

    @Override
    public GridItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GridItemViewHolder holder = new GridItemViewHolder(mLayoutInflater.inflate(R.layout.item_grid,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(GridItemViewHolder holder, int position) {
        holder.tvName.setText(mDatas.get(position));
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,100+(int) (Math.random() * 50));
//        holder.imageView.setLayoutParams(lp);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
