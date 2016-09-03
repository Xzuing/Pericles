package com.example.library.Interface;

/**
 * 作者：Xzuing
 * 邮箱：Xzuing@Gmail.com
 * 时间：2016/8/31 16:07
 * 此类作用：下拉刷新，上拉加载监听接口
 */

public interface PullLoadMore {
    /**
     * 下拉刷新
     */
    void onRefresh();
    /**
     * 上拉加载
     */
    void onLoadingMore();
}
