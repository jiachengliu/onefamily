package com.jiacheng.family.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jiacheng.family.R;
import com.jiacheng.family.ui.entity.HomeLeftBean;

/**
 * 作者：liujiacheng
 * 日期：2018/1/4 11:32
 * 描述：
 */

public class HomeLeftAdapter extends BaseQuickAdapter<HomeLeftBean, BaseViewHolder> {
    public HomeLeftAdapter() {
        super(R.layout.item_home_left, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeLeftBean item) {
        switch (helper.getLayoutPosition() %
                3) {
            case 0:
                helper.setText(R.id.text_userName,"摆渡人"+helper.getLayoutPosition());
//                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setText(R.id.text_userName,"摆渡人"+helper.getLayoutPosition());
                break;
            case 2:
                helper.setText(R.id.text_userName,"摆渡人"+helper.getLayoutPosition());
                break;
        }
        helper.setText(R.id.text_createTime, "01-03 12:2"+helper.getLayoutPosition());
    }
}
