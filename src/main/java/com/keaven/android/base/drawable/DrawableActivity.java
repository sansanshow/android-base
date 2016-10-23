package com.keaven.android.base.drawable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.keaven.android.base.R;

/**
 * 各种Drawable介绍
 * 入口
 * Created by a-keaven on 2016/10/23.
 */
public class DrawableActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
    }

    public void bitmapDrawable(View view) {
        startActivity(new Intent(this, BitmapDrawableActivity.class));
    }

    /**
     * 层次
     * @param view
     */
    public void layerDrawable(View view) {
        startActivity(new Intent(this, LayerDrawableActivity.class));
    }

    /**
     * 在level范围内的显示
     * @param view
     */
    public void levelDrawable(View view) {
        startActivity(new Intent(this, LevelListDrawableActivity.class));

    }

    /**
     * 有过渡动画的Drawabe
     * @param view
     */
    public void transitionDrawable(View view) {
        startActivity(new Intent(this, TransitionDrawableActivity.class));

    }

    /**
     * 四周有padding的Drawable
     * @param view
     */
    public void insertDrawable(View view) {
        startActivity(new Intent(this, InsertDrawableActivity.class));

    }

    /**
     * 用来裁剪的Drawable
     */
    public void clipDrawable(View view) {
        startActivity(new Intent(this, ClipDrawableActivity.class));

    }
}
