package com.example.rdnas.ibaby;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ProductActivity extends AppCompatActivity {

    WebView productWebView;
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


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
        productWebView = findViewById(R.id.productWebView);
        productWebView.getSettings().setJavaScriptEnabled(true);
        productWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        productWebView.loadUrl("http://codemapltd.com/babyshop/shop/");
        swipe.setRefreshing(true);
        productWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                productWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (productWebView.canGoBack()) {
            productWebView.goBack();
        } else {
            finish();
        }
    }
}
