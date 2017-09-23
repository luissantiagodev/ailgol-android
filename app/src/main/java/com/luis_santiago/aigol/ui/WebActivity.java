package com.luis_santiago.aigol.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.utils.tools.Keys.Keys;

public class WebActivity extends AppCompatActivity {

    private WebView webView;
    private Toolbar textView;
    private final String TAG = WebActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        init();
        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString(Keys.URL_BASE_NEWS);
        textView.setTitle("News");
        Log.e(TAG, url);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        webView.loadUrl(url);
    }

    private void init(){
        webView = (WebView) findViewById(R.id.web_view);
        textView = (Toolbar) findViewById(R.id.text_bar_toolbar);
    }
}
