package com.example.rdnas.ibaby.Conceive.AdviceActivity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class SexTransActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    WebView sexTransWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex_trans);

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
        sexTransWebView = findViewById(R.id.sexTransWebView);
        sexTransWebView.getSettings().setJavaScriptEnabled(true);
        sexTransWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        sexTransWebView.loadUrl("http://www.familyplanning.org.nz/advice/sexually-transmissible-infections");
        swipe.setRefreshing(true);
        sexTransWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                sexTransWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (sexTransWebView.canGoBack()) {
            sexTransWebView.goBack();
        } else {
            finish();
        }

    }
}

//http://www.familyplanning.org.nz/advice/sexually-transmissible-infections
