package com.jiacheng.family.ui.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.jiacheng.family.R;
import com.jiacheng.family.base.BaseFragment;
import com.jiacheng.family.ui.adapter.HomeLeftAdapter;
import com.jiacheng.family.ui.entity.HomeLeftBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：liujiacheng
 * 日期：2017/12/15 15:35
 * 描述：
 */

public class HomeLeftFragment extends BaseFragment {
    private static final String TAG = HomeLeftFragment.class.getSimpleName();
    public static final String INTENT_STRING_TABNAME = "intent_String_tabName";
    public static final String INTENT_INT_POSITION = "intent_int_position";
    private static final int PAGE_SIZE = 6;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private HomeLeftAdapter homeLeftAdapter;
    private int mNextRequestPage = 1;
    private String tabName;
    private int position;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        tabName = getArguments().getString(INTENT_STRING_TABNAME);
        position = getArguments().getInt(INTENT_INT_POSITION);
        setContentView(R.layout.fragment_home_left);
        initView();
        initAdapter();
        initRefreshLayout();
        mSwipeRefreshLayout.setRefreshing(true);
//        refresh();
        mNextRequestPage = 1;
//        homeLeftAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
//        initData(false);
        initData(true);
        homeLeftAdapter.setEnableLoadMore(true);
        mSwipeRefreshLayout.setRefreshing(false);
    }
    private void initView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

    }
    private void initAdapter() {
        homeLeftAdapter = new HomeLeftAdapter();
        homeLeftAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
//                loadMore();
                initData(false);
                homeLeftAdapter.loadMoreComplete();
            }
        },mRecyclerView);
//        homeLeftAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
//        mAdapter.setPreLoadNumber(3);
        mRecyclerView.setAdapter(homeLeftAdapter);

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
                Toast.makeText(mActivity, Integer.toString(position), Toast.LENGTH_LONG).show();
            }
        });
    }
    private void initRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                refresh();
                initData(false);
                homeLeftAdapter.setEnableLoadMore(true);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    private void initData(boolean isRefresh){
        List<HomeLeftBean> homeLeftBeanList = new ArrayList<>();
        HomeLeftBean homeLeftBean;
        for (int i=0;i<20;i++){
            homeLeftBean = new HomeLeftBean();
//            homeLeftBean.set
            homeLeftBeanList.add(homeLeftBean);
        }
        if (isRefresh){
            homeLeftAdapter.setNewData(homeLeftBeanList);
        }else {
            homeLeftAdapter.addData(homeLeftBeanList);
        }
    }
    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();

    }

}
