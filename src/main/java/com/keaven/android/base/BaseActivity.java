package com.keaven.android.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by a-keaven on 2016/12/13.
 */
public class BaseActivity extends Activity {
    public Context mAct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAct=this;
    }
}
