package com.keaven.android.base.drawable;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.keaven.android.base.R;

/**
 * 自定义Drawable
 * 演示： 1，圆形
 *        2，圆角矩形
 *
 * Created by a-keaven on 2016/10/23.
 */
public class CustomerDrawableActivity extends Activity {
    private ImageView mImageViewCircle;
    private ImageView mImageViewRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_drawable);
        // 圆形图片
        mImageViewCircle = (ImageView) findViewById(R.id.iv_circle);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.women);
        mImageViewCircle.setImageDrawable(new CircleDrawable(bitmap));

        //圆角矩阵图片
        mImageViewRound = (ImageView) findViewById(R.id.iv_round);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.round_proc);
        mImageViewRound.setImageDrawable(new RoundDrawable(bitmap2));
    }
}
