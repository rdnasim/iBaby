package com.example.rdnas.ibaby.Conceive.AdviceActivity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class PeriodsActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    WebView periodsWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periods);


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
        periodsWebView = findViewById(R.id.periodsWebView);
        periodsWebView.getSettings().setJavaScriptEnabled(true);
        periodsWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        periodsWebView.loadUrl("http://www.familyplanning.org.nz/advice/periods");
        swipe.setRefreshing(true);
        periodsWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                periodsWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (periodsWebView.canGoBack()) {
            periodsWebView.goBack();
        } else {
            finish();
        }



    }
}