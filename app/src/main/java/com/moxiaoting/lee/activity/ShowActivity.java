package com.moxiaoting.lee.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.moxiaoting.lee.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/12/7 12:43
 * Description： $todo
 */
public class ShowActivity extends AppCompatActivity {

    @Bind(R.id.left_img)
    ImageView mLeftImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);

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
}
