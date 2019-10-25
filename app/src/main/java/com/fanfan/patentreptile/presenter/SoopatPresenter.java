package com.fanfan.patentreptile.presenter;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.fanfan.patentreptile.activity.SoopatActivity;
import com.fanfan.patentreptile.base.BaseView;
import com.fanfan.patentreptile.contract.SoopatContract;
import com.fanfan.patentreptile.entity.SoopatEntity;
import com.fanfan.patentreptile.okhttp.OkHttpHelper;
import com.fanfan.patentreptile.url.PatentContext;
import com.fanfan.patentreptile.url.SoopatPatent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SoopatPresenter implements SoopatContract.Presenter {

    private static final int RESPONSE = 0x01;
    private SoopatActivity mBaseView;
    private List<SoopatEntity> mSoopatEntities;

    public SoopatPresenter() {
        mSoopatEntities = new ArrayList<>();
    }

    @Override
    public void requestAllHtmlData(String word) {
        String url = new PatentContext(new SoopatPatent()).getSearchUrl(word, 0);
        OkHttpHelper.getInstance().startGetRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mBaseView.showError();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                parseHtml(result);
                if (mSoopatEntities.size() > 0) {
                    Message message = responseHandler.obtainMessage();
                    message.what = RESPONSE;
                    message.obj = mSoopatEntities;
                    responseHandler.sendMessage(message);
                }
            }
        });
    }

    @Override
    public void addView(BaseView baseView) {
        mBaseView = (SoopatActivity) baseView;
    }

    @Override
    public void detachView() {
        mBaseView = null;
    }

    private void parseHtml(String html) {
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("div.PatentBlock");
        for (Element e : elements) {
            Element type = e.select(".PatentTypeBlock").first();
            Element author = e.selectFirst(".PatentAuthorBlock");
            Element content = e.selectFirst(".PatentContentBlock");
            if (type == null
                    || author == null
                    || content == null)
                continue;
            String url = type.select("input").attr("sqh");
            SoopatEntity soopatEntity = new SoopatEntity();
            soopatEntity.setType(type.text());
            soopatEntity.setAuthor(author.text());
            soopatEntity.setContent(content.text());
            soopatEntity.setUrl(url);
            mSoopatEntities.add(soopatEntity);
        }
    }

    @SuppressWarnings("HandlerLeak")
    private Handler responseHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case RESPONSE:
                    mBaseView.showDataSucceed((List<SoopatEntity>) msg.obj);
                    break;
            }
        }
    };


}
