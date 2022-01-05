package edu.virtualcare;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityDuvidas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_duvidas);


        WebView webView = (WebView) findViewById(R.id.wv_content);
        webView.loadUrl("file:///android_asset/duvidas_frequentes.html");
    }

}
