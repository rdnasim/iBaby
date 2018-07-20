package com.example.rdnas.ibaby.Conceive.AdviceActivity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rdnas.ibaby.R;

public class CoursesActivity extends AppCompatActivity {


    WebView coursesWebView;
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

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
        coursesWebView = findViewById(R.id.coursesWebView);
        coursesWebView.getSettings().setJavaScriptEnabled(true);
        coursesWebView.getSettings().setAppCacheEnabled(true);

        //change here your url and run code in android studio..//

        coursesWebView.loadUrl("http://www.familyplanning.org.nz/courses");
        swipe.setRefreshing(true);
        coursesWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                coursesWebView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (coursesWebView.canGoBack()) {
            coursesWebView.goBack();
        } else {
            finish();
        }



    }
}
