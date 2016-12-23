package com.keaven.android.base.webview.jsbridge;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;

import org.json.JSONObject;

import java.lang.ref.WeakReference;

/**
 * Created by a-keaven on 2016/11/10.
 */
public class Callback {
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static final String CALLBACK_JS_FORMAT = "javascript:JSBridge.onFinish('%s', %s);";
    private String mPort;
    private WeakReference<WebView> mWebViewRef;

    public Callback(WebView view, String port) {
        mWebViewRef = new WeakReference<>(view);
        mPort = port;
    }


    public void apply(JSONObject jsonObject) {
        final String execJs = String.format(CALLBACK_JS_FORMAT, mPort, String.valueOf(jsonObject));
//        final String  path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/ione.pcm";
        if (mWebViewRef != null && mWebViewRef.get() != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mWebViewRef.get().loadUrl(execJs);
//                    mWebViewRef.get().postUrl(execJs,BridgeImpl.getVoice(path));
                }
            });

        }

    }
}
