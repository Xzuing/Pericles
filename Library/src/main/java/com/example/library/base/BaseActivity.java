package com.example.library.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.library.R;
import com.example.library.utils.ProgressUtils;

import butterknife.ButterKnife;


/**
 * 作者：Xzuing
 * 邮箱：Xzuing@Gmail.com
 * 时间： 2016/7/23 12:51
 * 此类作用：Activity的基类
 */
public class BaseActivity extends AppCompatActivity {

    private LinearLayout mParentLayout;
    private TextView mTvtitle;
    protected LinearLayout mLlback;
    private LinearLayout mLlTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView(R.layout.activity_base);  //初始化布局
        mTvtitle = (TextView) findViewById(R.id.mTvtitle);//标题文字
        //mLlTitle = (LinearLayout) findViewById(R.id.mLlTitle);//标题布局
        mLlback = (LinearLayout) findViewById(R.id.mLlback);//返回键
        // 沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        mLlback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    /**
     * 初始化contentview
     */
    private void initContentView(int layoutResID) {
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        mParentLayout = new LinearLayout(this);
        mParentLayout.setOrientation(LinearLayout.VERTICAL);
        viewGroup.addView(mParentLayout);
        LayoutInflater.from(this).inflate(layoutResID, mParentLayout, true);
    }

    @Override
    public void setContentView(int layoutResID) {
        LayoutInflater.from(this).inflate(layoutResID, mParentLayout, true);
    }

    @Override
    public void setContentView(View view) {
        ButterKnife.bind(view);
        mParentLayout.addView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        ButterKnife.bind(view);
        mParentLayout.addView(view, params);

    }

    /**
     * 设置标题
     *
     * @param titel
     */
    public void setTitle(String titel) {
        mTvtitle.setText(titel);
    }

    /**
     * 获取上下文对象
     *
     * @return Context
     */
    public Context getContext() {
        return this;
    }

    /**
     * 弹出土司
     *
     * @param msg 提示信息-文字
     */
    public void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹出土司
     *
     * @param resId 提示信息-数字
     */
    public void showToast(int resId) {
        Toast.makeText(getContext(), resId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示进度条
     *
     * @param msg 加载的文字
     */
    public void showProgress(String msg) {
        new ProgressUtils(getContext()).showProgress(msg);
    }

    /***
     * 显示进度条
     *
     * @param flag 点击外面是否可取消
     * @param msg  提示信息
     */
    public void showProgress(boolean flag, String msg) {
        new ProgressUtils(getContext()).showProgress(flag, msg);
    }

    /**
     * 显示进度条
     */
    public void showProgress() {
        new ProgressUtils(getContext()).showProgress();
    }

    /**
     * 隐藏进度条
     */
    public void dismissProgress() {
        new ProgressUtils(getContext()).dismissProgress();
    }

    /**
     * 隐藏标题
     */
    public void setTilelayoutGone() {
        mLlTitle.setVisibility(View.GONE);
    }
}
