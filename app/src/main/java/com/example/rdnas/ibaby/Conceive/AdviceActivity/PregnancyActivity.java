package com.example.rdnas.ibaby.Conceive.AdviceActivity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class PregnancyActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    WebView pregnancyWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy);


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
        pregnancyWebView = findViewById(R.id.pregnancyWebView);
        pregnancyWebView.getSettings().setJavaScriptEnabled(true);
        pregnancyWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        pregnancyWebView.loadUrl("http://www.familyplanning.org.nz/advice/pregnancy");
        swipe.setRefreshing(true);
        pregnancyWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                pregnancyWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (pregnancyWebView.canGoBack()) {
            pregnancyWebView.goBack();
        } else {
            finish();
        }

    }
}

//http://www.familyplanning.org.nz/advice/pregnancy
