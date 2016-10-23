package com.keaven.android.base.drawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/10/23.
 */
public class LevelListDrawableActivity extends Activity{
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_list);
        mImageView = (ImageView) findViewById(R.id.iv_levellist);
        mImageView.setImageLevel(10);
    }
    public void doWomen(View view){
        mImageView.setImageLevel(10);
    }
    public void doMen(View view){
        mImageView.setImageLevel(18);

    }
}
