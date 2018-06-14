package com.moxiaoting.lee.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.moxiaoting.lee.R;
import com.moxiaoting.lee.adapter.GuidAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/11/30 15:27
 * Description： 引导页
 */
public class GuidActivity extends AppCompatActivity implements GuidAdapter.onClickItem {

    private ViewPager mViewPager;
    private GuidAdapter mGuidAdapter;
    private List<Integer> mIntegers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guid);
        intiView();
        initDate();
    }

    private void initDate() {
        mIntegers.add(R.mipmap.guid1);
        mIntegers.add(R.mipmap.guid2);
        mIntegers.add(R.mipmap.guid3);
        mIntegers.add(R.mipmap.guid4);
        mGuidAdapter.notifyDataSetChanged();
    }

    private void intiView() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mIntegers = new ArrayList<>();
        mGuidAdapter = new GuidAdapter(mIntegers,this);
        mGuidAdapter.setOnClickItem(this);
        mViewPager.setAdapter(mGuidAdapter);
    }

    @Override
    public void onclickItem() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
