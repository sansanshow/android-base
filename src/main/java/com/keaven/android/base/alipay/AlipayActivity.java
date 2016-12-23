package com.keaven.android.base.alipay;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.keaven.android.base.BaseActivity;
import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/12/21.
 */
public class AlipayActivity extends BaseActivity {
    Button mBtnalipay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alipay);
        mBtnalipay = (Button) findViewById(R.id.btn_alipay);
        mBtnalipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
