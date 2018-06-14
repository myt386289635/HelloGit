package com.moxiaoting.lee.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.moxiaoting.lee.R;
import com.moxiaoting.lee.adapter.HomeAdapter;
import com.moxiaoting.lee.bean.LeeBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/12/7 11:20
 * Description： $todo
 */
public class NewsActvity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Bind(R.id.left_img)
    ImageView mLeftImg;
    @Bind(R.id.return_layout)
    RelativeLayout mReturnLayout;
    @Bind(R.id.list_view)
    ListView mListView;

    private HomeAdapter mAdapter;
    private List<LeeBean> mBeans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        initView();
        initDate();
    }

    private void initDate() {
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","杭州彩民56元复式喜中双色球1107万","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14222439.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","9亿派奖火热进行 苏州彩民喜获1135万","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14239777.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","双色球派奖进行中 济南彩友专享福利倒计时","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14239758.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","滁州福彩加强双色球大奖宣传 为9亿派奖助力","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14222443.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","锣鼓喧天 淮南福彩庆祝791万双色球大奖","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14222439.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","杭州彩民56元复式喜中双色球1107万元","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14222437.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","双色球140期头奖特别奖4注1103万 奖池6.87亿","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14209009.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","双色球140期开奖结果：21 22 25 28 29 30+08","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14206994.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","杭州彩民10元中双色球903万幸运大奖","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14199692.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","903万！丹阳市第四次开出双色球大奖","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14199677.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","济南群英会长胜站点自选收获福彩双色球银奖","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14199459.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","30位彩民组团买彩票 喜获双色球38万奖金","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14199372.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","双色球大奖遍地开 安徽福彩喜讯频相传","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14189100.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","双色球9亿元加奖来袭 徐州刮起购买风","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14187038.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","双色球139期头奖特别奖1注1482万 奖池7.21亿","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14186653.shtml"));
        mBeans.add(new LeeBean("http://www.zhcw.com/images/2015/khdsx/xxyewm.jpg","双色球139期开奖结果：02 14 20 24 28 32+16","http://www.zhcw.com/xinwen/caizhongxinwen-ssq/14186641.shtml"));
        mAdapter.notifyDataSetChanged();
    }

    private void initView() {
        mLeftImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mBeans = new ArrayList<>();
        mAdapter = new HomeAdapter(mBeans,this);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this,WebActivity.class);
        intent.putExtra("url",mBeans.get(i).getStrUrl());
        intent.putExtra("title",mBeans.get(i).getTitle());
        startActivity(intent);
    }
}
