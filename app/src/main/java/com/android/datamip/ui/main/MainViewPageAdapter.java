package com.android.datamip.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.datamip.R;
import com.android.datamip.ui.home.HomeMainFragment;
import com.shizhefei.fragment.LazyFragment;
import com.shizhefei.view.indicator.IndicatorViewPager;

/**
 * 作者：liujiacheng
 * 日期：2017/12/15 15:19
 * 描述：
 */

public class MainViewPageAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
    private String[] tabNames = { "首页", "发现","消息", "我"};
    private int[] tabIcons = { R.drawable.maintab_2_selector, R.drawable.maintab_3_selector,
            R.drawable.maintab_4_selector,R.drawable.maintab_5_selector};
    private LayoutInflater inflater;

    public MainViewPageAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return tabNames.length;
    }

    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = (TextView) inflater.inflate(R.layout.tab_main_bottom, container, false);
        }
        TextView textView = (TextView) convertView;
        textView.setText(tabNames[position]);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[position], 0, 0);
        return textView;
    }

    @Override
    public Fragment getFragmentForPage(int position) {
        LazyFragment fragment = null;
        if (position == 0){
            fragment = new HomeMainFragment();
            Bundle bundle = new Bundle();
            bundle.putString(HomeMainFragment.INTENT_STRING_TABNAME, tabNames[position]);
            bundle.putInt(HomeMainFragment.INTENT_INT_INDEX, position);
            fragment.setArguments(bundle);
        }else if (position==2){
            fragment = new HomeMainFragment();
            Bundle bundle = new Bundle();
            bundle.putString(HomeMainFragment.INTENT_STRING_TABNAME, tabNames[position]);
            bundle.putInt(HomeMainFragment.INTENT_INT_INDEX, position);
            fragment.setArguments(bundle);
        }else if (position==3){
            fragment = new HomeMainFragment();
            Bundle bundle = new Bundle();
            bundle.putString(HomeMainFragment.INTENT_STRING_TABNAME, tabNames[position]);
            bundle.putInt(HomeMainFragment.INTENT_INT_INDEX, position);
            fragment.setArguments(bundle);
        }else if (position==4){
            fragment = new HomeMainFragment();
            Bundle bundle = new Bundle();
//            bundle.putString(FragmentMeMain.INTENT_STRING_TABNAME, tabNames[position]);
//            bundle.putInt(FragmentMeMain.INTENT_INT_POSITION, position);
            fragment.setArguments(bundle);
        }else {
            fragment = new HomeMainFragment();
            Bundle bundle = new Bundle();
            bundle.putString(HomeMainFragment.INTENT_STRING_TABNAME, tabNames[position]);
            bundle.putInt(HomeMainFragment.INTENT_INT_INDEX, position);
            fragment.setArguments(bundle);
        }
        return fragment;
    }
}
