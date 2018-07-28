package com.example.rdnas.ibaby.DoctorHospital;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class EHospitalActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    WebView eHospitalWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ehospital);


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
        eHospitalWebView = findViewById(R.id.eHospitalWebView);
        eHospitalWebView.getSettings().setJavaScriptEnabled(true);
        eHospitalWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        eHospitalWebView.loadUrl("http://codemapltd.com/babyshop/hospital-list/");
        swipe.setRefreshing(true);
        eHospitalWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                eHospitalWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (eHospitalWebView.canGoBack()) {
            eHospitalWebView.goBack();
        } else {
            finish();
        }

    }
}
