package com.keaven.android.base.drawable;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.keaven.android.base.R;

/**
 * TransitionDrawable 的简单使用
 * TransitionDrawable是LayerDrawable的子类，不过它只负责管理两层drawable，
 * 并且提供了一个透明变化的动画，可以从议程drawable过渡到另外一层drawable的动画效果。
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
        drawable.reverseTransition(2000);
    }
}
