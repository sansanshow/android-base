package com.keaven.android.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.keaven.android.base.broadcast.BroadCastActivity;
import com.keaven.android.base.contentprovider.ProviderActivity;
import com.keaven.android.base.databinding.IndexDataBindingActivity;
import com.keaven.android.base.drawable.DrawableActivity;
import com.keaven.android.base.jni.JniActivity;
import com.keaven.android.base.mediarecoder.MediaRecordActivity;
import com.keaven.android.base.notification.NotificationActivity;
import com.keaven.android.base.recyclerview.FeedListActivity;
import com.keaven.android.base.recyclerview.RecyclerViewDemoActivity;
import com.keaven.android.base.service.ServiceActivity;
import com.keaven.android.base.view.CustomViewActivity;
import com.keaven.android.base.volley.VolleyActivity;
import com.keaven.android.base.webview.jsbridge.JSBridgeActivity;
import com.keaven.android.base.webview.WebViewActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button mBtndrawable;
    private Button mBtnwebview;
    private Button mBtnjsbridge;
    private Button mBtnmediarRecord;
    private Button mBtnVolley;
    private Button mBtnJni;
    private Button mBtnBroadCast;
    private Button mBtnProvider;
    private Button mBtnnotification;
    private Button mBtnservice;
    private Button mBtncustomview;
    private Button mBtndatabinding;
    private Button mBtnrecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (BuildConfig.DEBUG) {

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mBtndrawable = (Button) findViewById(R.id.btn_drawable);
        mBtnwebview = (Button) findViewById(R.id.btn_webview);
        mBtnjsbridge = (Button) findViewById(R.id.btn_jsbridge);
        mBtnmediarRecord = (Button) findViewById(R.id.btn_mediarecord);
        mBtnVolley = (Button) findViewById(R.id.btn_volley);
        mBtnJni = (Button) findViewById(R.id.btn_jni);
        mBtnBroadCast = (Button) findViewById(R.id.btn_broadcast);
        mBtnProvider = (Button) findViewById(R.id.btn_provider);
        mBtnnotification = (Button) findViewById(R.id.btn_notification);
        mBtnservice = (Button) findViewById(R.id.btn_service);
        mBtncustomview = (Button) findViewById(R.id.btn_custom_view);
        mBtndatabinding = (Button) findViewById(R.id.btn_databinding);
        mBtnrecyclerView = (Button) findViewById(R.id.btn_recyclerview);


        mBtndrawable.setOnClickListener(this);
        mBtnwebview.setOnClickListener(this);
        mBtnjsbridge.setOnClickListener(this);
        mBtnmediarRecord.setOnClickListener(this);
        mBtnVolley.setOnClickListener(this);
        mBtnJni.setOnClickListener(this);
        mBtnBroadCast.setOnClickListener(this);
        mBtnProvider.setOnClickListener(this);
        mBtnnotification.setOnClickListener(this);
        mBtnservice.setOnClickListener(this);
        mBtncustomview.setOnClickListener(this);
        mBtndatabinding.setOnClickListener(this);
        mBtnrecyclerView.setOnClickListener(this);
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
            case R.id.btn_mediarecord://
                startActivity(new Intent(this, MediaRecordActivity.class));
                break;
            case R.id.btn_volley://
                startActivity(new Intent(this, VolleyActivity.class));
                break;
            case R.id.btn_jni://
                startActivity(new Intent(this, JniActivity.class));
                break;
            case R.id.btn_broadcast://btn_broadcast
                startActivity(new Intent(this, BroadCastActivity.class));
                break;
            case R.id.btn_provider://btn_provider
                startActivity(new Intent(this, ProviderActivity.class));
                break;
            case R.id.btn_notification://btn_notification
                startActivity(new Intent(this, NotificationActivity.class));
                break;
            case R.id.btn_service://btn_notification
                startActivity(new Intent(this, ServiceActivity.class));
                break;
            case R.id.btn_custom_view://btn_notification
                startActivity(new Intent(this, CustomViewActivity.class));
                break;
            case R.id.btn_databinding://btn_notification
                startActivity(new Intent(this, IndexDataBindingActivity.class));
                break;
            case R.id.btn_recyclerview://btn_recyclerview
                startActivity(new Intent(this, RecyclerViewDemoActivity.class));
                break;
            default:
                break;
        }
    }

}
