package com.fanfan.patentreptile.okhttp;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpHelper {

    private OkHttpClient mOkHttpClient;
    private volatile static OkHttpHelper instance;

    private OkHttpHelper() {
        mOkHttpClient = new OkHttpClient();
    }

    public static OkHttpHelper getInstance() {
        if (instance == null) {
            synchronized (OkHttpHelper.class) {
                if (instance == null) {
                    instance = new OkHttpHelper();
                }
            }
        }
        return instance;
    }

    public void startGetRequest(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }

}
