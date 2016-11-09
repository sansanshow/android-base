package com.keaven.android.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.keaven.android.base.drawable.DrawableActivity;
import com.keaven.android.base.mediarecoder.MediaRecordActivity;
import com.keaven.android.base.webview.JSBridgeActivity;
import com.keaven.android.base.webview.WebViewActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button mBtndrawable;
    private Button mBtnwebview;
    private Button mBtnjsbridge;
    private Button mBtnmediarRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mBtndrawable = (Button) findViewById(R.id.btn_drawable);
        mBtnwebview = (Button) findViewById(R.id.btn_webview);
        mBtnjsbridge = (Button) findViewById(R.id.btn_jsbridge);
        mBtnmediarRecord = (Button) findViewById(R.id.btn_mediarecord);

        mBtndrawable.setOnClickListener(this);
        mBtnwebview.setOnClickListener(this);
        mBtnjsbridge.setOnClickListener(this);
        mBtnmediarRecord.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_drawable://Drawable
                startActivity(new Intent(this, DrawableActivity.class));
                break;
            case R.id.btn_webview://webView
                startActivity(new Intent(this, WebViewActivity.class));
                break;
            case R.id.btn_jsbridge://webView
                startActivity(new Intent(this, JSBridgeActivity.class));
                break;
            case R.id.btn_mediarecord://webView
                startActivity(new Intent(this, MediaRecordActivity.class));
                break;
            default:
                break;
        }
    }

}
