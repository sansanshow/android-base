package com.keaven.android.base.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * 自定义圆角矩阵 Drawable
 * Created by a-keaven on 2016/10/23.
 */
public class RoundDrawable extends Drawable {
    private Paint mPaint;
    private Bitmap mBitmap;
    private RectF rectF;

    public RoundDrawable(Bitmap bitmap) {
        this.mBitmap = bitmap;
         /*
            public   BitmapShader(Bitmap bitmap,Shader.TileMode tileX,Shader.TileMode tileY)
            调用这个方法来产生一个画有一个位图的渲染器（Shader）。
            bitmap   在渲染器内使用的位图
            tileX      The tiling mode for x to draw the bitmap in.   在位图上X方向花砖模式
            tileY     The tiling mode for y to draw the bitmap in.    在位图上Y方向花砖模式
            TileMode：（一共有三种）
            CLAMP  ：如果渲染器超出原始边界范围，会复制范围内边缘染色。
            REPEAT ：横向和纵向的重复渲染器图片，平铺。
            MIRROR ：横向和纵向的重复渲染器图片，这个和REPEAT 重复方式不一样，他是以镜像方式平铺。
         */
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);// 设置抗锯齿
        mPaint.setDither(true); //防抖动
        mPaint.setShader(bitmapShader);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(rectF, 30, 30, mPaint);
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        rectF = new RectF(left, top, right, bottom);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;//让这个Drawable支持跟窗口一样的透明度
    }

    @Override
    public int getIntrinsicHeight() {
        return mBitmap.getHeight();
    }

    @Override
    public int getIntrinsicWidth() {
        return mBitmap.getWidth();
    }
}
