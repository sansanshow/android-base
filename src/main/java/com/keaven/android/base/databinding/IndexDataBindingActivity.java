package com.keaven.android.base.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.keaven.android.base.BR;
import com.keaven.android.base.BaseActivity;
import com.keaven.android.base.R;
import com.keaven.android.base.databinding.ActivityDatabindingBinding;

/**
 * Created by a-keaven on 2016/12/22.
 */
public class IndexDataBindingActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        binding.setVariable(BR.event,new Event());
    }

    public class Event {
        public void simple(View v) {
            startActivity(new Intent(IndexDataBindingActivity.this, BindingDemoActivity.class));
        }

        public void list(View v) {
            startActivity(new Intent(IndexDataBindingActivity.this, ListActivity.class));
        }

        public void custom_property(View v) {
        }

    }

}
