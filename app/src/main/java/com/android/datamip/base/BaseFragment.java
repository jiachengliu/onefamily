package com.android.datamip.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.shizhefei.fragment.LazyFragment;

/**
 * 作者：liujiacheng
 * 日期：2017/12/15 15:28
 * 描述：
 */

public class BaseFragment extends LazyFragment {
    protected FragmentActivity mActivity;
    protected Context mContext;
    private Fragment mFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (FragmentActivity) getActivity();
        mFragment = this;
        mContext = this.getApplicationContext();
    }
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);

    }
    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();
//        OkHttpUtils.getInstance().cancelTag(mFragment);//Activity销毁时，取消网络请求
    }
}
