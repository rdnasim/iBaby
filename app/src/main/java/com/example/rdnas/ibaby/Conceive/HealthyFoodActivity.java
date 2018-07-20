package com.example.rdnas.ibaby.Conceive;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class HealthyFoodActivity extends AppCompatActivity {


    SwipeRefreshLayout swipe;
    WebView healthyFoodWebView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_food);

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
        healthyFoodWebView = findViewById(R.id.healthyFoodWebView);
        healthyFoodWebView.getSettings().setJavaScriptEnabled(true);
        healthyFoodWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        healthyFoodWebView.loadUrl("http://codemapltd.com/babyshop/food-and-health/");
        swipe.setRefreshing(true);
        healthyFoodWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                healthyFoodWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (healthyFoodWebView.canGoBack()) {
            healthyFoodWebView.goBack();
        } else {
            finish();
        }

    }
}
//http://codemapltd.com/babyshop/food-and-health/