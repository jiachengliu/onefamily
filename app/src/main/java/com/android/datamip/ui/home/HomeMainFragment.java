package com.android.datamip.ui.home;

import android.content.res.Resources;
import android.os.Bundle;

import com.android.datamip.R;
import com.android.datamip.base.BaseFragment;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.viewpager.SViewPager;

/**
 * 作者：liujiacheng
 * 日期：2018/1/3 14:42
 * 描述：
 */

public class HomeMainFragment extends BaseFragment {
    private static final String TAG = HomeMainFragment.class.getSimpleName();
    private IndicatorViewPager indicatorViewPager;
    public static final String INTENT_STRING_TABNAME = "intent_String_tabname";
    public static final String INTENT_INT_INDEX = "intent_int_index";
    private String tabName;
    private int index;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_home_main);
        Resources res = getResources();

        Bundle bundle = getArguments();
        tabName = bundle.getString(INTENT_STRING_TABNAME);
        index = bundle.getInt(INTENT_INT_INDEX);

        SViewPager viewPager = (SViewPager) findViewById(R.id.fragment_tabmain_viewPager);
        Indicator indicator = (Indicator) findViewById(R.id.fragment_tabmain_indicator);
        float unSelectSize = 16;
        float selectSize = unSelectSize * 1.2f;
        int selectColor = res.getColor(R.color.white);
        int unSelectColor = res.getColor(R.color.jc_666666);
//        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(selectColor, unSelectColor));
        viewPager.setCanScroll(true);// 可以禁止viewpager的滑动事件
        viewPager.clearAnimation();//注意：清除fragment之间切换动画。
        viewPager.setOffscreenPageLimit(2);

        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        // 注意这里 的FragmentManager 是 getChildFragmentManager(); 因为是在Fragment里面
        // 而在activity里面用FragmentManager 是 getSupportFragmentManager()
        indicatorViewPager.setAdapter(new HomeMainAdapter(getChildFragmentManager(),mActivity));
    }

    @Override
    protected void onResumeLazy() {
        super.onResumeLazy();

    }

    @Override
    protected void onFragmentStartLazy() {
        super.onFragmentStartLazy();
    }

    @Override
    protected void onFragmentStopLazy() {
        super.onFragmentStopLazy();
    }

    @Override
    protected void onPauseLazy() {
        super.onPauseLazy();
    }

    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}

