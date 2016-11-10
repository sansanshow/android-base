package com.keaven.android.base.webview;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * 自定义WebChromeClient
 * Created by a-keaven on 2016/11/9.

public class InjectedChromeClient extends WebChromeClient {
    JsCallJava mJsCallJava;
    public InjectedChromeClient() {
        this.mJsCallJava = new JsCallJava();
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        result.confirm(mJsCallJava.call(view,message));
        return true;
    }
}*/
