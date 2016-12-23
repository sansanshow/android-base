package com.keaven.android.base.databinding;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableChar;
import android.databinding.ObservableField;

/**
 * Created by a-keaven on 2016/12/22.
 * 观察者模式：Observable
 * ObservableFields 家族
 * ObservableField，
 * ObservableBoolean,
 * ObservableByte,
 * ObservableChar,
 * ObservableShort,
 * ObservableInt,
 * ObservableLong,
 * ObservableFloat,
 * ObservableDouble,
 * ObservableParcelable
 */
public class Employee {
    public ObservableField<String> name = new ObservableField<String>();
    public ObservableBoolean fired = new ObservableBoolean();
}
