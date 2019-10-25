package com.fanfan.patentreptile.base;

public interface BaseView {

    /**
     * 开始请求的动画
     */
    void startRequest();

    /**
     * 出现错误的动画，如网络等问题
     */
    void showError();
}
