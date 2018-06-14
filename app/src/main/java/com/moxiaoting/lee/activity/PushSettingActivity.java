package com.moxiaoting.lee.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.moxiaoting.lee.MyApplication;
import com.moxiaoting.lee.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/12/7 10:53
 * Description： $todo
 */
public class PushSettingActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    @Bind(R.id.left_img)
    ImageView mLeftImg;
    @Bind(R.id.return_layout)
    RelativeLayout mReturnLayout;
    @Bind(R.id.push_switch)
    SwitchCompat mPushSwitch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_setting);
        ButterKnife.bind(this);

        if (JPushInterface.isPushStopped(MyApplication.getContext())) {
            mPushSwitch.setChecked(false);
        } else {
            mPushSwitch.setChecked(true);
        }

        mPushSwitch.setOnCheckedChangeListener(this);
        mLeftImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            JPushInterface.resumePush(MyApplication.getContext());
        } else {
            JPushInterface.stopPush(MyApplication.getContext());
        }
    }
}
