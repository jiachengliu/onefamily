package com.android.datamip.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.datamip.R;
import com.shizhefei.fragment.LazyFragment;
import com.shizhefei.view.indicator.IndicatorViewPager;

/**
 * 作者：liujiacheng
 * 日期：2018/1/3 14:44
 * 描述：
 */

public class HomeMainAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
    private String[] tabNames = {"关注", "推荐"};
    private int[] tabIcons = {R.drawable.home_tab_left_selector, R.drawable.home_tab_right_selector};
    private LayoutInflater inflater;

    public HomeMainAdapter(FragmentManager fragmentManager, Context context) {
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
            convertView = (TextView) inflater.inflate(R.layout.tab_home_top, container, false);
        }
        TextView textView = (TextView) convertView;
        textView.setText(tabNames[position]);
//        textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[position], 0, 0);
        textView.setBackgroundResource(tabIcons[position]);
        return textView;
    }

    @Override
    public Fragment getFragmentForPage(int position) {
        LazyFragment fragment = null;
        if (position==0){
            fragment = new HomeLeftFragment();
            Bundle bundle = new Bundle();
            bundle.putString(HomeLeftFragment.INTENT_STRING_TABNAME, tabNames[position]);
            bundle.putInt(HomeLeftFragment.INTENT_INT_POSITION, position);
            fragment.setArguments(bundle);
        }else if (position==1){
            fragment = new HomeRightFragment();
            Bundle bundle = new Bundle();
            bundle.putString(HomeRightFragment.INTENT_STRING_TABNAME, tabNames[position]);
            bundle.putInt(HomeRightFragment.INTENT_INT_POSITION, position);
            fragment.setArguments(bundle);
        }
        return fragment;
    }
}
