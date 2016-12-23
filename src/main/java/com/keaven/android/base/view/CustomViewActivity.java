package com.keaven.android.base.view;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.keaven.android.base.BaseActivity;
import com.keaven.android.base.R;

/**
 * Created by a-keaven on 2016/12/16.
 */
public class CustomViewActivity extends BaseActivity implements View.OnClickListener {
    private View mItem;
    private View mLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view);
        mItem = findViewById(R.id.item_link);
        mLine = findViewById(R.id.custom_line);
        mItem.setOnClickListener(this);
        mLine.setOnClickListener(this);
        mItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showOperateDialog();
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_link:
                showDialog();
                break;
            case R.id.custom_line:
                startActivity(new Intent(this,LineViewActivity.class));
                break;
            default:
                break;
        }
    }

    private void showDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this).create();//创建一个AlertDialog对象
        View view = this.getLayoutInflater().inflate(R.layout.custom_dialog, null);//自定义布局
        dialog.setView(view, 0, 0, 0, 0);//把自定义的布局设置到dialog中，注意，布局设置一定要在show之前。从第二个参数分别填充内容与边框之间左、上、右、下、的像素
        dialog.show();//一定要先show出来再设置dialog的参数，不然就不会改变dialog的大小了
        int width = getWindowManager().getDefaultDisplay().getWidth();
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = width - (width / 6);//设置dialog的界面宽度
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;//设置dialog高度为包裹内容
        params.gravity = Gravity.CENTER;//设置dialog的重心
        //dialog.getWindow().setLayout(width-(width/6),  LayoutParams.WRAP_CONTENT);//用这个方法设置dialog大小也可以，但是这个方法不能设置重心之类的参数，推荐用Attributes设置
        dialog.getWindow().setAttributes(params);//最后把这个参数对象设置进去，即与dialog绑定
    }

    private void showOperateDialog() {
//    OperateDialog dialog =new OperateDialog().B
    }

}
