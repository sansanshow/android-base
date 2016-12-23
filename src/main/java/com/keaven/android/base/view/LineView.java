package com.keaven.android.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a-keaven on 2016/12/20.
 */
public class LineView extends View {
    private final static String X_KEY = "x_pos";
    private final static String Y_KEY = "y_pos";
    private List<Map<String, Integer>> mPosList = new ArrayList<Map<String, Integer>>();
    Paint mPaint = new Paint();

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);// 抗锯齿
        for (int index = 0; index < mPosList.size(); index++) {
            if (index > 0) {
                canvas.drawLine(mPosList.get(index - 1).get(X_KEY), mPosList.get(index - 1).get(Y_KEY), mPosList.get(index).get(X_KEY), mPosList.get(index).get(Y_KEY), mPaint);
                canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
            }
        }
    }
    public void setLinePoint(int x,int y){
        Map<String,Integer> temp = new HashMap<String,Integer>();
        temp.put(X_KEY,x);
        temp.put(Y_KEY,y);
        mPosList.add(temp);
        invalidate();
    }
}
