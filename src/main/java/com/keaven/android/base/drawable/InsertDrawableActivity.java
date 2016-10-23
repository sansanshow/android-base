package com.keaven.android.base.drawable;

import android.app.Activity;
import android.os.Bundle;

import com.keaven.android.base.R;

/**
 * BitmapDrawable 的简单使用
 * Created by a-keaven on 2016/10/23.
 */
public class InsertDrawableActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_drawable);
    }
}
