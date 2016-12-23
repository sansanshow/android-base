package com.keaven.android.base.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.keaven.android.base.BaseActivity;
import com.keaven.android.base.R;

import java.util.Random;

/**
 * Created by a-keaven on 2016/12/20.
 */
public class LineViewActivity extends BaseActivity {
    private final static int MSG_DATA_CHANGE = 1000;
    LineView mLineView;
    int mX = 0;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_DATA_CHANGE:
                    mLineView.setLinePoint(msg.arg1, msg.arg2);
                    Log.i("line_view",""+msg.arg1);
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        mLineView = (LineView) findViewById(R.id.line_view);
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    Message msg = new Message();
                    msg.what = MSG_DATA_CHANGE;
                    msg.arg1 = mX;
                    msg.arg2 = (int) (Math.random() * 200);
                    mHandler.sendMessage(msg);
                    try {
                        sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mX += 30;
                }

            }
        }.start();
    }
}
