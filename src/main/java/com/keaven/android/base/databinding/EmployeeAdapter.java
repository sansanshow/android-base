package com.keaven.android.base.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.keaven.android.base.BR;
import com.keaven.android.base.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by a-keaven on 2016/12/22.
 */
public class EmployeeAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private final int ON = 1;
    private final int OFF = 2;
    private final LayoutInflater mLayoutInflater;
    private OnItemClickListener mListener;
    private List<User> mEmployeeLists;

    public EmployeeAdapter(Context context) {
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mEmployeeLists = new ArrayList<User>();
    }

    public interface OnItemClickListener {
        void OnEmployeeClick(User employee);
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if (viewType == ON) {
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_employee, parent, false);
        } else {
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_employee_off, parent, false);
        }
        return new BindingViewHolder(binding);
    }

    @Override
    public int getItemViewType(int position) {
        User employee = mEmployeeLists.get(position);
        if (employee.isFired()){
            return OFF;
        } else {
            return ON;
        }
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        final User employee = mEmployeeLists.get(position);
        holder.getBinding().setVariable(BR.item, employee);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.OnEmployeeClick(employee);
            }
        });

    }

    public void setListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public int getItemCount() {
        return mEmployeeLists.size();
    }

    Random random = new Random(System.currentTimeMillis());

    public void addAll(List<User> employees) {
        mEmployeeLists.addAll(employees);
    }

    public void add(User employee) {
        int position = random.nextInt(mEmployeeLists.size() + 1);
        mEmployeeLists.add(position, employee);
        notifyItemInserted(mEmployeeLists.size());

    }

    public void remove() {
        if (mEmployeeLists.size() == 0)
            return;
        int position = random.nextInt(mEmployeeLists.size());
        mEmployeeLists.remove(position);
        notifyItemRemoved(position);
    }
}
