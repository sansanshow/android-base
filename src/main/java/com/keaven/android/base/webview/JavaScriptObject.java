package com.keaven.android.base.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import com.keaven.android.base.mediarecoder.UPlayer;
import com.keaven.android.base.mediarecoder.URecorder;

/**
 * Created by a-keaven on 2016/11/9.
 */
public class JavaScriptObject {
    URecorder recorder;
    UPlayer player;
    String path;
    Context mContxt;
    WebView mWebView;
//    @JavascriptInterface //sdk17版本以上加上注解
    public JavaScriptObject(Context mContxt ,WebView webView) {
        this.mContxt = mContxt;
        this.mWebView = webView;
        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        path += "/ione.pcm";
        this.recorder = new URecorder(path);
        this.player = new UPlayer(path);
    }
    @JavascriptInterface
    public void fun1FromAndroid(String name) {
        Toast.makeText(mContxt, name, Toast.LENGTH_LONG).show();
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //通过返回requestCode来写
        mContxt.startActivity(camera);
        log("调用相机成功");
    }
    @JavascriptInterface
    public void fun2(String name) {
        Toast.makeText(mContxt, "调用fun2:" + name, Toast.LENGTH_SHORT).show();
    }

    public void log(final String msg){
        mWebView.post(new Runnable() {
            @Override
            public void run() {
                mWebView.loadUrl("javascript: log(" + "'" + msg + "'" + ")");
            }
        });
    }

    /**
     * 开始录音
     */
    @JavascriptInterface
    public void startRecord(String msg){
        System.out.println("---startRecord--录音--");
        log(msg);
        recorder.start();
    }
    /**
     * 结束录音
     */
    @JavascriptInterface
    public void stopRecord(String msg){
        System.out.println("---stopRecord--结束录音--");
        log(msg);
        player.start();
    }
    /**
     * 播放录音
     */
    @JavascriptInterface
    public void startPlay(String msg){
        System.out.println("---startPlay--播放--");
        log(msg);
        player.start();
    }
    /**
     * 结束播放
     */
    @JavascriptInterface
    public void stopPlay(String msg){
        System.out.println("---stopPlay--停止播放--");
        log(msg);
        player.stop();
    }
}
