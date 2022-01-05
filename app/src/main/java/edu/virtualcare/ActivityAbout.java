package edu.virtualcare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class ActivityAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
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

    public void startInstagram(View view) {

        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://instagram.com/_u/" + "calcularmediaunip"));
            intent.setPackage("com.instagram.android");
            startActivity(intent);
        }
        catch (android.content.ActivityNotFoundException anfe)
        {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/calcularmediaunip")));
        }

        Toast.makeText(getApplicationContext(), "siga e fique sabendo de todas as novidades!", Toast.LENGTH_SHORT).show();
    }



    //chamar tela da politica de privacidade
    public void startPriv(View view) {

        Intent startPriv = new Intent(this, PoliticaPrivacidadeActivity.class);
        startActivity(startPriv);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
