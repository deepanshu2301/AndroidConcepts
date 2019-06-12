package com.dipanshu.browserapp;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class webviewclient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

}
