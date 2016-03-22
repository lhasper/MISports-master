package wmich.edu.lab3lhaspe0925;

import android.app.Activity;
import android.content.Intent;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class PistonsWeb extends Activity {
    String url="http://www.nba.com/pistons/?hp=1&ls=iref:pistons:gameexp:returnbutton";
    Intent loadWebsite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pistons_web);

       WebView wvPistons=(WebView)findViewById(R.id.webViewPistons);
        Button btnWebBack = (Button) findViewById(R.id.btnWebBack);
        wvPistons=new WebView(this);
        wvPistons.setWebViewClient(new WebViewClient());






        btnWebBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PistonsWeb.this,MainActivity.class));
            }
        });


        }
   /* public boolean shouldOverideUrlLoading(WebView view, String url, Button btnWebBack) {
        if (Uri.parse(url).getHost().endsWith(url)) {
            loadWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nba.com/pistons/?hp=1&ls=iref:pistons:gameexp:returnbutton"));
            WebSettings webSettings=view.getSettings();
            webSettings.setJavaScriptEnabled(false);
            view.getContext().startActivity(loadWebsite);
            btnWebBack.setVisibility(View.VISIBLE);
            return true;

        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(webDefault);
        return false;
    }*/

    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_BACK) {
            startActivity(new Intent(PistonsWeb.this, MainActivity.class));

            //WebBrowser.this.onDestroy();

        }

        return super.onKeyDown(keycode, event);
    }


    }






