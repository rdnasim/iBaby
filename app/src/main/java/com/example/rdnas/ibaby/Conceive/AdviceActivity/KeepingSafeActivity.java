package com.example.rdnas.ibaby.Conceive.AdviceActivity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class KeepingSafeActivity extends AppCompatActivity {

    WebView keepingSafeWebView;
    SwipeRefreshLayout swipe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keeping_safe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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
        keepingSafeWebView = findViewById(R.id.keepingSafeWebView);
        keepingSafeWebView.getSettings().setJavaScriptEnabled(true);
        keepingSafeWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        keepingSafeWebView.loadUrl("http://www.familyplanning.org.nz/advice/keeping-safe");
        swipe.setRefreshing(true);
        keepingSafeWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                keepingSafeWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (keepingSafeWebView.canGoBack()) {
            keepingSafeWebView.goBack();
        } else {
            finish();
        }
    }


    }
