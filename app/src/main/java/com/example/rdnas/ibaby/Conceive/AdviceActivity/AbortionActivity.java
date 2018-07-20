package com.example.rdnas.ibaby.Conceive.AdviceActivity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class AbortionActivity extends AppCompatActivity {

    WebView abortionWebView;
    SwipeRefreshLayout swipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abortion);

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
        abortionWebView = findViewById(R.id.abortionWebView);
        abortionWebView.getSettings().setJavaScriptEnabled(true);
        abortionWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        abortionWebView.loadUrl("http://www.familyplanning.org.nz/advice/abortion/");
        swipe.setRefreshing(true);
        abortionWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                abortionWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (abortionWebView.canGoBack()) {
            abortionWebView.goBack();
        } else {
            finish();
        }
    }


}
