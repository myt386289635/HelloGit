package com.moxiaoting.lee.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.moxiaoting.lee.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/11/30 18:26
 * Description： $todo
 */
public class WebActivity extends AppCompatActivity {

    @Bind(R.id.web_view)
    WebView mWebView;
    @Bind(R.id.title_view)
    TextView mTitleView;
    @Bind(R.id.left_img)
    ImageView mLeftImg;


    private String url = "";
    private String title = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        initDate();
        initView();
    }

    private void initDate() {
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
    }

    private void initView() {
        mTitleView.setText(title);
        mLeftImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (mWebView.canGoBack()) {
//                    mWebView.goBack();//返回上一页面
//                } else {
                    //退出程序
                    finish();
//                }
            }
        });


        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setJavaScriptEnabled(true);//启用支持javascript
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);//不使用缓存
        mWebView.getSettings().setDomStorageEnabled(true);// 开启 DOM storage API 功能
        mWebView.getSettings().setUseWideViewPort(true);

        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url.startsWith("http:") || url.startsWith("https:") ) {
                    view.loadUrl(url);
                    return false;
                }else{
                    return true;
                }
            }
        });

        mWebView.loadUrl(url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
