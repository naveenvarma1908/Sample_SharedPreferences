package com.naveen.samplesharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        getSupportActionBar().hide();

        sharedPreferences = getSharedPreferences("Naveen",MODE_PRIVATE);


        final String loginstate = sharedPreferences.getString("LoginState","");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    Thread.sleep(3000);

                    if (loginstate.equals("0")) {
                        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }else if (loginstate.equals("1"))
                    {
                        Intent intent = new Intent(SplashScreen.this, WelcomeActivity.class);
                        startActivity(intent);
                        finish();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();

    }
}
