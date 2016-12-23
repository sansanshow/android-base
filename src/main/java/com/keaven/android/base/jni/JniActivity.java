package com.keaven.android.base.jni;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/11/22.
 */
public class JniActivity extends Activity implements View.OnClickListener {
    Button mBtnsquare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni);
        mBtnsquare = (Button) findViewById(R.id.btn_jni_square);
        mBtnsquare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_jni_square:
               int result = MathKit.square(2);
                System.out.println("--------result---"+result);
                break;
        }
    }
}
