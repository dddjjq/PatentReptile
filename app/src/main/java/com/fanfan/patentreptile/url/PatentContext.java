package com.fanfan.patentreptile.url;

public class PatentContext {

    private IPatent mIPatent;

    public PatentContext(IPatent iPatent) {
        mIPatent = iPatent;
    }

    public String getSearchUrl(String word,int index) {
        return mIPatent.getSearchUrl(word,index);
    }
}
