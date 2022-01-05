package edu.virtualcare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.navigation.NavigationView;

import edu.virtualcare.lista.MainSelectedUserActivity;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    // codigos do na navigation drawer
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    // fim nav drawer

    // Aqui acaba a primeira parte do código do admob interti

    // Aqui vai a primeira parte do admob



    // Aqui vai a primeira parte do admob

    private Button bt_gestao2, bt_graduacao2,  bt_notas2, bt_praticadoc2, bt_duvidas2, bt_tcc2;

    private ImageView navigation;
    private AdView mAdView;


    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    RecyclerView recyclerView;
    LinearLayoutManager manager;
    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    String token = "";
    SpinKitView progress;
    RelativeLayout card1;
    RelativeLayout card2;
    TextView titletv, desctv;

    String facebookId = "fb://page/929786787054404";
    String urlPage = "https://www.facebook.com/CalcularMediaUnip";





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_sankar);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().hide();//Ocultar ActivityBar anterior



        initNavigationDrawer();
        //Card1();
        //Card2();
        //Navigation();
        //getData();









    }



    public void Backbtn(){
        ImageView backbtn;
        backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initNavigationDrawer();
                            }
        });

    }

    public void Publi() {
        final AdView mAdView = (AdView) findViewById(R.id.adView);
        mAdView.setVisibility(View.GONE);
        mAdView.setAdListener(new AdListener() {
            private void showToast(String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded() {
                //showToast("Anúncio carregado!");
                if (mAdView.getVisibility() == View.GONE) {
                    mAdView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                showToast("Você pode estar sem conexão com a internet.");
            }


            @Override
            public void onAdOpened() {
                showToast("Obrigado por interagir com os anúcios");
            }

            @Override
            public void onAdClosed() {
                //showToast("Ad closed.");
            }

            @Override
            public void onAdLeftApplication() {
                showToast("Você está sendo redirecionado para a página do anúncio fora do aplicativo.");
            }
        });


        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void initNavigationDrawer() {

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.home:
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;


                    case R.id.mavaliar:
                        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.judsonnunes.calcularmedia");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent2);
                        drawerLayout.closeDrawers();
                        Toast.makeText(getApplicationContext(), "Nos avalie com 5 estrelas <3", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.polpriv:
                        Intent intent12 =new Intent(getApplicationContext() ,PoliticaPrivacidadeActivity.class);
                        startActivity(intent12);
                        drawerLayout.closeDrawers();
                        Toast.makeText(getApplicationContext(), "Política de Privacidade", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.msair:
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);

                }
                return true;

            }
        });





        // navigation drawer
        View header = navigationView.getHeaderView(0);

        TextView tv_email = header.findViewById(R.id.tv_email);
        TextView tv_email3 = header.findViewById(R.id.tv_email3);
        TextView tv_email4 = header.findViewById(R.id.tv_email4);


        tv_email.setText("Em um relacionamento sério");
        tv_email3.setText("com a minha pele");
        tv_email4.setText("");


        drawerLayout = findViewById(R.id.ScrollView);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.drawer_open, R.string.drawer_close){

            @Override

            public void onDrawerClosed(View v){

                super.onDrawerClosed(v);

            }

            @Override

            public void onDrawerOpened(View v) {

                super.onDrawerOpened(v);

            }

        };

        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();


//


    }

    private void startFacebook() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookId )));
        } catch (Exception e) {
            //Log.e(TAG, "Application not intalled.");
            //Open url web page.
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlPage)));
        }
           }

    private void startInstagram() {
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
    }



    private void setUpToolbar()
    {
        drawerLayout = findViewById(R.id.ScrollView);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }








 /* // sair clicanco no voltar do celular
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//Handle the back button
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder dialogosair = new AlertDialog.Builder(MainActivity.this);
            //setando título
            dialogosair.setTitle("VERSÃO PRO");
            // setando mensagem
            dialogosair.setMessage("Agora temos uma versão PRO, sem anúncios, mais estável e em breve com funcionalidades exclusivas, por apenas R$1,00.  \nPedimos também para que nos avalie na Play Store com 5 estrelas. \nObrigado :)");
            // setando para avaliar na playstore
            dialogosair.setNeutralButton("AVALIAR", neprivate void startActivityGestao() {
    }w DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which) {
                    String url = "https://play.google.com/store/apps/details?id=com.judsonnunes.calcularmedia";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                    // aqui podemos fechar o app com - finish();
                    // mas vamos chamar a activity pra iluminar com a tela


                }

            });
            // setando botão APP
            dialogosair.setNegativeButton("APP PRO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    String url = "https://play.google.com/store/apps/details?id=com.judsonnunes.calcularmediaPro";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                    // aqui podemos fechar o app com - finish();
                    // mas vamos chamar a activity pra iluminar com a tela


                }

            });

            // setando botão
            dialogosair.setPositiveButton(" SAIR ", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    //Stop the activity
                    MainActivity.this.finish();
                    // Aqui começa a segunda parte do código do admob
                    //tirei pra fazer propaganda do app pro
                    //launchInter();
                    //loadInterstitial();

                    // Aqui termina a segunda parte do código do admob
                }

            });
            // chamando o AlertDialog
            dialogosair.show();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
            }

        }

//reiranto o arteristico e a barra para usar o codigo
*/




// activity site
    public void startActivityNews(View view) {

        Intent secondActivity4 = new Intent(this, MainSelectedUserActivity.class);
        startActivity(secondActivity4);
    }

    public void startActivityEditorial(View view) {

        Intent secondActivity4 = new Intent(this, ActivitySiteEditorial.class);
        startActivity(secondActivity4);
    }

    public void startActivityAnamnese(View view) {

        Intent secondActivity4 = new Intent(this, ActivitySiteAnamnese.class);
        startActivity(secondActivity4);
    }

    public void startDrawer (View view) {

        initNavigationDrawer();


    }




    //implementado em 28/06/2016
    // chamando tela para usuário avaliar aplicativo
    public void startAvaliar(View view) {

        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.judsonnunes.calcularmedia");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Nos avalie com 5 estrelas <3", Toast.LENGTH_SHORT).show();
    }

    // chamando tela para usuário abrir secretaria virtual da unip



    //alarm
    public void startAlarm(View view) {

        Intent startAssinatura = new Intent(this, ActivityAlarm.class);
        startActivity(startAssinatura);
    }

    // tive que criar novo layout e tambem novo activity - activitySiteUnip
    public void startUnip(View view) {

        Intent startUnip1 = new Intent(this, ActivitySiteNews.class);
        // Chamando interticial
        //launchInter();
        //loadInterstitial();
        // chamando interticial
        startActivity(startUnip1);

    }

  

    //chamar tela activity das duvidas frenquentes
    public void startDuv(View view) {

        Intent startDuv = new Intent(this, ActivityDuvidas.class);
        startActivity(startDuv);
    }

    // chamando playstore com app PRO
    public void startPro(View view) {

        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.judsonnunes.calcularmediaPro");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
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


    // aqui chama a tela para calcular com a nova formula
    // chamando activity gestão
    public void startSite(View view) {

        Uri uri = Uri.parse("https://gfa.unip.br/aluno/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    // configuração de menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        switch (item.getItemId())
        {


            // menu compartilhar com botão


            // configurando ação menu sobre o app
            case R.id.about:
                Intent intent9=new Intent(getApplicationContext() ,ActivityAbout.class);
                startActivity(intent9);
                break;

        }


        return super.onOptionsItemSelected(item);
    }
    //aqui termina configuração de menu




// Aqui Termina a Terceira Parte do código do Admob

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }





}




