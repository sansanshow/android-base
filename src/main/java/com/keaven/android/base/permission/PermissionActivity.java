package com.keaven.android.base.permission;

import android.app.Activity;

/**
 * Created by a-keaven on 2016/11/3.
 */
public class PermissionActivity extends Activity{
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
