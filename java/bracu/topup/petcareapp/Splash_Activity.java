package bracu.topup.petcareapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import bracu.topup.petcareapp.AccountActivity_firebase.Login_Activity;


public class Splash_Activity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Activity.this, Login_Activity.class );
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);


        //animation
        YoYo.with(Techniques.FadeIn)
                .duration(1500)
                .repeat(0)
                .playOn(findViewById(R.id.imgLogo));
        YoYo.with(Techniques.FlipInX)
                .duration(1300)
                .repeat(0)
                .playOn(findViewById(R.id.splashtext));

    }
}
