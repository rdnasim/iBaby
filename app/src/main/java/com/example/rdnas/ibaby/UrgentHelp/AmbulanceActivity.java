package com.example.rdnas.ibaby.UrgentHelp;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class AmbulanceActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    WebView ambulanceWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);



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
        ambulanceWebView = findViewById(R.id.ambulanceWebView);
        ambulanceWebView.getSettings().setJavaScriptEnabled(true);
        ambulanceWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        ambulanceWebView.loadUrl("http://codemapltd.com/babyshop/ambulance/");
        swipe.setRefreshing(true);
        ambulanceWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                ambulanceWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (ambulanceWebView.canGoBack()) {
            ambulanceWebView.goBack();
        } else {
            finish();
        }


    }
}
