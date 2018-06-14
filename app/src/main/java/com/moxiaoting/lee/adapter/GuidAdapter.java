package com.moxiaoting.lee.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.moxiaoting.lee.R;
import com.moxiaoting.lee.activity.HomeActivity;

import java.util.List;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/11/30 15:37
 * Description： $todo
 */
public class GuidAdapter extends PagerAdapter {

    private List<Integer> mIntegers;
    private Context mContext;
    private onClickItem mOnClickItem;

    public GuidAdapter(List<Integer> integers, Context context) {
        mIntegers = integers;
        mContext = context;
    }

    public void setOnClickItem(onClickItem onClickItem) {
        mOnClickItem = onClickItem;
    }

    @Override
    public int getCount() {
        return mIntegers.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {

        final View view = LayoutInflater.from(mContext).inflate(R.layout.item_guid,container,false);
        final ImageView imageView = (ImageView) view.findViewById(R.id.item_image);
        imageView.setBackgroundResource(mIntegers.get(position));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == mIntegers.size() - 1){
                    if(mOnClickItem != null){
                        mOnClickItem.onclickItem();
                    }
                }
            }
        });


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

   public interface onClickItem{
        void onclickItem();
    }
}
