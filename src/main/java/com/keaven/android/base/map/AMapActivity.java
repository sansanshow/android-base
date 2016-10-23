package com.keaven.android.base.map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;

/**
 * 高德地图 使用
 * Created by a-keaven on 2016/10/18.
 */
public class AMapActivity extends Activity {
    //声明AMapLocationClient类对象
    private AMapLocationClient mLocationClient = null;
    //创建AMapLocationClientOption对象
    //AMapLocationClientOption对象用来设置发起定位的模式和相关参数。
    //声明AMapLocationClientOption对象
    private AMapLocationClientOption mLocationClientOption = null;
    AMapLocationListener mapLocationListener = new AMapLocationListener(){

        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
                    //可在其中解析amapLocation获取相应内容。
                } else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:" + amapLocation.getErrorCode() + ", errInfo:" + amapLocation.getErrorInfo()); }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(mapLocationListener);
        //初始化AMapLocationClientOption
        mLocationClientOption = new AMapLocationClientOption();
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationClientOption.setLocationMode(AMapLocationMode.Hight_Accuracy);
    }


    @Override
    protected void onStop() {
        super.onStop();
        mLocationClient.stopLocation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.onDestroy();
    }
}
