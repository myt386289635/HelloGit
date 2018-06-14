package com.moxiaoting.lee.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.moxiaoting.lee.R;
import com.moxiaoting.lee.activity.PushSettingActivity;
import com.moxiaoting.lee.activity.ShowActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/12/7 10:27
 * Description： $todo
 */
public class MyFragment extends Fragment {

    @Bind(R.id.seting_name)
    TextView mSetingName;
    @Bind(R.id.seting_up)
    LinearLayout mSetingUp;
    @Bind(R.id.seting_logo)
    LinearLayout mSetingLogo;
    @Bind(R.id.seting_upname)
    TextView mSetingUpname;
    @Bind(R.id.seting_tools)
    TextView mSetingTools;
    @Bind(R.id.seting_jieshao)
    TextView mSetingJieshao;
    @Bind(R.id.setting_logo_text)
    TextView mSettingLogoText;
    private SharedPreferences seting;
    private SharedPreferences.Editor mEditor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this, view);
        seting = getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        mEditor = seting.edit();

        if(seting.getString("name","").equals("")){
            mSetingName.setText("游客532");
        }else {
            mSetingName.setText(seting.getString("name","无名氏"));
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.seting_up, R.id.seting_logo, R.id.seting_upname, R.id.seting_tools, R.id.seting_jieshao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.seting_up://修改密码
                Toast.makeText(getContext(), "该功能正在开发中，敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.seting_logo://登陆
                Toast.makeText(getContext(), "该功能正在开发中，敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.seting_upname:
                initDialogBg(getContext(), "请输入您的用户名", null);
                break;
            case R.id.seting_tools:
                startActivity(new Intent(getContext(), PushSettingActivity.class));
                break;
            case R.id.seting_jieshao://介绍
                startActivity(new Intent(getContext(), ShowActivity.class));
                break;
        }
    }

    public void initDialogBg(final Context context, String title, final OnClick onClick) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_commen, null);
        final Dialog myDialog = new Dialog(context, R.style.dialog);
        myDialog.getWindow().setDimAmount(0.32f);
        myDialog.setContentView(view);
        myDialog.show();
        final EditText textView = (EditText) view.findViewById(R.id.text_content);
        TextView text_cancle = (TextView) view.findViewById(R.id.text_cancle);
        TextView text_sure = (TextView) view.findViewById(R.id.text_sure);
        text_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        text_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(textView.getText().toString().trim())) {
                    mSetingName.setText(textView.getText().toString());
                    myDialog.dismiss();
                    mEditor.putString("name",mSetingName.getText().toString());
                    mEditor.commit();
                } else {
                    Toast.makeText(context, "请输入您要修改的用户名", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
