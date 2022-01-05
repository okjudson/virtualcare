package edu.virtualcare.lista;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.virtualcare.R;

public class SelectedUserActivity extends AppCompatActivity {

    TextView tvUser;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);

        tvUser = findViewById(R.id.selectedUser);


        Intent intent =getIntent();


        if(intent.getExtras() != null){
            UserModel userModel = (UserModel) intent.getSerializableExtra("data");
            tvUser.setText(userModel.getUserName());


        }

    }
    //aqui eu verifico a conexão com a internet
    public boolean conexaointernet(){
        ConnectivityManager cm =
                (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (isConnected == true){
            //Toast.makeText(getApplicationContext(), "Conectado.", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Não foi possível conectar a internet, cheque a sua conexão tente novamente.", Toast.LENGTH_LONG).show();
        }
        return isConnected;
    }

    //

}
