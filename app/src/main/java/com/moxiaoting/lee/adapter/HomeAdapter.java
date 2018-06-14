package com.moxiaoting.lee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.moxiaoting.lee.R;
import com.moxiaoting.lee.bean.LeeBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/11/30 17:51
 * Description： $todo
 */
public class HomeAdapter extends BaseAdapter {

    private List<LeeBean> mBeans;
    private Context mContext;

    public HomeAdapter(List<LeeBean> beans, Context context) {
        mBeans = beans;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return mBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_lee, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Glide.with(mContext).load(mBeans.get(i).getUrl()).into(holder.mItemImage);
        holder.mItemTitle.setText(mBeans.get(i).getTitle());

        return view;
    }

    class ViewHolder {
        @Bind(R.id.item_image)
        ImageView mItemImage;
        @Bind(R.id.item_title)
        TextView mItemTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
