package com.keaven.android.base.drawable;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.keaven.android.base.R;

/**
 * BitmapDrawable 的简单使用
 * Created by a-keaven on 2016/10/23.
 */
public class TransitionDrawableActivity extends Activity{
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transition_drawable);
        mImageView = (ImageView) findViewById(R.id.iv_levellist);
        mImageView.setImageLevel(10);
    }
    public void doWomen(View view){
        TransitionDrawable drawable = (TransitionDrawable) mImageView.getDrawable();
        drawable.startTransition(2000);
    }
    public void doMen(View view){
        TransitionDrawable drawable = (TransitionDrawable) mImageView.getDrawable();
        drawable.resetTransition();
    }
}
