package com.moxiaoting.lee.bean;

/**
 * Author     ： 莫小婷
 * CreateTime ： 2017/11/30 17:57
 * Description： $todo
 */
public class LeeBean {

    private String url;
    private String title;
    private String strUrl;

    public LeeBean(String url, String title, String strUrl) {
        this.url = url;
        this.title = title;
        this.strUrl = strUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStrUrl() {
        return strUrl;
    }

    public void setStrUrl(String strUrl) {
        this.strUrl = strUrl;
    }
}
