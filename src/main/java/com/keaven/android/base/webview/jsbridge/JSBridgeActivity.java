package com.keaven.android.base.webview.jsbridge;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/11/9.
 */
public class JSBridgeActivity extends Activity{
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsbridge);
        mWebView = (WebView) findViewById(R.id.wb_jsbridge);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new JSBridgeWebChromeClient());
        mWebView.loadUrl("file:///android_asset/index.html");
        JSBridge.register("bridge", BridgeImpl.class);
    }
}
