# Android开发中通用工具类封装
>#BaseActivity

设置标题：`setTitle()`

弹出土司：`showToast()`

显示进度条：`showProgress()`

隐藏进度条：`dismissProgress()`

隐藏标题：`setTilelayoutGone()`

>#BaseFragment

暂无

>#MyRecyclerView

上拉刷新下拉加载：RecyclerView + SwipeRefreshLayout

设置进度条颜色：`setColorSchemeResources()`

界面可见自动下拉刷新：`setPost()`

是否关闭下拉刷新：`setRefreshing()`

是否可下拉刷新：`setSwipeRefreshEnable()`
	
下拉刷新上拉加载：`setOnPullLoadMoreListener()`

>#RefreshListView

为了考虑到特殊情况不能使用MyRecyclerView，增加了ListView上拉加载简单封装

ListView的上拉加载封装，需要下拉刷新的话可用SwipeRefreshLayout嵌套RefreshListView，既可实现上拉刷新下拉加载

>#DialogUtils——对话框
#
>#ProgressUtils——进度条
