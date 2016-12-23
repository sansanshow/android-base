package com.keaven.android.base.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.ArrayRes;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.keaven.android.base.BaseActivity;
import com.keaven.android.base.R;
import com.keaven.android.base.databinding.ActivityDatabindingListBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by a-keaven on 2016/12/22.
 */
public class ListActivity extends BaseActivity {
    ActivityDatabindingListBinding binding;
    EmployeeAdapter mEmployeeAdapter;
    Random random = new Random(System.currentTimeMillis());
    public class Presenter {
        public void OnClickAddItem(View view) {

            int index= random.nextInt(1000);
            mEmployeeAdapter.add(new User(getRandomString(8),getRandomString(8),index%2==0));
        }

        public void OnClickRemoveItem(View view) {
            mEmployeeAdapter.remove();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding_list);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.setPresenter(new Presenter());
        mEmployeeAdapter = new EmployeeAdapter(this);
        binding.recyclerView.setAdapter(mEmployeeAdapter);
        mEmployeeAdapter.setListener(new EmployeeAdapter.OnItemClickListener() {
            @Override
            public void OnEmployeeClick(User employee) {
                Toast.makeText(ListActivity.this, employee.getFirstName(), Toast.LENGTH_LONG).show();
            }
        });
        List<User> users=new ArrayList<User>();
        for (int i = 0; i < 6; i++) {
            int index= random.nextInt(1000);
            users.add(new User(getRandomString(8),getRandomString(8),index%2==0));
        }
        mEmployeeAdapter.addAll(users);
    }
    public String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
