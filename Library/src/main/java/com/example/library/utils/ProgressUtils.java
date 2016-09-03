package com.example.library.utils;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.example.library.R;

/**
 * 作者：Xzuing
 * 邮箱：Xzuing@Gmail.com
 * 时间：2016/8/31 15:23
 * 此类作用：
 */

public class ProgressUtils {
    private final Context mContext;
    private final Dialog mProgressDialog;

    /**
     * 构造方法
     * @param context
     */
    public ProgressUtils(Context context) {
        mContext = context;
        mProgressDialog = new Dialog(mContext, R.style.Progress_Dialog);
        mProgressDialog.setContentView(R.layout.progress_dialog);
        mProgressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

    }

    /**
     * 默认显示正在加载中
     */
    public void showProgress() {
        TextView msgs = (TextView) mProgressDialog.findViewById(R.id.id_tv_loadingmsg);
        msgs.setText("正在加载中");
        mProgressDialog.show();
    }

    /**
     *  显示进度条
     * @param msg 文字
     */
    public void showProgress(String msg) {
        TextView msgs = (TextView) mProgressDialog.findViewById(R.id.id_tv_loadingmsg);
        msgs.setText(msg);
        mProgressDialog.show();
    }

    /***
     * 显示进度条
     *
     * @param flag 点击外面是否可取消
     * @param msg  提示信息
     */
    public void showProgress(boolean flag, String msg) {
        TextView msgs = (TextView) mProgressDialog.findViewById(R.id.id_tv_loadingmsg);
        msgs.setText(msg);
        mProgressDialog.setCanceledOnTouchOutside(flag);
        mProgressDialog.setCancelable(flag);
        mProgressDialog.show();
    }

    /**
     * 关闭进度条
     */
    public void dismissProgress() {
        mProgressDialog.dismiss();
    }
}
