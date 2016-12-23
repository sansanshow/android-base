package com.keaven.android.base.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.keaven.android.base.R;


/**
 * Created by a-keaven on 2016/12/23.
 */
public class GridItemViewHolder  extends RecyclerView.ViewHolder{
    TextView tvName;
    ImageView imageView;
    public GridItemViewHolder(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        imageView = (ImageView) itemView.findViewById(R.id.iv_icon);
    }
}
