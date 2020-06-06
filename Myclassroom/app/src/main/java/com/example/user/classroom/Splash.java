package com.example.user.classroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView ( R.layout.activity_splash );

            final Intent i = new Intent(Splash.this,Login.class);
            Thread timer = new Thread(){
                public void run (){
                    try{
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        startActivity(i);
                        finish();

                    }
                }
            };
            timer.start();

        }
    }

