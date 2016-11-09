package com.keaven.android.base.mediarecoder;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/11/9.
 */
public class MediaRecordActivity extends Activity implements View.OnClickListener{
    private String path = null;
    private URecorder recorder;
    private UPlayer player;
    private Button mBtnstartRecord;
    private Button mBtnstopRecord;
    private Button mBtnstartPlay;
    private Button mBtnstopPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_record);
        //init view
        mBtnstartRecord = (Button) findViewById(R.id.btn_startRecord);
        mBtnstopRecord = (Button) findViewById(R.id.btn_stopRecord);
        mBtnstartPlay = (Button) findViewById(R.id.btn_startPlay);
        mBtnstopPlay = (Button) findViewById(R.id.btn_stopPlay);
        //init events
        mBtnstartRecord.setOnClickListener(this);
        mBtnstopRecord.setOnClickListener(this);
        mBtnstartPlay.setOnClickListener(this);
        mBtnstopPlay.setOnClickListener(this);

        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        path += "/ione.pcm";

        recorder = new URecorder(path);
        player = new UPlayer(path);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_startRecord:
                Toast.makeText(this, "start record", Toast.LENGTH_SHORT).show();
                recorder.start();
                break;
            case R.id.btn_stopRecord:
                Toast.makeText(this, "start record", Toast.LENGTH_SHORT).show();
                recorder.stop();
                break;
            case R.id.btn_startPlay:
                Toast.makeText(this, "start record", Toast.LENGTH_SHORT).show();
                player.start();
                break;
            case R.id.btn_stopPlay:
                Toast.makeText(this, "start record", Toast.LENGTH_SHORT).show();
                player.stop();
                break;
            default:
                break;
        }
    }
}
