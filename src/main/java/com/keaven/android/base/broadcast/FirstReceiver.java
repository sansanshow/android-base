package com.keaven.android.base.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by a-keaven on 2016/12/12.
 */
public class FirstReceiver extends BroadcastReceiver {
    private static final String TAG = "NormalBroadcast";
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Log.i(TAG, "FirstReceiver: " + msg);

        Bundle bundle = new Bundle();
        bundle.putString("msg", msg + "@FirstReceiver");
        setResultExtras(bundle);
    }
}
