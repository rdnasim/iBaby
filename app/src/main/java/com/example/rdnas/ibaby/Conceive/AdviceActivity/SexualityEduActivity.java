package com.example.rdnas.ibaby.Conceive.AdviceActivity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class SexualityEduActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    WebView sexEduWebView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexuality_edu);

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
        sexEduWebView = findViewById(R.id.sexEduWebView);
        sexEduWebView.getSettings().setJavaScriptEnabled(true);
        sexEduWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        sexEduWebView.loadUrl("http://www.familyplanning.org.nz/advice/sexuality-education");
        swipe.setRefreshing(true);
        sexEduWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                sexEduWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (sexEduWebView.canGoBack()) {
            sexEduWebView.goBack();
        } else {
            finish();
        }

    }
}
//http://www.familyplanning.org.nz/advice/sexuality-education