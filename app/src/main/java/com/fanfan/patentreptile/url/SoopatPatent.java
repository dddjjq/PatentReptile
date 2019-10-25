package com.fanfan.patentreptile.url;

public class SoopatPatent implements IPatent {

    private static final String BASE_URL_START = "http://www1.soopat.com/Home/Result?Sort=1&View=&Columns=&Valid=&Embed=&Db=&Ids=&FolderIds=&FolderId=&ImportPatentIndex=&Filter=&SearchWord=";
    private static final String BASE_URL_END = "&FMZL=Y&SYXX=Y&WGZL=Y&FMSQ=Y&PatentIndex=";

    @Override
    public String getSearchUrl(String word,int index) {
        return BASE_URL_START + word + BASE_URL_END + index;
    }
}
