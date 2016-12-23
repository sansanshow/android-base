package com.keaven.android.base.webview.jsbridge;

import android.os.Environment;
import android.webkit.WebView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by a-keaven on 2016/11/10.
 */
public class BridgeImpl implements IBridge {
    public static void showToast(WebView webView, JSONObject param, final Callback callback) {
        System.out.println("-------22222222--------");
        String message = param.optString("msg");
        Toast.makeText(webView.getContext(), message, Toast.LENGTH_SHORT).show();
        if (null != callback) {
            try {
                JSONObject object = new JSONObject();
                object.put("method", "showToast");
                object.put("key1", "value1");
                callback.apply(getJSONObject(0, "ok", object));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void testThread(WebView webView, JSONObject param, final Callback callback) {
        System.out.println("-------3333333--------");
        String message = param.optString("msg");
        Toast.makeText(webView.getContext(), message, Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    JSONObject object = new JSONObject();
                    object.put("method", "testThread");
                    callback.apply(getJSONObject(0, "ok", object));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private static JSONObject getJSONObject(int code, String msg, JSONObject result) {
        JSONObject object = new JSONObject();
        try {
            object.put("code", code);
            object.put("msg", msg);
            object.putOpt("result", result);
            return object;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void recordVoice(WebView webView, JSONObject param, final Callback callback) {
        System.out.println("-------22222222--------");
        String message = param.optString("msg");
        Toast.makeText(webView.getContext(), message, Toast.LENGTH_SHORT).show();
        if (null != callback) {
            try {
                JSONObject object = new JSONObject();
                object.put("key", "value");
                object.put("key1", "value1");
                callback.apply(getJSONObject(0, "ok", object));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] getVoice(String filePath){
        File file = new File(filePath);
        FileInputStream in = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            in = new FileInputStream(file);
            byte[] buffer = new byte[in.available()];
            System.out.println("---before----"+buffer.toString()+"...."+buffer.length);
            in.read(buffer);
            out.write(buffer);
            System.out.println("---after----"+buffer.toString()+"...."+buffer.length);
            return buffer;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}
