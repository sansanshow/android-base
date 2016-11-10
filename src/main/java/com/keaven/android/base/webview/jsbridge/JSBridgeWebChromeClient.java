package com.keaven.android.base.webview.jsbridge;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by a-keaven on 2016/11/10.
 */
public class JSBridgeWebChromeClient extends WebChromeClient {
    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        System.out.println("------1111111111---------");
        System.out.println("--onJsPrompt--message"+message);
        result.confirm(JSBridge.callJava(view,message));
        return true;
    }
}
