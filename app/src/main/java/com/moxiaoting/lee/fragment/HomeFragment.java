package com.moxiaoting.lee.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.moxiaoting.lee.MyApplication;
import com.moxiaoting.lee.R;
import com.moxiaoting.lee.activity.WebActivity;
import com.moxiaoting.lee.adapter.HomeAdapter;
import com.moxiaoting.lee.bean.LeeBean;
import com.moxiaoting.lee.bean.ResultBean;
import com.moxiaoting.lee.view.ProgressDialogView;
import com.moxiaoting.volleylibrary.RequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/12/7 9:02
 * Description： $todo
 */
public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {
    @Bind(R.id.title_view)
    TextView mTitleView;
    @Bind(R.id.list_view)
    ListView mListView;

    private HomeAdapter mAdapter;
    private List<LeeBean> mBeans;

    String url = "http://vip.132app999.com/Lottery_server/get_init_data.php?appid=100157377&type=android";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        ButterKnife.bind(this, view);
        initView();
        getDate();   //测试一下
        return view;
    }


    private void getDate() {
        final Dialog dialog = (new ProgressDialogView()).createLoadingDialog(getContext(), "正在加载...");
        dialog.show();
        MyApplication.getRequestInstance().get(getContext(), url, new RequestListener() {
            @Override
            public void requestSuccess(String s) {
                if(dialog != null && dialog.isShowing()){
                    dialog.dismiss();
                }
                ResultBean resultBean = new Gson().fromJson(s,ResultBean.class);
                if(resultBean.getRt_code().equals("200")){
                    String str = getUidFromBase64(resultBean.getData());
                    Log.d("++++++", str);
                    if(!TextUtils.isEmpty(str) && !str.equals("\"\"")){
                        try {
                            JSONObject object = new JSONObject(str);
                            String show_url = object.getString("show_url");
                            if(show_url .equals("1")){
                                String url = object.getString("url");
                                startActivity(new Intent(getContext(),WebActivity.class)
                                        .putExtra("url",url)
                                        .putExtra("title",url)
                                );
                            }else {
                                initDate();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }else {
                        initDate();
                    }
                }else {
                    initDate();
                }
            }

            @Override
            public void requestAgain(String s) {

            }
        });
    }



    public static String getUidFromBase64(String base64Id){
        String result ="";
        if(!TextUtils.isEmpty(base64Id)){
            try {
                result = new String(Base64.decode(base64Id.getBytes(),Base64.DEFAULT));
            }catch (Exception e){
                Log.d("error", "base64解码失败");
            }
        }
        Log.d("-----","getUidFromBase64= "+result);
        return result;
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
        mTitleView.setText("资讯文章");

        mBeans = new ArrayList<>();
        mAdapter = new HomeAdapter(mBeans,getContext());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getContext(),WebActivity.class);
        intent.putExtra("url",mBeans.get(i).getStrUrl());
        intent.putExtra("title",mBeans.get(i).getTitle());
        startActivity(intent);
    }
}
