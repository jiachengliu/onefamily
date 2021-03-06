package com.android.datamip.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.datamip.R;
import com.android.datamip.base.BaseActivity;
import com.litesuits.utils.JCToastUtil;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.viewpager.SViewPager;

/**
 * 作者：liujiacheng
 * 日期：2017/12/15 11:15
 * 描述：
 */

public class MainActivity extends BaseActivity {
    private IndicatorViewPager indicatorViewPager;
    private View centerView;
    private FixedIndicatorView indicator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPage();

    }
    private void initPage(){
        SViewPager viewPager = (SViewPager) findViewById(R.id.tabmain_viewPager);
        indicator = (FixedIndicatorView) findViewById(R.id.tabmain_indicator);
//        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(R.color.jc_2c2c2c, R.color.jc_666666));

        //这里可以添加一个view，作为centerView，会位于Indicator的tab的中间
        centerView = getLayoutInflater().inflate(R.layout.tab_main_center, indicator, false);
//        indicator.setCenterView(centerView);／／中间的按钮，暂时注释
        centerView.setOnClickListener(onClickListener);

        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        indicatorViewPager.setAdapter(new MainViewPageAdapter(getSupportFragmentManager(),this));
        // 禁止viewpager的滑动事件
        viewPager.setCanScroll(false);
        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(4);
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == centerView) {
                //还可以移除哦
                //indicator.removeCenterView();
                JCToastUtil.showToast(getApplicationContext(), "点击了CenterView");
            }
        }
    };
}
