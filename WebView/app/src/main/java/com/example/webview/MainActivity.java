package com.example.webview;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        webView = findViewById(R.id.web);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.com");
        //Pentru a funciona linkul trebui sa adaugam in manifest.xml permisiunea pentru internet si wifi+android:usesCleartextTraffic="true"
        //pentr a da back din aplicatie folosim getOnBackPressesDispatcher + functia callback

        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    OnBackPressedCallback callback = new OnBackPressedCallback(true ){
        @Override
        public void handleOnBackPressed() {
            if(webView.canGoBack()){
                webView.goBack();
            }else{
                finish();
            }
        }
    };



}