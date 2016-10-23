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
    public void bitmapDrawable(View view){
        startActivity(new Intent(this,BitmapDrawableActivity.class));
    }
    public void layerDrawable(View view){
        startActivity(new Intent(this,LayerDrawableActivity.class));
    }
    public void levelDrawable(View view){
        startActivity(new Intent(this,LevelListDrawableActivity.class));

    }
}
