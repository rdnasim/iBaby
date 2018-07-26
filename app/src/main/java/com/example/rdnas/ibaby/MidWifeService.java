package com.example.rdnas.ibaby;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MidWifeService extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    WebView midWifeWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_wife_service);


        swipe = findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                WebAction();
            }
        });

        WebAction();
    }

    private void WebAction() {
        midWifeWebView = findViewById(R.id.midWifeWebView);
        midWifeWebView.getSettings().setJavaScriptEnabled(true);
        midWifeWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        midWifeWebView.loadUrl("http://codemapltd.com/babyshop/midwife/");
        swipe.setRefreshing(true);
        midWifeWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                midWifeWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (midWifeWebView.canGoBack()) {
            midWifeWebView.goBack();
        } else {
            finish();
        }


    }
}
