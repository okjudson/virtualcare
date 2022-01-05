package edu.virtualcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {


    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;


    private View mContentView;
    private View mControlsView;
    private boolean mVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);


            //definindo logo do app no action bar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_paginaweb);

        //webview
        WebView webView;
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://www.judsonnunes.com/p/vindodoapp.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());;
        webView.getSettings().setBuiltInZoomControls(true);
        webView.invokeZoomPicker();
        webView.clearCache(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);


}
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//Handle the back button
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            Intent voltahome = new Intent(this, MainActivity.class);
            startActivity(voltahome);
            finish();
        } else {
            return super.onKeyDown(keyCode, event);
        }

        return false;
    }
}
