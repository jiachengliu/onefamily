package com.android.datamip.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.datamip.R;

import java.util.List;

/**
 * 作者：liujiacheng
 * 日期：2018/1/4 17:13
 * 描述：
 */

public class GridViewAdapter extends BaseAdapter {
    private LayoutInflater mInfalter;
    private Context mContext;
    private List mList;
    public GridViewAdapter(Context context, List list) {
        mInfalter = LayoutInflater.from(context);
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        QImageViewHolder holder;
        if (convertView == null) {
            convertView = mInfalter.inflate(R.layout.item_image_gridview, null);
//            convertView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Ex.T().getDip2Px(mContext, 100)));
            holder = new QImageViewHolder();
            holder.ivImage = (ImageView) convertView.findViewById( R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (QImageViewHolder) convertView.getTag();
        }

        final String item = (String) mList.get(position);

//        if (!JCStringUtils.getInstance().isEmpty(item)) {
        if (item!=null) {
            holder.ivImage.setImageResource(R.mipmap.image1);
        }

        return convertView;
    }
    private static class QImageViewHolder{
        ImageView ivImage;
    }
}
