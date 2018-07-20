package com.example.rdnas.ibaby.Conceive.AdviceActivity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class ResourcesActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    WebView resourcesWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resourses);


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
        resourcesWebView = findViewById(R.id.resourcesWebView);
        resourcesWebView.getSettings().setJavaScriptEnabled(true);
        resourcesWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        resourcesWebView.loadUrl("http://shop.familyplanning.org.nz/resources");
        swipe.setRefreshing(true);
        resourcesWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                resourcesWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (resourcesWebView.canGoBack()) {
            resourcesWebView.goBack();
        } else {
            finish();
        }

    }
}
