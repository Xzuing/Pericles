package com.sample.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.sample.R;

/**
 * 作者：Xzuing
 * 邮箱：Xzuing@Gmail.com
 * 时间：2016/8/23 16:43
 * 此类作用：下拉刷新，上拉加载的封装
 */
public class MyRecyclerView extends LinearLayout {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefresh;


    public MyRecyclerView(Context context) {
        super(context);
        initView();
    }


    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();

    }

    /**
     * 初始化控件
     */
    private void initView() {
        View view = View.inflate(getContext(), R.layout.pull_load_layout, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefresh.setColorSchemeResources(android.R.color.holo_blue_dark);
        addView(view);
    }

    /**
     * 下拉刷新上拉加载
     *
     * @param loadMore
     */
    public void setOnPullLoadMoreListener(final PullLoadMore loadMore) {
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadMore.onRefresh();
                    }
                }, 1000);
            }
        });
    }

    /**
     * 设置进度条颜色
     *
     * @param colorResIds
     */
    public void setColorSchemeResources(@ColorRes int... colorResIds) {
        mSwipeRefresh.setColorSchemeResources(colorResIds);
    }

    /**
     * 是否可下拉刷新
     *
     * @param enable
     */
    public void setSwipeRefreshEnable(boolean enable) {
        mSwipeRefresh.setEnabled(enable);
    }

    /**
     * 是否关闭下拉刷新
     *
     * @param refreshing
     */
    public void setRefreshing(boolean refreshing) {
        mSwipeRefresh.setRefreshing(refreshing);
    }

    /**
     * 自动下拉刷新
     *
     * @param loadMore
     */
    public void setPost(final PullLoadMore loadMore) {
        mSwipeRefresh.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefresh.setRefreshing(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadMore.onRefresh();
                    }
                }, 1500);
            }
        });
    }

    /**
     * 下拉刷新,上拉加载的接口回调
     */
    public interface PullLoadMore {
        void onRefresh();

    }
}
