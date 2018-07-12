package com.skill.develoment.skilldevelopment.web_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;

import com.skill.develoment.skilldevelopment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewActivity extends AppCompatActivity implements WVC_ToActivityCallBack {

    @BindView(R.id.web_view)
    WebView myWebView;
    @BindView(R.id.progress_rl)
    RelativeLayout progress_rl;

    @OnClick(R.id.progress_rl)
    public void onClickProgress() {
        progress_rl.setVisibility(View.GONE);
    }

    private final String URL_LOAD = "https://indianexpress.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        setUpWebView();
    }

    private void setUpWebView() {
        myWebView.loadUrl(URL_LOAD);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        myWebView.setWebViewClient(new MyWebViewClient(this));
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onFinishedLoadingPage() {
        progress_rl.setVisibility(View.GONE);
    }
}
