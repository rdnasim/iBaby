package com.example.rdnas.ibaby.Pregnant;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class PregnanacyWeightCalActivity extends AppCompatActivity {


    SwipeRefreshLayout swipe;
    WebView pregnancyWeightCalWebView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnanacy_weight_cal);

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
        pregnancyWeightCalWebView = findViewById(R.id.pregnancyWeightCalWebView);
        pregnancyWeightCalWebView.getSettings().setJavaScriptEnabled(true);
        pregnancyWeightCalWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        pregnancyWeightCalWebView.loadUrl("http://codemapltd.com/babyshop/weekly-pregnancy-weight-calculator/");
        swipe.setRefreshing(true);
        pregnancyWeightCalWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                pregnancyWeightCalWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (pregnancyWeightCalWebView.canGoBack()) {
            pregnancyWeightCalWebView.goBack();
        } else {
            finish();
        }

    }
}
//http://codemapltd.com/babyshop/weekly-pregnancy-weight-calculator/
