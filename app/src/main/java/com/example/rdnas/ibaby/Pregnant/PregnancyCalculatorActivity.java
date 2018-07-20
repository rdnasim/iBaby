package com.example.rdnas.ibaby.Pregnant;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class PregnancyCalculatorActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    WebView pregnancyCalWebView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy_calculator);

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
        pregnancyCalWebView = findViewById(R.id.pregnancyCalcuWebView);
        pregnancyCalWebView.getSettings().setJavaScriptEnabled(true);
        pregnancyCalWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        pregnancyCalWebView.loadUrl("http://codemapltd.com/babyshop/pregnancy-calculator-online/");
        swipe.setRefreshing(true);
        pregnancyCalWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                pregnancyCalWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (pregnancyCalWebView.canGoBack()) {
            pregnancyCalWebView.goBack();
        } else {
            finish();
        }

    }
}
//http://codemapltd.com/babyshop/pregnancy-calculator-online/