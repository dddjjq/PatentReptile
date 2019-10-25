package com.fanfan.patentreptile.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
        addListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    public abstract void addListener();

}
