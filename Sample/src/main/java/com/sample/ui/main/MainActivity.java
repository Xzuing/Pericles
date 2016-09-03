package com.sample.ui.main;

import android.os.Bundle;

import android.widget.TextView;

import com.example.library.base.BaseActivity;


import com.sample.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：Xzuing
 * 邮箱：Xzuing@Gmail.com
 * 时间：2016/8/26 10:54
 * 此类作用：主界面
 */
public class MainActivity extends BaseActivity {

    @Bind(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //new DialogUtils(getContext()).builder().setTitle("hhhh1").setMsg("sadadsasdadsasa").setCancelable(false).setNegativeButton("取消", v -> System.out.println("取消")).setPositiveButton("确定", v -> System.out.println("取消"));
    }
}
