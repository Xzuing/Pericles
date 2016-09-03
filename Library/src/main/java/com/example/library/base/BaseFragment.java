package com.example.library.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * 作者：Xzuing
 * 邮箱：Xzuing@Gmail.com
 * 时间： 2016/7/23 12:51
 * 此类作用：Fragment基类
 */
public abstract class BaseFragment extends Fragment {


    protected Activity mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        ButterKnife.bind(this, getLayoutId());
        return getLayoutId();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract View getLayoutId();

    /**
     * 初始化方法
     */
    public abstract void initDate();

    /**
     * 销毁时调用
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        //提醒虚拟机来回收
        System.gc();
    }

}
