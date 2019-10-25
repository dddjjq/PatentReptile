package com.fanfan.patentreptile.contract;

import com.fanfan.patentreptile.base.BasePresenter;
import com.fanfan.patentreptile.base.BaseView;
import com.fanfan.patentreptile.entity.SoopatEntity;

import java.util.List;

public class SoopatContract {

    public interface Presenter extends BasePresenter {
        void requestAllHtmlData(String word);
    }

    public interface View extends BaseView {
        void showDataSucceed(List<SoopatEntity> soopatEntities);
    }
}
