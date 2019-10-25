package com.fanfan.patentreptile.activity;

import android.widget.TextView;

import com.fanfan.patentreptile.R;
import com.fanfan.patentreptile.base.BaseActivity;
import com.fanfan.patentreptile.contract.SoopatContract;
import com.fanfan.patentreptile.entity.SoopatEntity;
import com.fanfan.patentreptile.presenter.SoopatPresenter;

import java.util.List;

public class SoopatActivity extends BaseActivity implements SoopatContract.View {

    private TextView htmlText;
    private SoopatContract.Presenter mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_soopat;
    }

    @Override
    public void initView() {
        htmlText = (TextView) findViewById(R.id.soopat_html_text);
    }

    @Override
    public void initData() {
        mPresenter = new SoopatPresenter();
        mPresenter.addView(this);
        mPresenter.requestAllHtmlData("恒翼能");
    }

    @Override
    public void addListener() {

    }

    @Override
    public void showDataSucceed(List<SoopatEntity> soopatEntities) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void startRequest() {

    }

    @Override
    public void showError() {

    }

}
