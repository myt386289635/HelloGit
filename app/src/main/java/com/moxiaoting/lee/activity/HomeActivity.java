package com.moxiaoting.lee.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.moxiaoting.lee.R;
import com.moxiaoting.lee.adapter.MyAdapter;
import com.moxiaoting.lee.fragment.HomeFragment;
import com.moxiaoting.lee.fragment.MyFragment;
import com.moxiaoting.lee.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/11/30 15:26
 * Description： 主页
 */
public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    private MyAdapter mMyAdapter;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mMyAdapter = new MyAdapter(getSupportFragmentManager());
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new SettingFragment());
        mFragments.add(new MyFragment());

        mMyAdapter.setFragments(mFragments);
        mViewPager.setAdapter(mMyAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setSelectedTabIndicatorColor(Color.TRANSPARENT);
        mTabLayout.setTabTextColors(Color.BLACK,Color.RED);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
