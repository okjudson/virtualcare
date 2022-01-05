package edu.virtualcare;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class PoliticaPrivacidadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politica_privacidade);

        WebView webView = (WebView) findViewById(R.id.wv_content);
        webView.loadUrl("file:///android_asset/politica_privacidade.html");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
