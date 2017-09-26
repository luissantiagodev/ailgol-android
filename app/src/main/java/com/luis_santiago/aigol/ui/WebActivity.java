package com.luis_santiago.aigol.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.luis_santiago.aigol.R;
import com.luis_santiago.aigol.utils.tools.Keys.Keys;

public class WebActivity extends AppCompatActivity {

    private WebView webView;
    private Toolbar mToolbar;
    private ProgressBar mProgressBar;
    private final String TAG = WebActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        init();
        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString(Keys.URL_BASE_NEWS);
        loadToolbar();
        mProgressBar.setMax(100);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mProgressBar.setProgress(newProgress);
                super.onProgressChanged(view,newProgress);
            }
        });
        //After loading our bundle object we load our url
        webView.setVerticalScrollBarEnabled(false);
        webView.loadUrl(url);
        mProgressBar.setProgress(0);
    }

    private void init(){
        webView = (WebView) findViewById(R.id.web_view);
        mProgressBar = (ProgressBar) findViewById(R.id.progess_web_bar);
    }

    private void loadToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.text_bar_toolbar);
        mToolbar.setTitle("News");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: {
                finish();
                break;
            }
        }
        return true;
    }
}
