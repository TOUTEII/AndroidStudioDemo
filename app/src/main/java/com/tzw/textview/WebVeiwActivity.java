package com.tzw.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebVeiwActivity extends AppCompatActivity {
    private WebView mWvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_veiw);
        mWvMain=findViewById(R.id.webview);
        //load local html
        //mWvMain.loadUrl("file:///android_asset/test.html");
        //load website from www
        mWvMain.getSettings().setJavaScriptEnabled(true);
        mWvMain.setWebViewClient(new MyWebViewClient());
        mWvMain.setWebChromeClient(new MyWebChromeClient());
        //mWvMain.evaluateJavascript();
        mWvMain.loadUrl("https://m.baidu.com");
    }

    class MyWebChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }



    class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url=request.getUrl().toString();
            try{
                if(url.startsWith("https:") || url.startsWith("https:")){
                    view.loadUrl(url);
                }else{
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
                return true;
            }catch(Exception e){
                return false;
            }

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView","OnPageStarted");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView","OnPageStarted");
            //mWvMain.addJavascriptInterface();
            //mWvMain.loadUrl("javascript:alert('hello')");
            mWvMain.evaluateJavascript("javascript:alert('hello')",null);

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && mWvMain.canGoBack()){
            mWvMain.goBack();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
