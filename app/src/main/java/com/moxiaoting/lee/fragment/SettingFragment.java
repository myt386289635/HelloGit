package com.moxiaoting.lee.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.moxiaoting.lee.R;
import com.moxiaoting.lee.activity.NewsActvity;
import com.moxiaoting.lee.activity.PushSettingActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/12/7 10:20
 * Description： $todo
 */
public class SettingFragment extends Fragment {

    @Bind(R.id.message_push_layout)
    LinearLayout mMessagePushLayout;
    @Bind(R.id.message_layout)
    LinearLayout mMessageLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.message_push_layout,R.id.message_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.message_push_layout:
                startActivity(new Intent(getContext(), PushSettingActivity.class));
                break;
            case R.id.message_layout:
                startActivity(new Intent(getContext(), NewsActvity.class));
                break;
        }
    }
}
