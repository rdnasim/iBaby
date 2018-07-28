package com.example.rdnas.ibaby.DoctorHospital;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class EDoctorActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    WebView eDoctorWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edoctor);

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
        eDoctorWebView = findViewById(R.id.eDoctorWebView);
        eDoctorWebView.getSettings().setJavaScriptEnabled(true);
        eDoctorWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        eDoctorWebView.loadUrl("http://codemapltd.com/babyshop/doctors/");
        swipe.setRefreshing(true);
        eDoctorWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                eDoctorWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (eDoctorWebView.canGoBack()) {
            eDoctorWebView.goBack();
        } else {
            finish();
        }



    }
}
