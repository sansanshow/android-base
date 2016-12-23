package com.keaven.android.base;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.keaven.android.base.volley.util.LruBitmapCache;
import com.taobao.hotfix.HotFixManager;
import com.taobao.hotfix.PatchLoadStatusListener;
import com.taobao.hotfix.util.PatchStatusCode;

/**
 * Created by a-keaven on 2016/12/16.
 */
public class BaseApplication extends Application {
    public static final String TAG = BaseApplication.class.getSimpleName();

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static BaseApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
//        String appId = "82549-1";
//        HotFixManager.getInstance().setContext(this)
//                .setAppVersion("1.0.0.1")
//                .setAppId(appId)
//                .setAesKey(null)
//                .setSupportHotpatch(true)
//                .setEnableDebug(true)
//                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
//                    @Override
//                    public void onload(final int mode, final int code, final String info, final int handlePatchVersion) {
//                        // 补丁加载回调通知
//                        if (code == PatchStatusCode.CODE_SUCCESS_LOAD) {
//                            // TODO: 10/24/16 表明补丁加载成功
//                        } else if (code == PatchStatusCode.CODE_ERROR_NEEDRESTART) {
//                            // TODO: 10/24/16 表明新补丁生效需要重启. 业务方可自行实现逻辑, 提示用户或者强制重启, 建议: 用户可以监听进入后台事件, 然后应用自杀
//                        } else if (code == PatchStatusCode.CODE_ERROR_INNERENGINEFAIL) {
//                            // 内部引擎加载异常, 推荐此时清空本地补丁, 但是不清空本地版本号, 防止失败补丁重复加载
//                            //HotFixManager.getInstance().cleanPatches(false);
//                        } else {
//                            // TODO: 10/25/16 其它错误信息, 查看PatchStatusCode类说明
//                        }
//                        Log.i("-PatchStatusCode---",Integer.toString(code));
//                    }
//                }).initialize();
    }

    public static synchronized BaseApplication getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
