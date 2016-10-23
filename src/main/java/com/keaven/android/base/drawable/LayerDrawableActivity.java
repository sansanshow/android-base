package com.keaven.android.base.drawable;

import android.app.Activity;
import android.os.Bundle;

import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/10/23.
 */
public class LayerDrawableActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layer_drawable);
    }
}
