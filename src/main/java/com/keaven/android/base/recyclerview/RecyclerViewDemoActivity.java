package com.keaven.android.base.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.keaven.android.base.BaseActivity;
import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/12/23.
 */
public class RecyclerViewDemoActivity extends BaseActivity implements View.OnClickListener {
    private Button mBtndemo1;
    private Button mBtndemo2;
    private Button mBtndemo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_demo);
        mBtndemo1 = (Button) findViewById(R.id.demo1);
        mBtndemo2 = (Button) findViewById(R.id.demo2);
        mBtndemo3 = (Button) findViewById(R.id.demo3);

        mBtndemo1.setOnClickListener(this);
        mBtndemo2.setOnClickListener(this);
        mBtndemo3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.demo1:
                startActivity(new Intent(this, Demo1Activity.class));
                break;
            case R.id.demo2:
                startActivity(new Intent(this, GridLayoutActivity.class));
                break;
            case R.id.demo3:
                startActivity(new Intent(this, FeedListActivity.class));
                break;
            default:
                break;
        }
    }
}
