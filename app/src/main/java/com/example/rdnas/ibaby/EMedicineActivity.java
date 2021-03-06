package com.example.rdnas.ibaby;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class EMedicineActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    WebView eMedicineWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emedicine);

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
        eMedicineWebView = findViewById(R.id.eMedicineWebView);
        eMedicineWebView.getSettings().setJavaScriptEnabled(true);
        eMedicineWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        eMedicineWebView.loadUrl("http://codemapltd.com/babyshop/medicine/");
        swipe.setRefreshing(true);
        eMedicineWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                eMedicineWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (eMedicineWebView.canGoBack()) {
            eMedicineWebView.goBack();
        } else {
            finish();
        }

    }
}
