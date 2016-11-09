package com.keaven.android.base.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.keaven.android.base.R;

/**
 * 1:WebView
 * Created by a-keaven on 2016/11/9.
 */
public class WebViewActivity extends Activity {
    private WebView webView;
    private Button mBtnJs;
    private Context mContext;

    @SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        //初始化
        initViews();
        //设置编码
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        //支持js
        webView.getSettings().setJavaScriptEnabled(true);
        //设置背景颜色透明
//        webView.setBackgroundColor(Color.rgb(0, 0, 0));
        //设置本地调用对象及其接口
        webView.addJavascriptInterface(new JavaScriptObject(mContext,webView), "myObj");
        //载入js
        webView.loadUrl("file:///android_asset/webview.html");
        mBtnJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:funFromjs()");
                Toast.makeText(mContext, "调用javascript:funFromjs()", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initViews() {
        mContext = this;
        webView = (WebView) findViewById(R.id.webview);
        mBtnJs = (Button) findViewById(R.id.btn_doJs);
    }
}
