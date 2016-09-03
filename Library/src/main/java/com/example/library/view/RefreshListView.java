package com.example.library.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;


import com.example.library.R;


/**
 * 作者：Xzuing
 * 邮箱：Xzuing@Gmail.com
 * 时间：2016/7/24 16:07
 * 此类作用：ListView上拉加载的封装，没有下拉刷新，可用SwipeRefreshLayout下拉刷新包起来
 */
public class RefreshListView extends ListView {
    private OnRefreshListener mListener;
    private View footer;
    private int footerHeight;

    public RefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inintFooter();
    }

    private void inintFooter() {
        footer = View.inflate(getContext(), R.layout.refresh_footer, null);
        // 隐藏脚布局
        footer.measure(0, 0);
        footerHeight = footer.getMeasuredHeight();
        footer.setPadding(0, -footerHeight, 0, 0);
        this.addFooterView(footer);
        // 监听Listview滚动事件
        this.setOnScrollListener(new MyOnScrollListener());
    }


    /**
     * 恢复加载更多状态
     */
    public void loadMoreFinished() {
        footer.setPadding(0, -footerHeight, 0, 0);
        isLoadMore = false;
    }

    /**
     * 对外提供接口
     */
    public interface OnRefreshListener {
        void onLoadingMore();
    }

    /**
     * 提供设置监听的方法
      * @param listener
     */
    public void setOnRefreshListener(OnRefreshListener listener) {
        this.mListener = listener;
    }

    boolean isLoadMore = false;// 是否处于加载更多

    class MyOnScrollListener implements OnScrollListener {

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            // 且当前展示的最后一条是Adapter中的最后一条
            if (getLastVisiblePosition() == getAdapter().getCount() - 1 && !isLoadMore) {
                isLoadMore = true;
                // 让脚布局自动显示
                setSelection(getAdapter().getCount());
                footer.setPadding(0, 0, 0, 0);
                if (mListener != null) {
                    mListener.onLoadingMore();

                }
            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }

    }
}
