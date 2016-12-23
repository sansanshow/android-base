package com.keaven.android.base.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.keaven.android.base.BR;


/**
 * Created by a-keaven on 2016/12/22.
 * 观察者模式
 * 继承类 android.databinding.BaseObservable
 */
public class Student extends BaseObservable {
    private String name;
    private int gender;

    public Student() {

    }

    public Student(String name, int gender) {
        this.gender = gender;
        this.name = name;
    }

    @Bindable
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
        notifyPropertyChanged(BR.gender);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
