package com.keaven.android.base.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/12/16.
 */
public class OperateDialog extends Dialog implements View.OnClickListener{
    private Button mBtn1,mBtn2,mBtn3;
    private OperateDialog listener;
    public OperateDialog(Context context) {
        super(context);
    }

    public OperateDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        initViews();
    }
    private void initViews(){
        mBtn1 = (Button) findViewById(R.id.btn_1);
        mBtn2 = (Button) findViewById(R.id.btn_2);
        mBtn3 = (Button) findViewById(R.id.btn_3);
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        listener.onClick(v);
    }

}
