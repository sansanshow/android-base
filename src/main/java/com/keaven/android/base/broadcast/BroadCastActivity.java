package com.keaven.android.base.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/12/12.
 */
public class BroadCastActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
    }
    public void send(View view) {
        Intent intent = new Intent("android.intent.action.MY_BROADCAST");
        intent.putExtra("msg", "hello receiver.");
//        sendBroadcast(intent);
        sendOrderedBroadcast(intent,"com.keaven.android.base.BROADCAST");
    }
}
