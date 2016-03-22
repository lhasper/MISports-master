package wmich.edu.lab3lhaspe0925;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask timerCountDown=new TimerTask() {
            @Override
            public void run() {//timerCountDown is name of method that sets time that splash screen is displayed.
                finish();//when allotted seconds have passed
                //start the main activity
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        };
        Timer timerToClose=new Timer();//timerToClose calls timerCountDown
        timerToClose.schedule(timerCountDown, 5000);//The countdown is five seconds.
    }
}
