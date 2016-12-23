package com.keaven.android.base.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.adapters.TextViewBindingAdapter;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;

import com.keaven.android.base.BR;
import com.keaven.android.base.BaseActivity;
import com.keaven.android.base.R;
import com.keaven.android.base.databinding.ActivityDemoBinding;

/**
 * Created by a-keaven on 2016/12/21.
 */
public class BindingDemoActivity extends BaseActivity {
    User user;
    User user2;
    Student student;
    Employee employee;
    ActivityDemoBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User("Jack", "Jhons");
        user2 = new User("Jack2222", "Jhons2222");
        student=new Student("张潇潇",0);
        employee=new Employee();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_demo);
//        binding.lastName.setText(user.getLastName());
//        binding.firstName.setText(user.getFirstName());
        //设置数据的两种方式 binding.setXXX 和 binding.setVariable(BR.modelName,data);modelName指的是xml中数据模型的名称，data指的是实例化的数据对象
        binding.setUser(user);
        binding.setOtheruser(user);
        binding.setVariable(BR.otheruser,user2);
        binding.setVariable(BR.stud,student);
//        binding.setOtheruser(user2);
//        binding.setPresenter(new Presenter());
        binding.setVariable(BR.presenter,new Presenter());
        employee=new Employee();
        binding.setEmployee(employee);
        employee.name.set("吴金吉");

        ObservableArrayList<User> list = new ObservableArrayList<>();
        list.add(new User("陈真1","jack"));
        list.add(new User("陈真2","jack"));
        list.add(new User("陈真3","jack"));
        list.add(new User("陈真4","jack"));
//        list.add("loader22!!!");
//        list.add("loader33!!!");
//        list.add("loader44!!!");
        binding.setList(list);

    }

    public class Presenter {
        /**
         * 方法绑定
         * 要严格的按照该事件的书写进行绑定
         */

        public void OnClick(View v) {
//            binding.

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            user.setFirstName(s.toString().trim());
            System.out.println("start:"+start+",before:"+before+",count:"+count);
            binding.setUser(user);
        }

        /**
         * 监听器绑定，
         */
        // 相当于传回来一个View--个人理解
        public void changeName(Editable editable){
            System.out.println("----------changeName-------------"+editable.toString());
            student.setName(editable.toString());
            employee.name.set(editable.toString());
        }
    }
}
