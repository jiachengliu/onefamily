package com.android.datamip.ui.adapter;

import android.view.View;
import android.widget.AdapterView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.android.datamip.R;
import com.android.datamip.ui.entity.HomeLeftBean;
import com.android.datamip.ui.widget.ImageGridView;
import com.litesuits.utils.JCToastUtil;

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
        int position = helper.getLayoutPosition();
        int size = item.getPicList()==null?0:item.getPicList().size();
        ImageGridView imageGridView = helper.getConvertView().findViewById(R.id.gridview);
        if (size!=0){
            imageGridView.setVisibility(View.VISIBLE);
            if (size==1||size==2||size==4) {
                imageGridView.setNumColumns(2);
            }else {
                imageGridView.setNumColumns(3);
            }
            GridViewAdapter gridViewAdapter = new GridViewAdapter(mContext,item.getPicList());
            imageGridView.setAdapter(gridViewAdapter);
            imageGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    JCToastUtil.showToast(mContext,"图片"+position);
                }
            });
        }else {
            imageGridView.setVisibility(View.GONE);
        }
        helper.setText(R.id.text_userName,"摆渡人"+position);
        helper.setText(R.id.text_createTime, "01-03 12:2"+position);
    }
}
