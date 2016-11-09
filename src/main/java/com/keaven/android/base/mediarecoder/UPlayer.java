package com.keaven.android.base.mediarecoder;

import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by a-keaven on 2016/11/9.
 */
public class UPlayer implements IVoiceManager {
    private final String TAG = UPlayer.class.getName();
    private String path;

    private MediaPlayer mPlayer;
    public UPlayer(String path){
        this.path = path;
        mPlayer = new MediaPlayer();
    }

    @Override
    public boolean start() {
        try {
            //设置要播放的文件
            mPlayer.setDataSource(path);
            mPlayer.prepare();
            //播放
            mPlayer.start();
        }catch(Exception e){
            Log.e(TAG, "prepare() failed");
        }

        return false;
    }

    @Override
    public boolean stop() {
        mPlayer.stop();
        mPlayer.release();
        mPlayer = null;
        return false;
    }

}
