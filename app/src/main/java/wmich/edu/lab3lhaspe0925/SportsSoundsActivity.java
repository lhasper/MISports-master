package wmich.edu.lab3lhaspe0925;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SportsSoundsActivity extends Activity {
    private Button btnFrazier,btnMiracle,btnBackToMain;
    private MediaPlayer mpFrazier,mpMiracle;
    private int playing;
    private String strPause="Pause";
    private String strMiracle="Hear Miracle On Ice";
    private String strFrazier="Hear Frazier Goes Down";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_sounds);

        btnFrazier=(Button)findViewById(R.id.btnFrazier);
        btnMiracle=(Button)findViewById(R.id.btnMiracle);
        btnBackToMain=(Button)findViewById(R.id.btnMediaPlayerBack);
        btnBackToMain.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 startActivity(new Intent(SportsSoundsActivity.this, MainActivity.class));
                                             }
                                         });

        btnFrazier.setOnClickListener(bFrazier);
        btnMiracle.setOnClickListener(bMiracle);
        mpFrazier = new MediaPlayer();
        mpMiracle = new MediaPlayer();
        mpFrazier=MediaPlayer.create(this,R.raw.frazierdown);
        mpMiracle=MediaPlayer.create(this,R.raw.miracleonice);
        playing=0;

    }
    private Button.OnClickListener bFrazier=new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            switch (playing){
                case 0:
                    mpFrazier.start();
                    playing=1;
                    btnFrazier.setText(strPause);
                    btnMiracle.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpFrazier.pause();
                    playing=0;
                    btnFrazier.setText(strFrazier);
                    btnMiracle.setVisibility(View.VISIBLE);
                    break;
                default:
                    mpFrazier.pause();
                    playing=0;
                    btnFrazier.setText(strFrazier);
                    btnMiracle.setVisibility(View.VISIBLE);
                    break;

            }
        }

    };

    private Button.OnClickListener bMiracle=new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            switch (playing){
                case 0:
                    mpMiracle.start();
                    playing=1;
                    btnMiracle.setText(strPause);
                    btnFrazier.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpMiracle.pause();
                    playing=0;
                    btnMiracle.setText(strMiracle);
                    btnFrazier.setVisibility(View.VISIBLE);
                    break;
                default:
                    mpMiracle.pause();
                    playing=0;
                    btnMiracle.setText(strMiracle);
                    btnFrazier.setVisibility(View.VISIBLE);
                    break;

            }
        }

    };
}
