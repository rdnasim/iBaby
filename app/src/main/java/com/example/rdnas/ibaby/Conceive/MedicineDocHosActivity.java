package com.example.rdnas.ibaby.Conceive;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class MedicineDocHosActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    WebView mediDocHosWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_doc_hos);
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
        mediDocHosWebView = findViewById(R.id.mediDocHosWebView);
        mediDocHosWebView.getSettings().setJavaScriptEnabled(true);
        mediDocHosWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        mediDocHosWebView.loadUrl("https://nhd.gov.bd/emergency/hospital");
        swipe.setRefreshing(true);
        mediDocHosWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                mediDocHosWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (mediDocHosWebView.canGoBack()) {
            mediDocHosWebView.goBack();
        } else {
            finish();
        }

    }
}
//https://nhd.gov.bd/emergency/hospital