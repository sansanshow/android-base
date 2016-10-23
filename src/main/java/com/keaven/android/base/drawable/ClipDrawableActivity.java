package com.keaven.android.base.drawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.keaven.android.base.R;

/**
 * ClipDrawable 的简单使用
 * Created by a-keaven on 2016/10/23.
 */
public class ClipDrawableActivity extends Activity {
    private ImageView mImageView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clip_drawable);
        mImageView = (ImageView) findViewById(R.id.iv_clip);
        mEditText = (EditText) findViewById(R.id.et_clip);
        mImageView.setImageLevel(5000);
    }

    public void doClipSize(View view) {
        String clipStr = mEditText.getText().toString();
        mImageView.setImageLevel(Integer.parseInt(clipStr));
    }

}
