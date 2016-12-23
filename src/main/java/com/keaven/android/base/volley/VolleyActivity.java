package com.keaven.android.base.volley;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.keaven.android.base.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by a-keaven on 2016/11/15.
 * 418337033
 */
public class VolleyActivity extends Activity {
    private static String url = "http://m.51bi.com/getStore.do?cateid=-1&opsys=apk&convertUrlFlag=1&uid=UID&attr=1&home=1&channel=baidu";
    String uid = "418337033";
    private TextView mTvresponse;
    RequestQueue requestQueue;
    String resp = "";
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mTvresponse.setText(resp);
                    System.out.println(resp);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        requestQueue = Volley.newRequestQueue(this);//这里的this指的是Context
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url.replace("UID", uid), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                System.out.println("55555555555555555555555555");
                System.out.println(s);
                resp = s;
                mHandler.sendEmptyMessage(1);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        mTvresponse = (TextView) findViewById(R.id.tv_volly_content);
        stringRequest.setTag("string");
        // 添加到请求队列  添加StringRequest到RequestQueue对象中
        requestQueue.add(stringRequest);
    }

    public void goListVolley(View view) {
        startActivity(new Intent(this, MovieActivity.class));
    }

    /**
     * Post请求案例
     */
    private void requestPost() {
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        };
        //实例化
        StringRequest post = new StringRequest(Request.Method.POST, url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError { // 参数传递
                Map<String, String> map = new HashMap<String, String>();
                map.put("key1", "value1");
                map.put("key2", "value2");
                return map;
            }
        };
        post.setTag("post");
        // 添加到请求队列
        requestQueue.add(post);
    }

    /**
     * json请求的处理
     */
    private void jsonObjectRequest() {
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject jsonObject) {

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        jsonRequest.setTag("json");
        // 添加到请求队列
        requestQueue.add(jsonRequest);
    }
}
