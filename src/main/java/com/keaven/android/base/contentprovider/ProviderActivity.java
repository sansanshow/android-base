package com.keaven.android.base.contentprovider;

import android.app.Activity;
import android.os.Bundle;

import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/12/12.
 */
public class ProviderActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provicer);
    }
}
