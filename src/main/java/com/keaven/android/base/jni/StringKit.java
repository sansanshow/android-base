package com.keaven.android.base.jni;

/**
 * Created by a-keaven on 2016/11/22.
 */
public class StringKit {
    public static native void setNull(String str);
    static {
        System.loadLibrary("jnibase");
    }
}
