package com.keaven.android.base.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.keaven.android.base.BaseActivity;
import com.keaven.android.base.MainActivity;
import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/12/13.
 */
public class NotificationActivity extends BaseActivity implements View.OnClickListener{
    Button mBtndefault;
    Button mBtncustom;
    Button mBtnbackground;
    int number = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        // 获取
        mBtndefault = (Button) findViewById(R.id.btn_default);
        mBtncustom = (Button) findViewById(R.id.btn_custom);
        mBtnbackground = (Button) findViewById(R.id.btn_background);

        // 设置点击事件
        mBtndefault.setOnClickListener(this);
        mBtncustom.setOnClickListener(this);
        mBtnbackground.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_default:
                defaultNotification();
                break;
            case R.id.btn_custom:
                break;
            case R.id.btn_background:
                break;
            default:
                break;
        }
    }
    private void defaultNotification(){
        // 第一步：获取状态通知栏管理
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // 第二步：实例化通知栏构造器NotificationCompat.Builder
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        // 第三步：对Builder进行配置
        mBuilder.setContentTitle("默认测试标题")//设置通知栏标题
                .setContentText("默认测试内容") //设置通知栏显示内容
                .setProgress(100,69,true)
                .setContentIntent(getDefalutIntent(Notification.FLAG_AUTO_CANCEL)) //设置通知栏点击意图
//                .setNumber(number) //设置通知集合的数量
                .setTicker("默认测试通知来啦") //通知首次出现在通知栏，带上升动画效果的
                .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                .setPriority(Notification.PRIORITY_DEFAULT) //设置该通知优先级
//                .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                .setOngoing(false)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                .setDefaults(Notification.DEFAULT_VIBRATE)//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合
                //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND 添加声音 // requires VIBRATE permission
                .setSmallIcon(R.drawable.ic_launcher);//设置通知小ICON

        // 第五步：
        mNotificationManager.notify(444, mBuilder.build());
    }
    public PendingIntent getDefalutIntent(int flags){
        PendingIntent pendingIntent= PendingIntent.getActivity(this, 1, new Intent(this, MainActivity.class), flags);
        return pendingIntent;
    }
}
