package com.keaven.android.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.keaven.android.base.drawable.DrawableActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button mBtndrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mBtndrawable = (Button) findViewById(R.id.btn_drawable);

        mBtndrawable.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_drawable://Drawable
                startActivity(new Intent(this, DrawableActivity.class));
                break;
            default:
                break;
        }
    }

}
