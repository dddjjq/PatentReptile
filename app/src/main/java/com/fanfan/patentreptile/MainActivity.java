package com.fanfan.patentreptile;

import android.content.Intent;
import android.view.View;

import com.fanfan.patentreptile.activity.SoopatActivity;
import com.fanfan.patentreptile.base.BaseActivity;

import androidx.cardview.widget.CardView;

public class MainActivity extends BaseActivity {

    private CardView soopatCardView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        soopatCardView = (CardView) findViewById(R.id.soopat_card);
    }

    @Override
    public void initData() {

    }

    @Override
    public void addListener() {
        soopatCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SoopatActivity.class);
                startActivity(intent);
            }
        });
    }
}
